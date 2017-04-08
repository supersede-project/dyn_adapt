package eu.supersede.dynadapt.modelrepository.model;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public abstract class IModel {

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
	
}
