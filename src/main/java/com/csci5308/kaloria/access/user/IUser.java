package com.csci5308.kaloria.access.user;

import java.text.ParseException;

public interface IUser {

	public void setId(int id);

	public int getId();

	public void setFirstName(String firstName);

	public String getFirstName();

	public void setLastName(String lastName);

	public String getLastName();

	public void setEmail(String email);

	public String getEmail();

	public void setMobileNo(String mobileNo);

	public String getMobileNo();

	public void setPassword(String password);

	public String getPassword();

	public void setDOB(String dob);

	public String getDOB();

	public void setCity(String city);

	public String getCity();

	public void setZipCode(String zipCode);

	public String getZipCode();

	public void setGender(String gender);

	public String getGender();

	public void createUser(IUser newUser, String passwordEncryption) throws ParseException;

}
