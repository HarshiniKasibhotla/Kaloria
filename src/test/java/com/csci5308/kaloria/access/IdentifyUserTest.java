package com.csci5308.kaloria.access;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

public class IdentifyUserTest {

	@InjectMocks
	IdentifyUser identifyUser;

	IValidateCurrentUser validateUser = Mockito.spy(ValidateNormalUser.class);

	IValidateCurrentUser validateDietician = Mockito.spy(ValidateDietician.class);

	@BeforeEach
	public void setUp() {
		identifyUser = new IdentifyUser();
	}

	@Test
	public void identifyAndValidateAdminTest() throws SQLException {
		assertEquals("admin", identifyUser.identifyAndValidateUser("admin", "admin"));
		assertEquals("", identifyUser.identifyAndValidateUser("admin", "admin123"));
	}

	@Test
	public void identifyAndValidateNormalUserTest() throws SQLException {
		Mockito.doReturn(true).when(validateUser).validateCurrentUser("abc@gmail.com", "Normaluser@123");
		identifyUser.identifyAndValidateUser("abc@gmail.com", "Normaluser@123");

	}

	@Test
	public void identifyAndValidateDietcianTest() throws SQLException {
		Mockito.when(validateDietician.validateCurrentUser("DIET65234P", "Dietician@123")).thenReturn(true);
		identifyUser.identifyAndValidateUser("DIET65234P", "Dietician@123");

	}

}
