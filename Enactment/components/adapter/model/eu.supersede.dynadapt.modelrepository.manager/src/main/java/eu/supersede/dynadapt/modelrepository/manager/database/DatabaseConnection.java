package eu.supersede.dynadapt.modelrepository.manager.database;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DatabaseConnection {
	
	final static Logger logger = Logger.getLogger(DatabaseConnection.class);
	
	private Connection connection;

	public Connection initConnection() throws Exception {
		
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.debug("JDBC driver - ERROR (not found)");
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		
		Properties prop = new Properties();
		InputStream input = getClass().getResourceAsStream("config.properties");
		if (input == null) {
<<<<<<< HEAD
=======
			logger.debug("Properties file - ERROR (not found)");
>>>>>>> multimodel-saver-loader
			throw new FileNotFoundException("The properties file was not found");
		}
		prop.load(input);
		
		String host = prop.getProperty("dbhost");
		String user = prop.getProperty("dbuser");
		String password = prop.getProperty("dbpassword");
		
		logger.debug("Connecting to DB...");
		
		//try {
			Connection con = DriverManager.getConnection(host, user, password);
			logger.debug("Database connection - SUCCESS");
			this.connection = con;
			return this.connection;
		//} catch (SQLException e) {
		//	logger.debug("Database connection - ERROR (wrong credentials - check config.properties file)");
		//	throw new IllegalStateException("Cannot connect to the database with the specified credentials!");
		//}
		
	}
	
	public void closeConnection() throws Exception {
		this.connection.close();
	}
	
}
