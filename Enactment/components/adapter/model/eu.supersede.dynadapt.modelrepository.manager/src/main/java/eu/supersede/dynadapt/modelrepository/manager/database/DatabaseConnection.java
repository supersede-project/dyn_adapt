package eu.supersede.dynadapt.modelrepository.manager.database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

	public Connection init() throws Exception {
		
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		
		Properties prop = new Properties();
		InputStream input = getClass().getResourceAsStream("config.properties");
		if (input == null) System.out.println("UPS");
		prop.load(input);
		
		String host = prop.getProperty("dbhost");
		String user = prop.getProperty("dbuser");
		String password = prop.getProperty("dbpassword");
		
		System.out.println("Connecting to DB...");
		
		try {
			return DriverManager.getConnection(host, user, password);
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect to the database with the specified credentials!");
		}
		
	}
	
}
