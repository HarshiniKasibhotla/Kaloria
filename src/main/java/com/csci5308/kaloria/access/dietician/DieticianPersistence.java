package com.csci5308.kaloria.access.dietician;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.csci5308.kaloria.database.CallStoredProcedures;

public class DieticianPersistence implements IDieticianPersistence {

	@Override
	public boolean createNewDietician(IDietician dietician, int age, Timestamp timestamp) {
		CallStoredProcedures procedure = null;
		boolean isDieticianCreated = false;
		try {
			procedure = new CallStoredProcedures(
					"spCreateDietician(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)");
			procedure.setParameter(1, dietician.getPassword());
			procedure.setParameter(2, dietician.getFirstName());
			procedure.setParameter(3, dietician.getLastName());
			procedure.setParameter(4, dietician.getEmail());
			procedure.setParameter(5, dietician.getMobileNo());
			procedure.setParameter(6, dietician.getDOB());
			procedure.setParameter(7, dietician.getCity());
			procedure.setParameter(8, dietician.getZipCode());
			procedure.setParameter(9, dietician.getQualification());
			procedure.setParameter(10, dietician.getAreasOfExpertise());
			procedure.setParameter(11, dietician.getAddress());
			procedure.setParameter(12, dietician.getAvailabilityHours());
			procedure.setParameter(13, dietician.getRegistrationId());
			procedure.setParameter(14, age);
			procedure.setTimestamp(15, timestamp);
			procedure.setParameter(16, dietician.getTimeSlot());
			procedure.setParameter(17, dietician.getGender());
			procedure.setParameter(18, dietician.isVerified());
			procedure.setParameter(19, dietician.isApprovalIndicator());
			isDieticianCreated = procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (procedure != null) {
				procedure.cleanup();
			}
		}
		return isDieticianCreated;
	}

	@Override
	public String getPassword(String userId) throws SQLException {

		CallStoredProcedures procedure = null;
		String password = "";

		try {
			procedure = new CallStoredProcedures("spGetDieticianById(?)");
			procedure.setParameter(1, userId);
			ResultSet results = procedure.executeWithResults();
			if (null != results) {
				while (results.next()) {
					password = results.getString("Password");
				}
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if (null != procedure) {
				procedure.cleanup();
			}

		}
		return password;
	}

	@Override
	public IDietician getDieticianDetails(String registrationId) throws SQLException {
		CallStoredProcedures procedure = null;
		IDietician dietician = new Dietician();
		try {
			procedure = new CallStoredProcedures("spGetDietician(?)");
			procedure.setParameter(1, registrationId);
			ResultSet results = procedure.executeWithResults();
			if (null != results) {
				while (results.next()) {
					dietician.setId(results.getInt("DietitianId"));
					dietician.setFirstName(results.getString("FirstName"));
					dietician.setLastName(results.getString("LastName"));
					dietician.setPassword(results.getString("Password"));
					dietician.setEmail(results.getString("Email"));
					dietician.setMobileNo(results.getString("Mobile"));
					dietician.setCity(results.getString("City"));
					dietician.setZipCode(results.getString("ZipCode"));
					dietician.setApprovalIndicator(results.getBoolean("ApprovalIndicator"));
				}
			}
		} finally {
			if (null != procedure) {
				procedure.cleanup();
			}

		}
		return dietician;
	}
}
