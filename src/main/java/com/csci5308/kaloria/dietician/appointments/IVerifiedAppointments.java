package com.csci5308.kaloria.dietician.appointments;

public interface IVerifiedAppointments {

	public void setUserId(int userId);

	public int getUserId();

	public void setApprovalIndicator(int approvalIndicator);

	public int getApprovalIndicator();

	public void setName(String userName);

	public String getName();

	public void setEmail(String email);

	public String getEmail();

	public void setMobile(String mobile);

	public String getMobile();

}
