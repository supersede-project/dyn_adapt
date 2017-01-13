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

import com.google.gson.JsonObject;

import eu.supersede.dynadapt.modelrepository.model.IModel;

public class DatabaseController implements IDatabaseController {
	
	private final String packageRoute = "eu.supersede.dynadapt.modelrepository.model.";
	
	private Connection con;
	
	private ContentFileManager contentFileManager;

	public DatabaseController() throws Exception {
		DatabaseConnection dbConn = new DatabaseConnection();
		contentFileManager = new ContentFileManager();
		con = dbConn.init();
	}

	public List<IModel> getAllModels(String type) throws Exception {
		
		List<IModel> modelList = new ArrayList<IModel>();
		
		Class classObject = Class.forName(packageRoute + type);
		
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM " + type);
		ResultSetMetaData rsmd = rs.getMetaData();
		
		while (rs.next()) {
			IModel model = (IModel) classObject.newInstance();
			for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
				model.setValue(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
			}
			modelList.add(model);
		}
			
		return modelList;
	}

	public IModel createModel(String type, IModel model) throws Exception {
		
		String keys = "";
		String values = "";
		
		for (Field f : model.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			if (!f.getName().equals("id") && !f.getName().equals("modelContent")) {
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
		stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stm.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		model.setValue("id", String.valueOf(id));
		
		String path = contentFileManager.saveModel(model);
		model.setValue("filePath", path);
		
		stm = con.createStatement();
		sql = "UPDATE " + type + " SET filePath=\"" + path + "\" WHERE id = " + id;
		stm.executeUpdate(sql);
			
		return model;
	}

	public IModel getModel(String type, String id) throws Exception {
		
		Map<String,String> properties = new HashMap<>();
		Class classObject = Class.forName(packageRoute + type);
		IModel model = (IModel) classObject.newInstance();
		
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM " + type + " WHERE id = " + id);
		ResultSetMetaData rsmd = rs.getMetaData();
		
		if (!rs.next()) throw new Exception("There is no " + type + " with this id");
		
		for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
			model.setValue(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
		}
		model.setValue("modelContent", contentFileManager.loadModel(model.getValue("filePath")));
		
		return model;

	}

	public IModel updateModel(String type, String id, Map<String,String> propertySet) throws Exception {
		
		IModel model = getModel(type, id);
		if (model == null) throw new Exception("There is no " + type + " with this id");
		
		String newValues = "";
		for (String key: propertySet.keySet()) {
			if (!key.equals("modelContent")) {
				model.setValue(key, propertySet.get(key));
				newValues += key + "=\"" + propertySet.get(key) + "\",";
			}
		}
		String path = contentFileManager.saveModel(model);
		newValues = newValues.substring(0,newValues.length() - 1);
		if (!path.equals(model.getValue("filePath"))) newValues += ",filePath=\"" + path + "\"";
		
		Statement updateStm = con.createStatement();
		String sql = "UPDATE " + type
				+ " SET " + newValues
				+ " WHERE id = " + id;
		updateStm.executeUpdate(sql);
		
		return model;
		
	}

	public void deleteModel(String type, String id) throws Exception {

		IModel model = getModel(type,id);
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM " + type + " WHERE id = " + id);
		if (!rs.next()) throw new Exception("There is no " + type + " for this id");
			
		Statement deleteStm = con.createStatement();
		deleteStm.executeUpdate("DELETE FROM " + type + " WHERE id = " + id);
		
		contentFileManager.deleteModel(model.getValue("filePath"));
			
	}
	
}
