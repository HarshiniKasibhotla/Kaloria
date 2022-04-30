package com.csci5308.kaloria.admin.verifiedDieticians;

import java.sql.SQLException;

import com.csci5308.kaloria.admin.AdminPersistence;
import com.csci5308.kaloria.admin.IAdminPersistence;

public class VerifiedDietician implements IVerifiedDietician {

	private String dieticianName;
	private String dieticianAddress;
	private String expertise;
	private String specialization;
	private String license;
	private String dieticianZipCode;
	private int approvalIndicator;
	private int dieticianId;
	private int dieticianRating;

	IAdminPersistence adminpersistence;

	public VerifiedDietician() {
		super();
		this.adminpersistence = new AdminPersistence();
	}

	@Override
	public void setDieticianId(int dieticianId) {
		this.dieticianId = dieticianId;

	}

	@Override
	public int getDieticianId() {

		return dieticianId;
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
	public void setDieticianName(String dieticianName) {
		this.dieticianName = dieticianName;

	}

	@Override
	public String getDieticianName() {

		return dieticianName;

	}

	@Override
	public void setDieticianAddress(String dieticianAddress) {
		this.dieticianAddress = dieticianAddress;

	}

	@Override
	public String getDieticianAddress() {
		return dieticianAddress;

	}

	@Override
	public void setDieticianZipCode(String zipCode) {
		this.dieticianZipCode = zipCode;
	}

	@Override
	public String getDieticianZipCode() {
		return dieticianZipCode;
	}

	@Override
	public void setDieticianRating(int rating) {
		this.dieticianRating = rating;
	}

	@Override
	public int getDieticianRating() {
		return dieticianRating;
	}

	@Override
	public void setSpecialization(String specialization) {
		this.specialization = specialization;

	}

	@Override
	public String getSpecialization() {
		return specialization;

	}

	@Override
	public void setExpertise(String expertise) {
		this.expertise = expertise;

	}

	@Override
	public String getExpertise() {
		return expertise;

	}

	@Override
	public void setLicense(String license) {
		this.license = license;

	}

	@Override
	public String getLicense() {
		return license;

	}

	@Override
	public void getVerifiedDieticians() throws SQLException {
		adminpersistence.getVerifiedDieticians();

	}

}
