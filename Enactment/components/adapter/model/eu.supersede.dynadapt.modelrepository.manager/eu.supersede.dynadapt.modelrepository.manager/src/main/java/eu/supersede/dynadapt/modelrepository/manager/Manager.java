package eu.supersede.dynadapt.modelrepository.manager;

import java.sql.Connection;

import eu.supersede.dynadapt.modelrepository.manager.database.DatabaseConnection;

public class Manager {
	
	private Connection con;

	public Manager() {
		
		try {
			this.con = DatabaseConnection.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		return con;
	}
	
}
