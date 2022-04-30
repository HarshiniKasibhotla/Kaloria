package com.csci5308.kaloria.admin.verifiedDieticians;

import java.sql.SQLException;

public interface IVerifiedDietician {

	public void setDieticianId(int dieticianId);

	public int getDieticianId();

	public void setApprovalIndicator(int approvalIndicator);

	public int getApprovalIndicator();

	public void setDieticianName(String dieticianName);

	public String getDieticianName();

	public void setDieticianAddress(String dieticianAddress);

	public String getDieticianAddress();

	public void setDieticianZipCode(String zipCode);

	public String getDieticianZipCode();

	public void setDieticianRating(int rating);

	public int getDieticianRating();

	public void setSpecialization(String specialization);

	public String getSpecialization();

	public void setExpertise(String expertise);

	public String getExpertise();

	public void setLicense(String license);

	public String getLicense();

	public void getVerifiedDieticians() throws SQLException;

}
