package eu.supersede.dynadapt.modelrepository.model;

<<<<<<< HEAD
import java.sql.Timestamp;

public class VariantModel extends IModel {
	
	private String id;
	private String name;
	private String authorId;
	private Timestamp creationDate;
	private Timestamp lastModificationDate;
	private String fileExtension;
	private String systemId;
	private String modelContent;
	
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
=======
public class VariantModel extends GenericModel {
>>>>>>> multimodel-saver-loader
	
}
