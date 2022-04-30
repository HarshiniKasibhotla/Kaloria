package com.csci5308.kaloria.access.dietician;

import java.text.ParseException;

import com.csci5308.kaloria.access.user.IUser;

public interface IDietician extends IUser {

	void setDieticianName(String dieticianName);

	String getDieticianName();

	public void setRegistrationId(String registrationId);

	public String getRegistrationId();

	public void setQualification(String qualification);

	public String getQualification();

	public void setAreasOfExpertise(String areasOfExpertise);

	public String getAreasOfExpertise();

	public void setAddress(String address);

	public String getAddress();

	public void setAvailabilityHours(String availabilityHours);

	public String getAvailabilityHours();

	public void createDietician(IDietician dietician, String password) throws ParseException;

	public void setTimeSlot(int timeSlot);

	public int getTimeSlot();

	public boolean isVerified();

	public void setVerified(boolean verified);

	public boolean isApprovalIndicator();

	public void setApprovalIndicator(boolean approvalIndicator);

}
