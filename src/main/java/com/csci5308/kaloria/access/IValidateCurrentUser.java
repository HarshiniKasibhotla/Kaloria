package com.csci5308.kaloria.access;

import java.sql.SQLException;

public interface IValidateCurrentUser {
	
	public boolean validateCurrentUser(String emailId, String Password) throws SQLException;

}
