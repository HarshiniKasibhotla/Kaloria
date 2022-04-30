package com.csci5308.kaloria.access.user;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.csci5308.kaloria.dietician.appointments.VerifiedAppointments;
import com.csci5308.kaloria.dietician.appointments.WaitingAppointments;

public interface IUserPersistance {

	public boolean createNewUser(IUser user, int age, Timestamp sqlDate);
	
	public IUser getUserDetails(String emailId) throws SQLException;
	
	public String getPassword(String userId) throws SQLException;
	
	public ArrayList<VerifiedAppointments> getVerifiedAppointments() throws SQLException;

	public ArrayList<WaitingAppointments> getWaitingAppointments() throws SQLException;

	public void updateAppointmentStatus(Integer userId, Boolean approvalIndicator) throws SQLException;

	
}
