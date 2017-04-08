package eu.supersede.dynadapt.modelrepository.manager;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.modelrepository.manager.enums.ModelType;
import eu.supersede.dynadapt.modelrepository.manager.enums.Status;
import eu.supersede.dynadapt.modelrepository.model.AdaptabilityModel;
import eu.supersede.dynadapt.modelrepository.model.BaseModel;
import eu.supersede.dynadapt.modelrepository.model.IModel;
import eu.supersede.dynadapt.modelrepository.model.TypedModelId;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class ManagerTest {
	
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
			System.out.println("Number of AdaptabilityModels: " + models.size());
			for (IModel model : models) System.out.println("\tModel id: " + model.getValue("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAdaptabilityModel() {
		try {
			IModel model = generateAdaptabilityModelData();
			IModel newModel = manager.createModel(ModelType.AdaptabilityModel, model);
			String id = newModel.getValue("id").toString();
			assertEquals(newModel.getValue("name"),"AdaptModelA");
			assertEquals(newModel.getValue("authorId"),"SUPERSEDE");
			assertEquals(newModel.getValue("creationDate"),"2016-09-30 01:25:37.0");
			assertEquals(newModel.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
			assertEquals(newModel.getValue("fileExtension"),".aspect");
			assertEquals(newModel.getValue("systemId"),ModelSystem.MonitoringReconfiguration.toString());
			assertEquals(newModel.getValue("featureId"),"Feat1");
			assertEquals(newModel.getValue("relativePath"), "/path/to/model");
			System.out.println("Model created successfully (id = " + id + ")");
			manager.deleteModel(ModelType.AdaptabilityModel, id);
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
			List<IModel> models = manager.createModels(ModelType.AdaptabilityModel, propertySetList);
			String ids = "";
			for (IModel model : models) {
				assertEquals(model.getValue("name"),"AdaptModelA");
				assertEquals(model.getValue("authorId"),"SUPERSEDE");
				assertEquals(model.getValue("creationDate"),"2016-09-30 01:25:37.0");
				assertEquals(model.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
				assertEquals(model.getValue("fileExtension"),".aspect");
				assertEquals(model.getValue("systemId"),ModelSystem.MonitoringReconfiguration.toString());
				assertEquals(model.getValue("featureId"),"Feat1");
				assertEquals(model.getValue("relativePath"), "/path/to/model");
				ids += model.getValue("id") + "/";
			}
			System.out.println("Models created successfully (id list = " + ids + ")");
			for (IModel model : models) {
				manager.deleteModel(ModelType.AdaptabilityModel, model.getValue("id").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndGetAdaptabilityModel() {
		try {
			IModel model = generateAdaptabilityModelData();
			IModel newModel = manager.createModel(ModelType.AdaptabilityModel, model);
			IModel getModel = manager.getModel(ModelType.AdaptabilityModel, newModel.getValue("id").toString());
			assertEquals(getModel.getValue("name"),"AdaptModelA");
			assertEquals(getModel.getValue("authorId"),"SUPERSEDE");
			assertEquals(getModel.getValue("creationDate"),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("fileExtension"),".aspect");
			assertEquals(getModel.getValue("systemId"),ModelSystem.MonitoringReconfiguration.toString());
			assertEquals(getModel.getValue("featureId"),"Feat1");
			assertEquals(getModel.getValue("relativePath"), "/path/to/model");
			System.out.println("Model created and retrieved successfully (id = " + getModel.getValue("id") + ")");
			manager.deleteModel(ModelType.AdaptabilityModel, getModel.getValue("id").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndDeleteModel() {
		try {
			IModel model = generateAdaptabilityModelData();
			IModel newModel = manager.createModel(ModelType.AdaptabilityModel, model);
			manager.deleteModel(ModelType.AdaptabilityModel, newModel.getValue("id").toString());
			try {
				manager.getModel(ModelType.AdaptabilityModel, newModel.getValue("id").toString());
			} catch (Exception e) {
				System.out.println("Model created and deleted successfully (id = " + newModel.getValue("id") + ")");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndUpdateModel() {
		try {
			Map<String,String> propertySet = new HashMap<>();
			propertySet.put("name", "AdaptModelB");
			propertySet.put("modelContent", "NewContent");
			IModel model = generateAdaptabilityModelData();
			IModel createModel = manager.createModel(ModelType.AdaptabilityModel, model);
			IModel updateModel = manager.updateModel(ModelType.AdaptabilityModel, createModel.getValue("id").toString(), propertySet);
			assertEquals(updateModel.getValue("name"), "AdaptModelB");
			assertEquals(updateModel.getValue("modelContent"), "NewContent");
			System.out.println("Model created and updated successfully (id = " + updateModel.getValue("id") + ")");
			manager.deleteModel(ModelType.AdaptabilityModel, updateModel.getValue("id").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndGetBaseModel() {
		try {
			IModel model = generateBaseModelData();
			IModel newModel = manager.createModel(ModelType.BaseModel, model);
			IModel getModel = manager.getModel(ModelType.BaseModel, newModel.getValue("id").toString());
			assertEquals(getModel.getValue("name"),"BaseModelA");
			assertEquals(getModel.getValue("authorId"),"SUPERSEDE");
			assertEquals(getModel.getValue("creationDate"),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("fileExtension"),".uml");
			assertEquals(getModel.getValue("systemId"),ModelSystem.MonitoringReconfiguration.toString());
			assertEquals(getModel.getValue("relativePath"), "/path/to/model");
			List<TypedModelId> dependencies = getModel.getDependencies();
			for (TypedModelId typedModelId : dependencies) {
				assertEquals(typedModelId.getModelType(), ModelType.ProfileModel);
				assertEquals(typedModelId.getNumber(), "1");
			}
			System.out.println("Model created and retrieved successfully (id = " + getModel.getValue("id") + ")");
			manager.deleteModel(ModelType.BaseModel, getModel.getValue("id").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndGetModelsBySystemId() {
		try {
			IModel model = generateBaseModelData();
			IModel newModel = manager.createModel(ModelType.BaseModel, model);
			List<IModel> models = manager.getModels(ModelType.BaseModel, ModelSystem.MonitoringReconfiguration);
			for (IModel m : models) {
				assertEquals(ModelSystem.MonitoringReconfiguration.toString(), m.getValue("systemId"));
			}
			manager.deleteModel(ModelType.BaseModel, newModel.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndGetModelsBySystemIdAndStatus() {
		try {
			IModel model = generateBaseModelData();
			IModel newModel = manager.createModel(ModelType.BaseModel, model);
			List<IModel> models = manager.getModels(ModelType.BaseModel, ModelSystem.MonitoringReconfiguration, Status.Enacted);
			for (IModel m : models) {
				assertEquals(ModelSystem.MonitoringReconfiguration.toString(), m.getValue("systemId"));
				assertEquals(Status.Enacted.toString(), m.getValue("status"));
			}
			manager.deleteModel(ModelType.BaseModel, newModel.getId());
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
		model.setSystemId(ModelSystem.MonitoringReconfiguration.toString());
		model.setFeatureId("Feat1");
		model.setRelativePath("/path/to/model");
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
		model.setSystemId(ModelSystem.MonitoringReconfiguration.toString());
		model.setStatus(Status.Enacted.toString());
		model.setRelativePath("/path/to/model");
		model.setDependencies(generateDependenciesList());
		File f = new File("");
		List<String> lines = Files.readAllLines(Paths.get(f.getAbsolutePath() + "/src/test/java/eu/supersede/dynadapt/modelrepository/manager/MonitoringSystemBaseModel.uml"), StandardCharsets.UTF_8);
		String content = "";
		for (String s : lines) content += s + "\n";
		content = content.replace("\"","'");
		model.setModelContent(content);
		return model;
	}
	
	private List<TypedModelId> generateDependenciesList() {
		List<TypedModelId> dependencies = new ArrayList<>();
		dependencies.add(new TypedModelId(ModelType.ProfileModel,"1"));
		dependencies.add(new TypedModelId(ModelType.ProfileModel,"1"));
		return dependencies;
	}

}
