package eu.supersede.dynadapt.modelrepository.manager.database;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;

import com.mysql.jdbc.exceptions.MySQLNonTransientConnectionException;

import eu.supersede.dynadapt.modelrepository.manager.enums.ModelType;
import eu.supersede.dynadapt.modelrepository.manager.enums.Status;
import eu.supersede.dynadapt.modelrepository.model.IModel;
import eu.supersede.dynadapt.modelrepository.model.TypedModelId;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class DatabaseController implements IDatabaseController {
	
	final static Logger logger = Logger.getLogger(DatabaseController.class);
	
	private final String packageRoute = "eu.supersede.dynadapt.modelrepository.model.";
	
	private Connection con;
	
	private ContentFileManager contentFileManager;

	public DatabaseController(String modelStoragePath) throws Exception {
		DatabaseConnection dbConn = new DatabaseConnection();
		contentFileManager = new ContentFileManager(modelStoragePath);
		con = dbConn.init();
	}

	@Override
	public List<IModel> getAllModels(ModelType type) throws Exception {
		String query = "SELECT * FROM " + type;  
		return queryModels(type, query);
	}

	@Override
	public IModel createModel(ModelType type, IModel model) throws Exception {
		
		String keys = "";
		String values = "";
		
		for (Field f : model.getFields()) {
			f.setAccessible(true);
			//Array of dependencies is parsed in "type/id;type/id;[...]" format
			if (f.getName().equals("dependencies")) {
				keys += f.getName() + ",";
				List<TypedModelId> dependencies = (List<TypedModelId>) f.get(model);
				String value = "";
				if (dependencies != null) for (TypedModelId typedModelId: dependencies) value += typedModelId.getModelType() + "/" + typedModelId.getNumber() + ";";
				if (value.length() > 0) {
					value = value.substring(0, value.length()-1);
				} else value = null;
				values += "\"" + value + "\","; 
			}
			else if (!f.getName().equals("id") && !f.getName().equals("modelContent")) {
				keys += f.getName() + ",";
				values += "\"" + f.get(model) + "\",";
			}
		}
				
		keys = keys.substring(0, keys.length()-1);
		values = values.substring(0, values.length()-1);
		Statement stm = con.createStatement();
		String sql = "INSERT INTO " + type
				+ " (" + keys + ")"
				+ " VALUES "
				+ " (" + values + ")";
		try {
			stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		} catch (MySQLNonTransientConnectionException e) {
			resetDBConnection();
			stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		} 
		ResultSet rs = stm.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		model.setValue("id", String.valueOf(id));
		
		String path = contentFileManager.saveModelContent(model);
		
		stm.close();
		stm = con.createStatement();
		sql = "UPDATE " + type + " SET filePath=\"" + path + "\" WHERE id = " + id;
		try {
			stm.executeUpdate(sql);
		} catch (MySQLNonTransientConnectionException e) {
			resetDBConnection();
			stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		} finally {
			stm.close();
		}
			
		return model;
	}
	
	@Override
	public IModel getModel(TypedModelId typedModelId) throws Exception {
		return getModel(typedModelId.getModelType(), typedModelId.getNumber());
	}

	@Override
	public IModel getModel(ModelType type, String id) throws Exception {
		
		Map<String,String> properties = new HashMap<>();
		Class classObject = Class.forName(packageRoute + type);
		IModel model = (IModel) classObject.newInstance();
		
		Statement stm = con.createStatement();
		ResultSet rs = null;
		try {
			rs = stm.executeQuery("SELECT * FROM " + type + " WHERE id = " + id);
		} catch (MySQLNonTransientConnectionException e) {
			resetDBConnection();
			rs = stm.executeQuery("SELECT * FROM " + type + " WHERE id = " + id);
		} 
		ResultSetMetaData rsmd = rs.getMetaData();
		
		if (!rs.next()) throw new Exception("There is no " + type + " with this id");
		
		for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
			if (!rsmd.getColumnName(i).equals("filePath")) {
				String name = rsmd.getColumnName(i);
				if (name.equals("creationDate") || name.equals("lastModificationDate")) {
					model.setValue(name, rs.getTimestamp(name));
				} else if (name.equals("dependencies")) {
					List<TypedModelId> dependencies = new ArrayList<>();
					String value = rs.getString(name);
					String[] dependencyArray = value.split(";");
					for (String s : dependencyArray) {
						String[] pair = s.split("/");
						if (pair.length == 2) {
							ModelType modelType = ModelType.valueOf(pair[0]);
							dependencies.add(new TypedModelId(modelType, pair[1]));
						}
					}
					model.setValue("dependencies", dependencies);
				}
				else if (name.equals("relativePath")) {
					model.setValue("relativePath", URI.createURI(rs.getString(name))); 
				} 
				else model.setValue(name, rs.getString(name));

			}
		}
		String content = contentFileManager.loadModelContent(model);
		model.setValue("modelContent", content);
		stm.close();
		
		return model;

	}

	/*@Override
	public IModel updateModel(ModelType type, String id, Map<String,String> propertySet) throws Exception {
		
		IModel model = getModel(type, id);
		if (model == null) throw new Exception("There is no " + type + " with this id");
		
		String newValues = "";
		//FIXME update dependencies
		for (String key: propertySet.keySet()) {
			model.setValue(key, propertySet.get(key));
			if (!key.equals("modelContent")) {
				newValues += key + "=\"" + propertySet.get(key) + "\",";
			}
		}
		String path = contentFileManager.saveModelContent(model);
		newValues = newValues.substring(0,newValues.length() - 1);
		newValues += ",filePath=\"" + path + "\"";
		
		Statement updateStm = con.createStatement();
		String sql = "UPDATE " + type
				+ " SET " + newValues
				+ " WHERE id = " + id;
		try {
			updateStm.executeUpdate(sql);
		} catch (MySQLNonTransientConnectionException e) {
			resetDBConnection();
			updateStm.executeUpdate(sql);
		}
		
		return model;
		
	}*/
	
	public IModel updateModel(ModelType type, String id, IModel model) throws Exception {
		
		IModel oldModel = getModel(type, id);
		if (oldModel == null) throw new Exception("There is no " + type + " with this id");
		
		String values = "";
		
		for (Field f : model.getFields()) {
			f.setAccessible(true);
			//Array of dependencies is parsed in "type/id;type/id;[...]" format
			if (f.getName().equals("dependencies")) {
				List<TypedModelId> dependencies = (List<TypedModelId>) f.get(model);
				String value = "";
				if (dependencies != null) for (TypedModelId typedModelId: dependencies) value += typedModelId.getModelType() + "/" + typedModelId.getNumber() + ";";
				if (value.length() > 0) {
					value = value.substring(0, value.length()-1);
					values += " dependencies=\"" + value + "\",";
				}
			}
			else if (!f.getName().equals("id") && !f.getName().equals("modelContent")) {
				if (f.get(model) != null) values += " " + f.getName() + "=\"" + f.get(model) + "\",";
			}
		}
		
		if (model.getValue("modelContent") != null) {
			String path = contentFileManager.saveModelContent(model);
			values += " filePath=\"" + path + "\"";
		} else values = values.substring(0,values.length()-1);
		
		Statement updateStm = con.createStatement();
		String sql = "UPDATE " + type
				+ " SET " + values
				+ " WHERE id = " + id;
		try {
			updateStm.executeUpdate(sql);
		} catch (MySQLNonTransientConnectionException e) {
			resetDBConnection();
			updateStm.executeUpdate(sql);
		} finally {
			updateStm.close();
		}
		
		return getModel(type, id);
		
	}

	@Override
	public void deleteModel(ModelType type, String id) throws Exception {

		IModel model = getModel(type,id);
		Statement stm = con.createStatement();
		ResultSet rs = null;
		try {
			rs = stm.executeQuery("SELECT * FROM " + type + " WHERE id = " + id);
		} catch (MySQLNonTransientConnectionException e) {
			resetDBConnection();
			rs = stm.executeQuery("SELECT * FROM " + type + " WHERE id = " + id);
		} 
		if (!rs.next()) throw new Exception("There is no " + type + " for this id");
			
		Statement deleteStm = con.createStatement();
		
		try {
			deleteStm.executeUpdate("DELETE FROM " + type + " WHERE id = " + id);
		} catch (MySQLNonTransientConnectionException e) {
			resetDBConnection();
			deleteStm.executeUpdate("DELETE FROM " + type + " WHERE id = " + id);
		} finally {
			stm.close();
			deleteStm.close();
		}
		
		contentFileManager.deleteModelContent(model);
			
	}
	
	@Override
	public List<IModel> getModels(ModelType type, HashMap<String,String> params) throws Exception {
		if (params.containsKey("systemId")) 
			ModelSystem.valueOf(params.get("systemId"));
		if (params.containsKey("status"))
			Status.valueOf(params.get("status"));
		String sql = "SELECT * FROM " + type;
		boolean first = true;
		for (String key : params.keySet()) {
			if (first) {
				first = false;
				sql += " WHERE";
			} else {
				sql += " AND";
			}
			sql += " " + key + " = '" + params.get(key) + "'";
		}
		return queryModels(type, sql);
	}
	
	private void resetDBConnection() throws Exception {
		DatabaseConnection dbConn = new DatabaseConnection();
		this.con = dbConn.init();
	}
	
	@Override
	public List<IModel> getModels(ModelType type, ModelSystem systemId) throws Exception {
		String query = "SELECT * FROM " + type + " WHERE systemId = '" + systemId + "'"; 
		return queryModels(type, query);
	}
	
	@Override
	public List<IModel> getModels(ModelType type, ModelSystem systemId, Status status) throws Exception {
		String query = "SELECT * FROM " + type + " WHERE systemId = '" + systemId + "' AND status = '" + status + "'";  
		return queryModels(type, query);
	}
	
	@Override
	public List<IModel> getModels(ModelType type, Status status) throws Exception {
		String query = "SELECT * FROM " + type + " WHERE status = '" + status + "'";  
		return queryModels(type, query);
	}
	
	@Override
	public List<IModel> getModels(ModelType type, URI relativePath) throws Exception {
		String query = "SELECT * FROM " + type + " WHERE relativePath = '" + relativePath + "'";
		return queryModels(type, query);
	}
	
	private List<IModel> queryModels(ModelType type, String query) throws Exception {
		
		List<IModel> modelList = new ArrayList<IModel>();
		
		Class classObject = Class.forName(packageRoute + type);
		
		Statement stm = con.createStatement();
		ResultSet rs = null;
		try {
			rs = stm.executeQuery(query);
		} catch (MySQLNonTransientConnectionException e) {
			resetDBConnection();
			rs = stm.executeQuery(query);
		} 
		ResultSetMetaData rsmd = rs.getMetaData();
		
		while (rs.next()) {
			IModel model = (IModel) classObject.newInstance();
			for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
				String name = rsmd.getColumnName(i);
				if (!name.equals("filePath")) {
					if (name.equals("creationDate") || name.equals("lastModificationDate")) {
						model.setValue(name, rs.getTimestamp(name));
					} else if (name.equals("dependencies")) {
						List<TypedModelId> dependencies = new ArrayList<>();
						String value = rs.getString(name);
						String[] dependencyArray = value.split(";");
						for (String s : dependencyArray) {
							String[] pair = s.split("/");
							if (pair.length == 2) {
								ModelType modelType = ModelType.valueOf(pair[0]);
								dependencies.add(new TypedModelId(modelType, pair[1]));
							}
						}
						model.setValue("dependencies", dependencies);
					} else if (name.equals("relativePath")) {
						model.setValue("relativePath", URI.createURI(rs.getString(name))); 
					} 
					else model.setValue(name, rs.getString(name));
				} 
			}
			modelList.add(model);
		}
		stm.close();
			
		return modelList;
	}
	
}
