package com.csci5308.kaloria.access.user;

import com.csci5308.kaloria.database.CallStoredProcedures;
import com.csci5308.kaloria.dietician.appointments.VerifiedAppointments;
import com.csci5308.kaloria.dietician.appointments.WaitingAppointments;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class UserPersistance implements IUserPersistance {

	public boolean createNewUser(IUser user, int age, Timestamp timestamp) {

		CallStoredProcedures procedure = null;
		boolean isUserCreated = false;

		try {
			procedure = new CallStoredProcedures("spCreateUser(?, ?, ?, ?, ?, ?,?,?,?,?,?)");
			procedure.setParameter(1, user.getPassword());
			procedure.setParameter(2, user.getFirstName());
			procedure.setParameter(3, user.getLastName());
			procedure.setParameter(4, user.getEmail());
			procedure.setParameter(5, user.getMobileNo());
			procedure.setParameter(6, user.getDOB());
			procedure.setParameter(7, user.getCity());
			procedure.setParameter(8, user.getZipCode());
			procedure.setTimestamp(9, timestamp);
			procedure.setParameter(10, age);
			procedure.setParameter(11, user.getGender());
			isUserCreated = procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (procedure != null) {
				procedure.cleanup();
			}
		}
		return isUserCreated;

	}

	public String getPassword(String emailId) throws SQLException {

		CallStoredProcedures procedure = null;
		String password = "";

		try {
			procedure = new CallStoredProcedures("spGetUserByEmail(?)");
			procedure.setParameter(1, emailId);
			ResultSet results = procedure.executeWithResults();
			if (null != results) {
				while (results.next()) {
					password = results.getString("Password");
				}
			}
		} finally {
			if (null != procedure) {
				procedure.cleanup();
			}

		}
		return password;
	}

	@Override
	public ArrayList<VerifiedAppointments> getVerifiedAppointments() throws SQLException {
		ArrayList<VerifiedAppointments> verifiedAppointments = new ArrayList<VerifiedAppointments>();

		CallStoredProcedures getverifiedAppointment = null;
		try {
			getverifiedAppointment = new CallStoredProcedures("spGetApprovedAppoinments");
			ResultSet data = getverifiedAppointment.executeWithResults();

			while (data.next()) {
				VerifiedAppointments va = new VerifiedAppointments();

				String userName = data.getString("FirstName");
				String email = data.getString("Email");
				String mobile = data.getString("Mobile");
				int userId = data.getInt("UserId");

				va.setName(userName);
				va.setEmail(email);
				va.setMobile(mobile);
				va.setUserId(userId);
				verifiedAppointments.add(va);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != getverifiedAppointment) {
				getverifiedAppointment.cleanup();
			}
		}
		return verifiedAppointments;
	}

	@Override
	public ArrayList<WaitingAppointments> getWaitingAppointments() throws SQLException {
		ArrayList<WaitingAppointments> waitingAppointments = new ArrayList<WaitingAppointments>();
		CallStoredProcedures getWaitingAppointment = null;

		getWaitingAppointment = new CallStoredProcedures("spGetWaitingAppointments");
		ResultSet data = getWaitingAppointment.executeWithResults();
		try {
			while (data.next()) {
				WaitingAppointments wa = new WaitingAppointments();

				String userName = data.getString("FirstName");
				String email = data.getString("Email");
				String mobile = data.getString("Mobile");
				int userId = data.getInt("UserId");

				wa.setUserId(userId);
				wa.setName(userName);
				wa.setEmail(email);
				wa.setMobile(mobile);
				waitingAppointments.add(wa);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != getWaitingAppointment) {
				getWaitingAppointment.cleanup();
			}
		}

		return waitingAppointments;
	}

	@Override
	public void updateAppointmentStatus(Integer userId, Boolean approvalIndicator) throws SQLException {
		CallStoredProcedures procedure = null;

		try {

			procedure = new CallStoredProcedures("spUpdateAppointmentApproval(?, ?)");
			procedure.setParameter(1, userId);
			procedure.setParameter(2, approvalIndicator);
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (procedure != null) {
				procedure.cleanup();
			}
		}

	}

	@Override
	public IUser getUserDetails(String emailId) throws SQLException {
		CallStoredProcedures procedure = null;
		IUser user = new User();
		try {
			procedure = new CallStoredProcedures("spGetUserDetailsByEmail(?)");
			procedure.setParameter(1, emailId);
			ResultSet results = procedure.executeWithResults();
			if (null != results) {
				while (results.next()) {
					user.setId(results.getInt("UserID"));
					user.setFirstName(results.getString("FirstName"));
					user.setLastName(results.getString("LastName"));
					user.setEmail(results.getString("Email"));
					user.setMobileNo(results.getString("Mobile"));
					user.setCity(results.getString("City"));
					user.setZipCode(results.getString("ZipCode"));
				}
			}
		} finally {
			if (null != procedure) {
				procedure.cleanup();
			}

		}
		return user;
	}

}
