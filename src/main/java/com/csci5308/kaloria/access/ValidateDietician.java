package com.csci5308.kaloria.access;

import java.sql.SQLException;

import com.csci5308.kaloria.access.calculators.IPasswordEncryption;
import com.csci5308.kaloria.access.calculators.PasswordEncryption;
import com.csci5308.kaloria.access.dietician.DieticianPersistence;
import com.csci5308.kaloria.access.dietician.IDietician;
import com.csci5308.kaloria.access.dietician.IDieticianPersistence;

public class ValidateDietician implements IValidateCurrentUser {

	IDieticianPersistence dieticianPersistence = new DieticianPersistence();

	IPasswordEncryption passwordEncryption = new PasswordEncryption();

	@Override
	public boolean validateCurrentUser(String dieticianId, String password) {

		String passwordFromDB;
		boolean approvalIndicator = false;
		try {
			IDietician dietician = dieticianPersistence.getDieticianDetails(dieticianId);
			passwordFromDB = dietician.getPassword();
			approvalIndicator = dietician.isApprovalIndicator();
			if (passwordFromDB.equals(passwordEncryption.encryptPassword(password)) && approvalIndicator) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
