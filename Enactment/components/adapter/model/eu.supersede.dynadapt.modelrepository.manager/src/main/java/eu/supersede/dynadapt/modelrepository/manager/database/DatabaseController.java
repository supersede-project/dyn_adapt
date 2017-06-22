package eu.supersede.dynadapt.modelrepository.manager.database;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import eu.supersede.dynadapt.modelrepository.manager.enums.ModelType;
import eu.supersede.dynadapt.modelrepository.manager.enums.Status;
import eu.supersede.dynadapt.modelrepository.model.IModel;
import eu.supersede.dynadapt.modelrepository.model.TypedModelId;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class DatabaseController implements IDatabaseController {
	
	final static Logger logger = Logger.getLogger(DatabaseController.class);
	
	private final String packageRoute = "eu.supersede.dynadapt.modelrepository.model.";
	
	private DatabaseConnection dbConn;
	private ContentFileManager contentFileManager;

	public DatabaseController(String modelStoragePath) throws Exception {
		this.dbConn = new DatabaseConnection();
		contentFileManager = new ContentFileManager(modelStoragePath);
	}

<<<<<<< HEAD
	public List<IModel> getAllModels(String type) throws Exception {
		
		List<IModel> modelList = new ArrayList<IModel>();
		
		Class classObject = Class.forName(packageRoute + type);
		
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM " + type);
		ResultSetMetaData rsmd = rs.getMetaData();
		
		while (rs.next()) {
			IModel model = (IModel) classObject.newInstance();
			for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
				String name = rsmd.getColumnName(i);
				if (!name.equals("filePath")) {
					if (name.equals("creationDate") || name.equals("lastModificationDate")) {
						model.setValue(name, rs.getTimestamp(name));
					}
					else model.setValue(name, rs.getString(name));
				}
			}
			modelList.add(model);
		}
			
		return modelList;
=======
	@Override
	public List<IModel> getAllModels(ModelType type) throws Exception {
		String query = "SELECT * FROM " + type;  
		return queryModels(type, query);
>>>>>>> multimodel-saver-loader
	}

	@Override
	public IModel createModel(ModelType type, IModel model) throws Exception {
		
		Connection con = null;
		Statement stm = null;
		
		try {
			
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
			con = dbConn.initConnection();
			stm = con.createStatement();
			String sql = "INSERT INTO " + type
					+ " (" + keys + ")"
					+ " VALUES "
					+ " (" + values + ")";
			stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			model.setValue("id", String.valueOf(id));
			
			String path = contentFileManager.saveModelContent(model);
			
			stm.close();
			rs.close();
			
			stm = con.createStatement();
			sql = "UPDATE " + type + " SET filePath=\"" + path + "\" WHERE id = " + id;
			
			stm.executeUpdate(sql);

		} finally {
			stm.close();
			dbConn.closeConnection();
		}
		
		return model;
		
	}
	
	@Override
	public IModel getModel(TypedModelId typedModelId) throws Exception {
		return getModel(typedModelId.getModelType(), typedModelId.getNumber());
	}

	@Override
	public IModel getModel(ModelType type, String id) throws Exception {
		
		Statement stm = null;
		ResultSet rs = null;
		IModel model = null;
		
<<<<<<< HEAD
		if (!rs.next()) throw new Exception("There is no " + type + " with this id");
		
		for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
			if (!rsmd.getColumnName(i).equals("filePath")) {
				String name = rsmd.getColumnName(i);
				if (name.equals("creationDate") || name.equals("lastModificationDate")) {
					model.setValue(name, rs.getTimestamp(name));
				}
				else model.setValue(name, rs.getString(name));
			}
=======
		try {
			
			Map<String,String> properties = new HashMap<>();
			Class classObject = Class.forName(packageRoute + type);
			model = (IModel) classObject.newInstance();
			
			Connection con = dbConn.initConnection();
			stm = con.createStatement();
			rs = stm.executeQuery("SELECT * FROM " + type + " WHERE id = " + id);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			if (!rs.next()) throw new NoSuchElementException("There is no " + type + " with this id");
			
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
					else model.setValue(name, rs.getString(name));

				}
			}
			String content = contentFileManager.loadModelContent(model);
			model.setValue("modelContent", content);
			
		} finally {
			stm.close();
			rs.close();
			dbConn.closeConnection();
>>>>>>> multimodel-saver-loader
		}

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
		
		Connection con = null;
		Statement updateStm = null;
		
		try {
			IModel oldModel = getModel(type, id);
			if (oldModel == null) throw new NoSuchElementException("There is no " + type + " with this id");
			
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
			
			con = dbConn.initConnection();
			updateStm = con.createStatement();
			String sql = "UPDATE " + type
					+ " SET " + values
					+ " WHERE id = " + id;
			
			updateStm.executeUpdate(sql);
			
			
		} finally {
			updateStm.close();
			dbConn.closeConnection();
		}
		
		return getModel(type, id);
		
	}

	@Override
	public void deleteModel(ModelType type, String id) throws Exception {
		
		ResultSet rs = null;
		Statement stm = null;
		Statement deleteStm = null;
		IModel model = null;

		try {
			model = getModel(type,id);
			Connection con = dbConn.initConnection();
			stm = con.createStatement();
			rs = stm.executeQuery("SELECT * FROM " + type + " WHERE id = " + id);
			if (!rs.next()) throw new NoSuchElementException("There is no " + type + " for this id");
				
			deleteStm = con.createStatement();
			
			deleteStm.executeUpdate("DELETE FROM " + type + " WHERE id = " + id);
		} finally {
			rs.close();
			stm.close();
			deleteStm.close();
			dbConn.closeConnection();
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
	public List<IModel> getModels(ModelType type, String relativePath) throws Exception {
		String query = "SELECT * FROM " + type + " WHERE relativePath = '" + relativePath + "'";
		return queryModels(type, query);
	}
	
	private List<IModel> queryModels(ModelType type, String query) throws Exception {
		
		List<IModel> modelList = new ArrayList<IModel>();
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			Class classObject = Class.forName(packageRoute + type);
			
			Connection con = dbConn.initConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(query);

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
						} else model.setValue(name, rs.getString(name));
					} 
				}
				modelList.add(model);
			}
		} finally {
			stm.close();
			rs.close();
			dbConn.closeConnection();
		}
		
		
			
		return modelList;
	}
	
}
