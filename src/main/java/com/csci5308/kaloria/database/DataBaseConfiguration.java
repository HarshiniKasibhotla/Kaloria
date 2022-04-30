package com.csci5308.kaloria.database;

import com.csci5308.kaloria.utilities.Constants;

public class DataBaseConfiguration implements Constants {

	private static final String URL = System.getenv(DATABASE_URL);

	private static final String USER = System.getenv(DATABASE_USERNAME);

	private static final String PASSWORD = System.getenv(DATABASE_PASSWORD);

	public String getDatabaseUserName() {
		return USER;
	}

	public String getDatabasePassword() {
		return PASSWORD;
	}

	public String getDatabaseURL() {
		return URL;
	}
}
