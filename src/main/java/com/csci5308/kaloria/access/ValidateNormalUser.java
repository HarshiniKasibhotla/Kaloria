package com.csci5308.kaloria.access;

import java.sql.SQLException;

import com.csci5308.kaloria.access.calculators.IPasswordEncryption;
import com.csci5308.kaloria.access.calculators.PasswordEncryption;
import com.csci5308.kaloria.access.user.IUserPersistance;
import com.csci5308.kaloria.access.user.UserPersistance;

public class ValidateNormalUser implements IValidateCurrentUser {

	IUserPersistance userPersistence = new UserPersistance();

	IPasswordEncryption passwordEncryption = new PasswordEncryption();
	
	@Override
	public boolean validateCurrentUser(String emailId, String password) {

		String passwordFromDB;
		try {
			passwordFromDB = userPersistence.getPassword(emailId);
			if (passwordFromDB.equals(passwordEncryption.encryptPassword(password))) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
