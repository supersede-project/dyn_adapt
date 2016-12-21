package eu.supersede.dynadapt.modelrepository.model;

import java.lang.reflect.Field;

public abstract class IModel {

	public void setValue(String property, String value) throws Exception{
		
		Field f = this.getClass().getDeclaredField(property);
		f.setAccessible(true);
		f.set(this, value);

	}

	public String getValue(String property) throws Exception {
		
		Field f = this.getClass().getDeclaredField(property);
		f.setAccessible(true);
		return (String) f.get(this);
		
	}
}
