package eu.supersede.dynadapt.modelrepository.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.modelrepository.model.AdaptabilityModel;
import eu.supersede.dynadapt.modelrepository.model.IModel;

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
	
	/*@Test
	public void listAdaptabilityModels() {
		try {
			List<IModel> models = manager.listAllModels("AdaptabilityModel");
			System.out.println("Number of AdaptabilityModels: " + models.size());
			for (IModel model : models) System.out.println("\tModel id: " + model.getValue("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	@Test
	public void createAdaptabilityModel() {
		IModel model = generateAdaptabilityModelData();
		try {
			IModel newModel = manager.createModel("AdaptabilityModel", model);
			String id = newModel.getValue("id");
			assertEquals(newModel.getValue("name"),"AdaptModelA");
			assertEquals(newModel.getValue("authorId"),"SUPERSEDE");
			assertEquals(newModel.getValue("creationDate"),"2016-09-30 01:25:37.0");
			assertEquals(newModel.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
			assertEquals(newModel.getValue("fileExtension"),".uml");
			assertEquals(newModel.getValue("systemId"),"MonitoringReconfiguration");
			assertEquals(newModel.getValue("featureId"),"Feat1");
			System.out.println("Model created successfully (id = " + id + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createSetOfAdaptabilityModels() {
		List<IModel> propertySetList = new ArrayList<>();
		propertySetList.add(generateAdaptabilityModelData());
		propertySetList.add(generateAdaptabilityModelData());
		try {
			List<IModel> models = manager.createModels("AdaptabilityModel", propertySetList);
			String ids = "";
			for (IModel model : models) {
				assertEquals(model.getValue("name"),"AdaptModelA");
				assertEquals(model.getValue("authorId"),"SUPERSEDE");
				assertEquals(model.getValue("creationDate"),"2016-09-30 01:25:37.0");
				assertEquals(model.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
				assertEquals(model.getValue("fileExtension"),".uml");
				assertEquals(model.getValue("systemId"),"MonitoringReconfiguration");
				assertEquals(model.getValue("featureId"),"Feat1");
				ids += model.getValue("id") + "/";
			}
			System.out.println("Models created successfully (id list = " + ids + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndGetModel() {
		IModel model = generateAdaptabilityModelData();
		try {
			IModel newModel = manager.createModel("AdaptabilityModel", model);
			IModel getModel = manager.getModel("AdaptabilityModel", newModel.getValue("id"));
			assertEquals(getModel.getValue("name"),"AdaptModelA");
			assertEquals(getModel.getValue("authorId"),"SUPERSEDE");
			assertEquals(getModel.getValue("creationDate"),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("fileExtension"),".uml");
			assertEquals(getModel.getValue("systemId"),"MonitoringReconfiguration");
			assertEquals(getModel.getValue("featureId"),"Feat1");
			System.out.println("Model created and retrieved successfully (id = " + getModel.getValue("id") + ")");
			manager.deleteModel("AdaptabilityModel", getModel.getValue("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndDeleteModel() {
		IModel model = generateAdaptabilityModelData();
		try {
			IModel newModel = manager.createModel("AdaptabilityModel", model);
			manager.deleteModel("AdaptabilityModel", newModel.getValue("id"));
			try {
				manager.getModel("AdaptabilityModel", newModel.getValue("id"));
			} catch (Exception e) {
				System.out.println("Model created and deleted successfully (id = " + newModel.getValue("id") + ")");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndUpdateModel() {
		Map<String,String> propertySet = new HashMap<>();
		propertySet.put("name", "AdaptModelB");
		propertySet.put("modelContent", "NewContent");
		IModel model = generateAdaptabilityModelData();
		try {
			IModel createModel = manager.createModel("AdaptabilityModel", model);
			IModel updateModel = manager.updateModel("AdaptabilityModel", createModel.getValue("id"), propertySet);
			assertEquals(updateModel.getValue("name"), "AdaptModelB");
			assertEquals(updateModel.getValue("modelContent"), "NewContent");
			System.out.println("Model created and updated successfully (id = " + updateModel.getValue("id") + ")");
			manager.deleteModel("AdaptabilityModel", updateModel.getValue("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private IModel generateAdaptabilityModelData() {
		AdaptabilityModel model = new AdaptabilityModel();
		model.setName("AdaptModelA");
		model.setAuthorId("SUPERSEDE");
		model.setCreationDate("2016-09-30 01:25:37.0");
		model.setLastModificationDate("2016-09-30 01:25:37.0");
		model.setFileExtension(".uml");
		model.setSystemId("MonitoringReconfiguration");
		model.setFeatureId("Feat1");
		return model;
	}

}
