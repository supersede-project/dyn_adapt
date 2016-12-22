package eu.supersede.dynadapt.modelrepository.model;

import java.lang.reflect.Field;

public abstract class IModel {

	public void setValue(String property, String value) throws Exception {
		
		Field f;
		try {
			f = this.getClass().getDeclaredField(property);
		} catch (NoSuchFieldException e1) {
			throw new Exception("This type of model does not have a " + property + " field");
		} 
		f.setAccessible(true);
		f.set(this, value);

	}

	public String getValue(String property) throws Exception {
		
		Field f;
		try {
			f = this.getClass().getDeclaredField(property);
		} catch (NoSuchFieldException e1) {
			throw new Exception("This type of model does not have a " + property + " field");
		} 
		f.setAccessible(true);
		return (String) f.get(this);
		
	}
}
