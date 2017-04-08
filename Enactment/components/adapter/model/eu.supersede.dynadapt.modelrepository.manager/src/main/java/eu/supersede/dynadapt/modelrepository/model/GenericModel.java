package eu.supersede.dynadapt.modelrepository.model;

import java.sql.Timestamp;
import java.util.List;

public class GenericModel extends IModel {
	
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

}
