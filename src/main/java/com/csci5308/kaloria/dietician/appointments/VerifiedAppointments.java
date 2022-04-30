package com.csci5308.kaloria.dietician.appointments;

public class VerifiedAppointments implements IVerifiedAppointments {

	public int approvalIndicator;
	public int userId;
	public String firstName;
	public String email;
	public String mobile;

	@Override
	public void setUserId(int userId) {
		this.userId = userId;

	}

	@Override
	public int getUserId() {
		return userId;
	}

	@Override
	public void setApprovalIndicator(int approvalIndicator) {
		this.approvalIndicator = approvalIndicator;

	}

	@Override
	public int getApprovalIndicator() {
		return approvalIndicator;
	}

	@Override
	public void setName(String userName) {
		this.firstName = userName;

	}

	@Override
	public String getName() {
		return firstName;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;

	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setMobile(String mobile) {
		this.mobile = mobile;

	}

	@Override
	public String getMobile() {
		return mobile;
	}

}
