package com.csci5308.kaloria.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	static DataBaseConfiguration config = new DataBaseConfiguration();

	private static String dbUrl = config.getDatabaseURL();
	private static String dbUserName = config.getDatabaseUserName();
	private static String dbPassword = config.getDatabasePassword();

	public static Connection getDBConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
	}

	
	
}
