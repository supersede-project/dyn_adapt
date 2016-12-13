package eu.supersede.dynadapt.modelrepository.manager.database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

	public static void init() throws Exception {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("config.properties");
		prop.load(input);
		
		String host = prop.getProperty("dbhost");
		String user = prop.getProperty("dbuser");
		String password = prop.getProperty("dbpassword");
		
		Connection con = DriverManager.getConnection(host, user, password);
		
	}
	
}
