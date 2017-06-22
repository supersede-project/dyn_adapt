package eu.supersede.dynadapt.modelrepository.manager;

import static org.junit.Assert.assertEquals;
<<<<<<< HEAD

import java.io.File;
import java.io.IOException;
=======
import static org.junit.Assert.assertNotEquals;

import java.io.File;
>>>>>>> multimodel-saver-loader
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
<<<<<<< HEAD
import java.text.SimpleDateFormat;
=======
>>>>>>> multimodel-saver-loader
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.modelrepository.manager.enums.ModelType;
import eu.supersede.dynadapt.modelrepository.manager.enums.Status;
import eu.supersede.dynadapt.modelrepository.model.AdaptabilityModel;
import eu.supersede.dynadapt.modelrepository.model.BaseModel;
import eu.supersede.dynadapt.modelrepository.model.IModel;
import eu.supersede.dynadapt.modelrepository.model.IModelId;
import eu.supersede.dynadapt.modelrepository.model.TypedModelId;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class ManagerTest {
	
	final static Logger logger = Logger.getLogger(ManagerTest.class);
	
	Manager manager;
	
	@Before
	public void setUp() {
		
		try {
			manager = new Manager("../repository");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void listAdaptabilityModels() {
		try {
			List<IModel> models = manager.listAllModels(ModelType.AdaptabilityModel);
			logger.debug("Number of AdaptabilityModels: " + models.size());
			for (IModel model : models) logger.debug("\tModel id: " + model.getValue("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAdaptabilityModel() {
		try {
			IModel model = generateAdaptabilityModelData();
<<<<<<< HEAD
			IModel newModel = manager.createModel("AdaptabilityModel", model);
			String id = newModel.getValue("id").toString();
			assertEquals(newModel.getValue("name"),"AdaptModelA");
			assertEquals(newModel.getValue("authorId"),"SUPERSEDE");
			assertEquals(newModel.getValue("creationDate"),"2016-09-30 01:25:37.0");
			assertEquals(newModel.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
			assertEquals(newModel.getValue("fileExtension"),".aspect");
			assertEquals(newModel.getValue("systemId"),"MonitoringReconfiguration");
			assertEquals(newModel.getValue("featureId"),"Feat1");
			System.out.println("Model created successfully (id = " + id + ")");
			manager.deleteModel("AdaptabilityModel", id);
=======
			IModel newModel = manager.createModel(ModelType.AdaptabilityModel, model);
			String id = newModel.getValue("id").toString();
			assertEquals(newModel.getValue("name").toString(),"AdaptModelA");
			assertEquals(newModel.getValue("authorId").toString(),"SUPERSEDE");
			assertEquals(newModel.getValue("creationDate").toString(),"2016-09-30 01:25:37.0");
			assertEquals(newModel.getValue("lastModificationDate").toString(),"2016-09-30 01:25:37.0");
			assertEquals(newModel.getValue("fileExtension").toString(),".aspect");
			assertEquals(newModel.getValue("systemId").toString(),ModelSystem.MonitoringReconfiguration.toString());
			assertEquals(newModel.getValue("featureId").toString(),"Feat1");
			assertEquals(newModel.getValue("relativePath").toString(), "/path/to/model");
			logger.debug("Model created successfully (id = " + id + ")");
			manager.deleteModel(ModelType.AdaptabilityModel, id);
>>>>>>> multimodel-saver-loader
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createSetOfAdaptabilityModels() {
		try {
			List<IModel> propertySetList = new ArrayList<>();
			propertySetList.add(generateAdaptabilityModelData());
			propertySetList.add(generateAdaptabilityModelData());
<<<<<<< HEAD
			List<IModel> models = manager.createModels("AdaptabilityModel", propertySetList);
			String ids = "";
			for (IModel model : models) {
				assertEquals(model.getValue("name"),"AdaptModelA");
				assertEquals(model.getValue("authorId"),"SUPERSEDE");
				assertEquals(model.getValue("creationDate"),"2016-09-30 01:25:37.0");
				assertEquals(model.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
				assertEquals(model.getValue("fileExtension"),".aspect");
				assertEquals(model.getValue("systemId"),"MonitoringReconfiguration");
				assertEquals(model.getValue("featureId"),"Feat1");
=======
			List<IModel> models = manager.createModels(ModelType.AdaptabilityModel, propertySetList);
			String ids = "";
			for (IModel model : models) {
				assertEquals(model.getValue("name").toString(),"AdaptModelA");
				assertEquals(model.getValue("authorId").toString(),"SUPERSEDE");
				assertEquals(model.getValue("creationDate").toString(),"2016-09-30 01:25:37.0");
				assertEquals(model.getValue("lastModificationDate").toString(),"2016-09-30 01:25:37.0");
				assertEquals(model.getValue("fileExtension").toString(),".aspect");
				assertEquals(model.getValue("systemId").toString(),ModelSystem.MonitoringReconfiguration.toString());
				assertEquals(model.getValue("featureId").toString(),"Feat1");
				assertEquals(model.getValue("relativePath").toString(), "/path/to/model");
>>>>>>> multimodel-saver-loader
				ids += model.getValue("id") + "/";
			}
			logger.debug("Models created successfully (id list = " + ids + ")");
			for (IModel model : models) {
<<<<<<< HEAD
				manager.deleteModel("AdaptabilityModel", model.getValue("id").toString());
=======
				manager.deleteModel(ModelType.AdaptabilityModel, model.getValue("id").toString());
>>>>>>> multimodel-saver-loader
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndGetAdaptabilityModel() {
		try {
			IModel model = generateAdaptabilityModelData();
<<<<<<< HEAD
			IModel newModel = manager.createModel("AdaptabilityModel", model);
			IModel getModel = manager.getModel("AdaptabilityModel", newModel.getValue("id").toString());
			assertEquals(getModel.getValue("name"),"AdaptModelA");
			assertEquals(getModel.getValue("authorId"),"SUPERSEDE");
			assertEquals(getModel.getValue("creationDate"),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("fileExtension"),".aspect");
			assertEquals(getModel.getValue("systemId"),"MonitoringReconfiguration");
			assertEquals(getModel.getValue("featureId"),"Feat1");
			System.out.println("Model created and retrieved successfully (id = " + getModel.getValue("id") + ")");
			manager.deleteModel("AdaptabilityModel", getModel.getValue("id").toString());
=======
			IModel newModel = manager.createModel(ModelType.AdaptabilityModel, model);
			IModel getModel = manager.getModel(ModelType.AdaptabilityModel, newModel.getValue("id").toString());
			assertEquals(getModel.getValue("name").toString(),"AdaptModelA");
			assertEquals(getModel.getValue("authorId").toString(),"SUPERSEDE");
			assertEquals(getModel.getValue("creationDate").toString(),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("lastModificationDate").toString(),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("fileExtension").toString(),".aspect");
			assertEquals(getModel.getValue("systemId").toString(),ModelSystem.MonitoringReconfiguration.toString());
			assertEquals(getModel.getValue("featureId").toString(),"Feat1");
			assertEquals(getModel.getValue("relativePath").toString(), "/path/to/model");
			logger.debug("Model created and retrieved successfully (id = " + getModel.getValue("id") + ")");
			manager.deleteModel(ModelType.AdaptabilityModel, getModel.getValue("id").toString());
>>>>>>> multimodel-saver-loader
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndDeleteModel() {
		try {
			IModel model = generateAdaptabilityModelData();
<<<<<<< HEAD
			IModel newModel = manager.createModel("AdaptabilityModel", model);
			manager.deleteModel("AdaptabilityModel", newModel.getValue("id").toString());
			try {
				manager.getModel("AdaptabilityModel", newModel.getValue("id").toString());
=======
			IModel newModel = manager.createModel(ModelType.AdaptabilityModel, model);
			manager.deleteModel(ModelType.AdaptabilityModel, newModel.getValue("id").toString());
			try {
				manager.getModel(ModelType.AdaptabilityModel, newModel.getValue("id").toString());
>>>>>>> multimodel-saver-loader
			} catch (Exception e) {
				logger.debug("Model created and deleted successfully (id = " + newModel.getValue("id") + ")");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndUpdateModel() {
		try {
<<<<<<< HEAD
			Map<String,String> propertySet = new HashMap<>();
			propertySet.put("name", "AdaptModelB");
			propertySet.put("modelContent", "NewContent");
			IModel model = generateAdaptabilityModelData();
			IModel createModel = manager.createModel("AdaptabilityModel", model);
			IModel updateModel = manager.updateModel("AdaptabilityModel", createModel.getValue("id").toString(), propertySet);
			assertEquals(updateModel.getValue("name"), "AdaptModelB");
			assertEquals(updateModel.getValue("modelContent"), "NewContent");
			System.out.println("Model created and updated successfully (id = " + updateModel.getValue("id") + ")");
			manager.deleteModel("AdaptabilityModel", updateModel.getValue("id").toString());
=======
			IModel model = generateBaseModelData();
			IModel createModel = manager.createModel(ModelType.BaseModel, model);
			createModel.setValue("name", "NewName");
			createModel.setValue("modelContent", "NewContent");
			createModel.setValue("relativePath", "/new/relative/path");
			List<TypedModelId> dependencies = new ArrayList<>();
			dependencies.add(new TypedModelId(ModelType.ProfileModel, "1"));
			dependencies.add(new TypedModelId(ModelType.BaseModel, "2"));
			createModel.setValue("dependencies", dependencies);
			IModel updateModel = manager.updateModel(ModelType.BaseModel, createModel.getValue("id").toString(), createModel);
			assertEquals(updateModel.getValue("name").toString(), "NewName");
			assertEquals(updateModel.getValue("modelContent").toString(), "NewContent");
			assertEquals(updateModel.getValue("relativePath").toString(), "/new/relative/path");
			List<TypedModelId> updatedDep = (List<TypedModelId>) updateModel.getValue("dependencies");
			assertEquals(updatedDep.size(), 2);
			assertEquals(updatedDep.get(0).getModelType(), ModelType.ProfileModel);
			assertEquals(updatedDep.get(0).getNumber(), "1");
			assertEquals(updatedDep.get(1).getModelType(), ModelType.BaseModel);
			assertEquals(updatedDep.get(1).getNumber(), "2");
			logger.debug("Model created and updated successfully (id = " + updateModel.getValue("id") + ")");
			manager.deleteModel(ModelType.BaseModel, updateModel.getValue("id").toString());
>>>>>>> multimodel-saver-loader
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndGetBaseModel() {
		try {
			IModel model = generateBaseModelData();
<<<<<<< HEAD
			IModel newModel = manager.createModel("BaseModel", model);
			IModel getModel = manager.getModel("BaseModel", newModel.getValue("id").toString());
			assertEquals(getModel.getValue("name"),"BaseModelA");
			assertEquals(getModel.getValue("authorId"),"SUPERSEDE");
			assertEquals(getModel.getValue("creationDate"),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("fileExtension"),".uml");
			assertEquals(getModel.getValue("systemId"),"MonitoringReconfiguration");
			System.out.println("Model created and retrieved successfully (id = " + getModel.getValue("id") + ")");
			manager.deleteModel("BaseModel", getModel.getValue("id").toString());
=======
			IModel newModel = manager.createModel(ModelType.BaseModel, model);
			IModel getModel = manager.getModel(ModelType.BaseModel, newModel.getValue("id").toString());
			assertEquals(getModel.getValue("name").toString(),"BaseModelA");
			assertEquals(getModel.getValue("authorId").toString(),"SUPERSEDE");
			assertEquals(getModel.getValue("creationDate").toString(),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("lastModificationDate").toString(),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("fileExtension").toString(),".uml");
			assertEquals(getModel.getValue("systemId").toString(),ModelSystem.MonitoringReconfiguration.toString());
			assertEquals(getModel.getValue("relativePath").toString(), "/path/to/model");
			List<TypedModelId> dependencies = (List<TypedModelId>) getModel.getValue("dependencies");
			for (TypedModelId typedModelId : dependencies) {
				assertEquals(typedModelId.getModelType().toString(), ModelType.ProfileModel.toString());
				assertEquals(typedModelId.getNumber().toString(), "1");
			}
			logger.debug("Model created and retrieved successfully (id = " + getModel.getValue("id") + ")");
			//manager.deleteModel(ModelType.BaseModel, getModel.getValue("id").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndGetModelsBySystemId() {
		try {
			IModel model = generateBaseModelData();
			IModel newModel = manager.createModel(ModelType.BaseModel, model);
			HashMap<String, String> map = new HashMap<>();
			map.put("systemId", ModelSystem.MonitoringReconfiguration.toString());
			List<IModel> models = manager.getModels(ModelType.BaseModel, map);
			for (IModel m : models) {
				assertEquals(ModelSystem.MonitoringReconfiguration.toString(), m.getValue("systemId"));
			}
			manager.deleteModel(ModelType.BaseModel, newModel.getValue("id").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndGetModelsBySystemIdAndStatus() {
		try {
			IModel model = generateBaseModelData();
			IModel newModel = manager.createModel(ModelType.BaseModel, model);
			HashMap<String, String> map = new HashMap<>();
			map.put("systemId", ModelSystem.MonitoringReconfiguration.toString());
			map.put("status", Status.Enacted.toString());
			List<IModel> models = manager.getModels(ModelType.BaseModel, map);
			for (IModel m : models) {
				assertEquals(ModelSystem.MonitoringReconfiguration.toString(), m.getValue("systemId").toString());
				assertEquals(Status.Enacted.toString(), m.getValue("status").toString());
			}
			manager.deleteModel(ModelType.BaseModel, newModel.getValue("id").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndGetModelsByRelativePath() {
		try {
			IModel model = generateBaseModelData();
			IModel newModel = manager.createModel(ModelType.BaseModel, model);
			List<IModel> models = manager.getModels(ModelType.BaseModel,"/path/to/model");
			assertNotEquals(models.size(), 0);
			for (IModel m : models) {
				assertEquals("/path/to/model", m.getValue("relativePath"));
			}
>>>>>>> multimodel-saver-loader
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private IModel generateAdaptabilityModelData() throws Exception {
		AdaptabilityModel model = new AdaptabilityModel();
		model.setName("AdaptModelA");
		model.setAuthorId("SUPERSEDE");
		model.setCreationDate(Timestamp.valueOf("2016-09-30 01:25:37.0"));
		model.setLastModificationDate(Timestamp.valueOf("2016-09-30 01:25:37.0"));
		model.setFileExtension(".aspect");
<<<<<<< HEAD
		model.setSystemId("MonitoringReconfiguration");
		model.setFeatureId("Feat1");
=======
		model.setSystemId(ModelSystem.MonitoringReconfiguration.toString());
		model.setFeatureId("Feat1");
		model.setRelativePath("/path/to/model");
>>>>>>> multimodel-saver-loader
		File f = new File("");
		List<String> lines = Files.readAllLines(Paths.get(f.getAbsolutePath() + "/src/test/java/eu/supersede/dynadapt/modelrepository/manager/timeslot_twitter.aspect"), StandardCharsets.UTF_8);
		String content = "";
		for (String s : lines) content += s + "\n";
		model.setModelContent(content);
		return model;
	}
	
	private IModel generateBaseModelData() throws Exception {
		BaseModel model = new BaseModel();
		model.setName("BaseModelA");
		model.setAuthorId("SUPERSEDE");
		model.setCreationDate(Timestamp.valueOf("2016-09-30 01:25:37.0"));
		model.setLastModificationDate(Timestamp.valueOf("2016-09-30 01:25:37.0"));
		model.setFileExtension(".uml");
<<<<<<< HEAD
		model.setSystemId("MonitoringReconfiguration");
		model.setStatus("status");
=======
		model.setSystemId(ModelSystem.MonitoringReconfiguration.toString());
		model.setStatus(Status.Enacted.toString());
		model.setRelativePath("/path/to/model");
		model.setDependencies(generateDependenciesList());
>>>>>>> multimodel-saver-loader
		File f = new File("");
		List<String> lines = Files.readAllLines(Paths.get(f.getAbsolutePath() + "/src/test/java/eu/supersede/dynadapt/modelrepository/manager/MonitoringSystemBaseModel.uml"), StandardCharsets.UTF_8);
		String content = "";
		for (String s : lines) content += s + "\n";
		content = content.replace("\"","'");
		model.setModelContent(content);
		return model;
	}
	
	private List<IModelId> generateDependenciesList() {
		List<IModelId> dependencies = new ArrayList<>();
		dependencies.add(new TypedModelId(ModelType.ProfileModel,"1"));
		dependencies.add(new TypedModelId(ModelType.ProfileModel,"1"));
		return dependencies;
	}

}
