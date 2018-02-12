package eu.supersede.feedbackgathering.reconfiguration.util;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import org.junit.Assert;

public class ReconfigurationCommon {

	public static Path createTemporaryDirectory() throws IOException{
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir);
		Path temp = Files.createTempDirectory(path, "");
		Assert.assertNotNull("There was a problem creating a temporary directory", temp);
		return temp;
	}
	
	public static Properties loadProperties(ClassLoader obj) throws IOException{
		final Properties properties = new Properties();
		properties.load(obj.getResourceAsStream("feedback.properties"));
		return properties;
	}
}
