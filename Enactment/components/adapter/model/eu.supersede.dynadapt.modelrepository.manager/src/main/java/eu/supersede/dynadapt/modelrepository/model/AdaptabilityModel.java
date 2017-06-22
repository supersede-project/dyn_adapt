package eu.supersede.dynadapt.modelrepository.model;

<<<<<<< HEAD
import java.sql.Timestamp;

public class AdaptabilityModel extends IModel {
	
	private String id;
	private String name;
	private String authorId;
	private Timestamp creationDate;
	private Timestamp lastModificationDate;
	private String fileExtension;
	private String systemId;
	private String featureId;
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
=======
public class AdaptabilityModel extends GenericModel {
	
	private String featureId;

>>>>>>> multimodel-saver-loader
	public String getFeatureId() {
		return featureId;
	}
	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

}
