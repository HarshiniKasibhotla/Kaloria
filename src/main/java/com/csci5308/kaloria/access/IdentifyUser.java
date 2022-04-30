package com.csci5308.kaloria.access;

import java.sql.SQLException;

import com.csci5308.kaloria.utilities.Constants;

public class IdentifyUser implements IIdentifyUser, Constants {

	@Override
	public String identifyAndValidateUser(String userId, String password) throws SQLException {

		IValidateCurrentUser validateUser = IdentifyCurrentUserFactory.getInstance(userId);

		boolean isValidUser = false;

		if (userId.equals("admin")) {
			if (password.equals("admin")) {
				return ADMIN;
			} else {
				return "";
			}
		} else if (userId.startsWith("DIET")) {
			isValidUser = validateUser.validateCurrentUser(userId, password);
			if (isValidUser) {
				return DIETICIAN;
			}
		} else {
			isValidUser = validateUser.validateCurrentUser(userId, password);
			if (isValidUser) {
				return USER;
			}
		}

		return "";
	}

}
