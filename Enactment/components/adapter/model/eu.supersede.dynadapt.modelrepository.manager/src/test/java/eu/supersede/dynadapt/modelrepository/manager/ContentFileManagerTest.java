package eu.supersede.dynadapt.modelrepository.manager;

import static org.junit.Assert.*;

import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.modelrepository.manager.database.ContentFileManager;
import eu.supersede.dynadapt.modelrepository.manager.database.IContentFileManager;
import eu.supersede.dynadapt.modelrepository.model.AdaptabilityModel;
import eu.supersede.dynadapt.modelrepository.model.IModel;

public class ContentFileManagerTest {
	
	IContentFileManager contentFileManager;
	
	@Before
	public void setUp() {
		contentFileManager = new ContentFileManager("../repository");
	}
	
	@Test
	public void saveFile() {
		IModel model = generateAdaptabilityModelData();
		try {
			contentFileManager.saveModelContent(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void loadFile() {
		IModel model = generateAdaptabilityModelData();
		try {
			String path = contentFileManager.saveModelContent(model);
			String content = contentFileManager.loadModelContent(model);
			assertEquals(content, model.getValue("modelContent"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteFile() {
		IModel model = generateAdaptabilityModelData();
		try {
			String path = contentFileManager.saveModelContent(model);
			contentFileManager.deleteModelContent(model);
			String content = contentFileManager.loadModelContent(model);
			assertEquals(null, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void deleteDirectories() {
		deleteDir(new File("../repository"));
	}
	
	private boolean deleteDir(File dir) {
	    if (dir.isDirectory()) {
	        String[] children = dir.list();
	        for (int i = 0; i < children.length; i++) {
	            boolean success = deleteDir(new File(dir, children[i]));
	            if (!success) {
	                return false;
	            }
	        }
	    }

	    return dir.delete(); // The directory is empty now and can be deleted.
	}
	
	private IModel generateAdaptabilityModelData() {
		AdaptabilityModel model = new AdaptabilityModel();
		model.setId("1");
		model.setFileExtension(".uml");
		model.setSystemId("MonitoringReconfiguration");
		model.setModelContent("<xml><tag>Hello!</tag></xml>");
		return model;
	}

}
