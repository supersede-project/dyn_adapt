package eu.supersede.dynadapt.modelrepository.model;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public abstract class IModel {
	
	private String id;
	private String name;
	private String authorId;
	private Timestamp creationDate;
	private Timestamp lastModificationDate;
	private String fileExtension;
	private String systemId;
	private String modelContent;
	private String relativePath;
	private List<TypedModelId> dependencies;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Timestamp getLastModificationDate() {
		return lastModificationDate;
	}
	public void setLastModificationDate(Timestamp lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getModelContent() {
		return modelContent;
	}
	public void setModelContent(String modelContent) {
		this.modelContent = modelContent;
	}
	public String getRelativePath() {
		return relativePath;
	}
	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}
	public List<TypedModelId> getDependencies() {
		return dependencies;
	}
	public void setDependencies(List<TypedModelId> dependencies) {
		this.dependencies = dependencies;
	}

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
		return f.get(this).toString();
		
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
