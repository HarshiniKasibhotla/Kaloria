package com.csci5308.kaloria.dietician.appointments;

public class WaitingAppointments extends VerifiedAppointments implements IWaitingAppointments {

	public int userId;

	@Override
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int getUserId() {
		return userId;
	}

}
