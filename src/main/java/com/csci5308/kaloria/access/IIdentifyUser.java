package com.csci5308.kaloria.access;

import java.sql.SQLException;

public interface IIdentifyUser {

	public String identifyAndValidateUser(String userId, String password) throws SQLException;
}
