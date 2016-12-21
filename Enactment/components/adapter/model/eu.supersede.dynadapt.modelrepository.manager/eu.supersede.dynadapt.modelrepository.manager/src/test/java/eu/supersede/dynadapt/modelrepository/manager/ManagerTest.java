package eu.supersede.dynadapt.modelrepository.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.modelrepository.model.IModel;

public class ManagerTest {
	
	Manager manager;
	
	@Before
	public void setUp() {
		manager = new Manager();
	}
	
	@Test
	public void listAdaptabilityModels() {
		try {
			List<IModel> models = manager.listAllModels("AdaptabilityModel");
			System.out.println("Number of AdaptabilityModels: " + models.size());
			for (IModel model : models) System.out.println("\tModel id: " + model.getValue("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAdaptabilityModel() {
		Map<String,String> propertySet = generateAdaptabilityModelData();
		try {
			IModel model = manager.createModel("AdaptabilityModel", propertySet);
			assertEquals(model.getValue("name"),"AdaptModelA");
			assertEquals(model.getValue("url"),"/path/to/model");
			assertEquals(model.getValue("authorId"),"SUPERSEDE");
			assertEquals(model.getValue("creationDate"),"2016-09-30 01:25:37.0");
			assertEquals(model.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
			assertEquals(model.getValue("fileExtension"),".uml");
			assertEquals(model.getValue("systemId"),"SYS1");
			assertEquals(model.getValue("featureId"),"Feat1");
			System.out.println("Model created successfully (id = " + model.getValue("id") + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndGetModel() {
		Map<String,String> propertySet = generateAdaptabilityModelData();
		try {
			IModel newModel = manager.createModel("AdaptabilityModel", propertySet);
			IModel getModel = manager.getModel("AdaptabilityModel", newModel.getValue("id"));
			assertEquals(getModel.getValue("name"),"AdaptModelA");
			assertEquals(getModel.getValue("url"),"/path/to/model");
			assertEquals(getModel.getValue("authorId"),"SUPERSEDE");
			assertEquals(getModel.getValue("creationDate"),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("lastModificationDate"),"2016-09-30 01:25:37.0");
			assertEquals(getModel.getValue("fileExtension"),".uml");
			assertEquals(getModel.getValue("systemId"),"SYS1");
			assertEquals(getModel.getValue("featureId"),"Feat1");
			System.out.println("Model created and retrieved successfully (id = " + getModel.getValue("id") + ")");
			manager.deleteModel("AdaptabilityModel", getModel.getValue("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndDeleteModel() {
		Map<String,String> propertySet = generateAdaptabilityModelData();
		try {
			IModel model = manager.createModel("AdaptabilityModel", propertySet);
			manager.deleteModel("AdaptabilityModel", model.getValue("id"));
			try {
				manager.getModel("AdaptabilityModel", model.getValue("id"));
			} catch (Exception e) {
				System.out.println("Model created and deleted successfully (id = " + model.getValue("id") + ")");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAndUpdateModel() {
		Map<String,String> propertySet = new HashMap<>();
		propertySet.put("name", "AdaptModelB");
		propertySet.put("url", "/new/path/to/model");
		Map<String,String> propertySetCreateModel = generateAdaptabilityModelData();
		try {
			IModel createModel = manager.createModel("AdaptabilityModel", propertySetCreateModel);
			IModel updateModel = manager.updateModel("AdaptabilityModel", createModel.getValue("id"), propertySet);
			assertEquals(updateModel.getValue("name"), "AdaptModelB");
			assertEquals(updateModel.getValue("url"), "/new/path/to/model");
			System.out.println("Model created and updated successfully (id = " + updateModel.getValue("id") + ")");
			manager.deleteModel("AdaptabilityModel", updateModel.getValue("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Map<String,String> generateAdaptabilityModelData() {
		Map<String,String> propertySet = new HashMap<>();
		propertySet.put("name", "AdaptModelA");
		propertySet.put("url", "/path/to/model");
		propertySet.put("authorId", "SUPERSEDE");
		propertySet.put("creationDate", "2016-09-30 01:25:37.0");
		propertySet.put("lastModificationDate", "2016-09-30 01:25:37.0");
		propertySet.put("fileExtension", ".uml");
		propertySet.put("systemId", "SYS1");
		propertySet.put("featureId", "Feat1");
		return propertySet;
	}

}
