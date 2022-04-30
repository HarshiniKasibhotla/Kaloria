package com.csci5308.kaloria.access.dietician;

import java.sql.SQLException;
import java.sql.Timestamp;

public interface IDieticianPersistence {

	public boolean createNewDietician(IDietician dieitician, int age, Timestamp sqlDate);

	public String getPassword(String userId) throws SQLException;

	IDietician getDieticianDetails(String registrationId) throws SQLException;

}
