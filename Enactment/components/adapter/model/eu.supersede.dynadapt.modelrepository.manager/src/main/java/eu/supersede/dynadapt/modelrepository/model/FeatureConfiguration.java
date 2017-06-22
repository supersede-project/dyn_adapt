package eu.supersede.dynadapt.modelrepository.model;

<<<<<<< HEAD
import java.sql.Timestamp;

public class FeatureConfiguration extends IModel {
	
	private String id;
	private String name;
	private String authorId;
	private Timestamp creationDate;
	private Timestamp lastModificationDate;
	private String fileExtension;
	private String systemId;
=======
public class FeatureConfiguration extends GenericModel {
	
>>>>>>> multimodel-saver-loader
	private String status;
	
<<<<<<< HEAD
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
	public void setCreationTimestamp(Timestamp creationDate) {
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
=======
>>>>>>> multimodel-saver-loader
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
