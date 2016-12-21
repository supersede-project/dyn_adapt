package eu.supersede.dynadapt.modelrepository.manager.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import eu.supersede.dynadapt.modelrepository.model.IModel;

public class DatabaseController implements IDatabaseController {
	
	private final String packageRoute = "eu.supersede.dynadapt.modelrepository.model.";
	
	private Connection con;

	public DatabaseController() {
		try {
			con = DatabaseConnection.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<IModel> getAllModels(String type) throws Exception {
		
		List<IModel> modelList = new ArrayList<IModel>();
		
		try {
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
			
		} catch (ClassNotFoundException e) {
			throw new Exception();
		}
		return modelList;
	}

	public IModel createModel(String type, JsonObject params) {
		// TODO Auto-generated method stub
		return null;
	}

	public JsonObject getValues(String type, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public IModel updateModel(String type, String id, JsonObject params) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteModel(String type, String id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
