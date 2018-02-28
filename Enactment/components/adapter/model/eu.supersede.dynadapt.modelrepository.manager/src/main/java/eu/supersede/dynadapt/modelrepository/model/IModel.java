package eu.supersede.dynadapt.modelrepository.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class IModel {
	final static Logger logger = Logger.getLogger(IModel.class);

	public void setValue(String property, Object value) throws Exception {
		
		Field f;
		try {
			f = this.getClass().getDeclaredField(property);
		} catch (NoSuchFieldException e1) {
			try {
				f = this.getClass().getSuperclass().getDeclaredField(property);
			} catch (NoSuchFieldException e2) {
				throw new Exception("This type of model does not have a " + property + " field");

			}
		} 
		f.setAccessible(true);
		f.set(this, value);

	}

	public Object getValue(String property) throws Exception {
		
		Field f;
		try {
			f = this.getClass().getDeclaredField(property);
		} catch (NoSuchFieldException e1) {
			try {
				f = this.getClass().getSuperclass().getDeclaredField(property);
			} catch (NoSuchFieldException e2) {
				throw new Exception("This type of model does not have a " + property + " field");

			}
		} 
		f.setAccessible(true);
		return f.get(this);
		
	}
	
	public List<Field> getFields() {
		
		Field[] fields1 = this.getClass().getDeclaredFields();
		Field[] fields2 = this.getClass().getSuperclass().getDeclaredFields();
		
		List<Field> fields = new ArrayList<>();
		
		for (Field f : fields1) fields.add(f);
		for (Field f : fields2) fields.add(f);
		
		return fields;
				
	}
	
	public boolean validateFields() throws IllegalAccessException {
		List<Field> fields = getFields();
		for (Field f: fields) {
			f.setAccessible(true);
			if (!f.getName().equals("id") && f.get(this) == null){
				logger.debug("Validation error. Empty field: " + f.getName());
				return false;
			}
		}
		return true;
	}
	
	public JSONObject toJson() throws IllegalAccessException {
		JSONObject json = new JSONObject();
		
		List<Field> fields = getFields();
		for (Field f: fields) {
			f.setAccessible(true);
			if (f.getName().equals("dependencies")) {
				List<TypedModelId> dependencies = (List<TypedModelId>) f.get(this);
				JSONArray list = new JSONArray();
				for (TypedModelId dependency : dependencies) {
					JSONObject dependencyJson = new JSONObject();
					dependencyJson.put("modelType", dependency.getModelType());
					dependencyJson.put("number", dependency.getNumber());
					list.put(dependencyJson);
				}
				json.put("dependencies", list);
			} else json.put(f.getName(), f.get(this));
		}
		return json;
	}
	
}
