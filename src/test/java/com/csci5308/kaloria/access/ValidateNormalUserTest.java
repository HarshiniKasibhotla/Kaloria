package com.csci5308.kaloria.access;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.csci5308.kaloria.access.calculators.IPasswordEncryption;
import com.csci5308.kaloria.access.calculators.PasswordEncryption;
import com.csci5308.kaloria.access.user.UserPersistance;

@SpringBootTest
public class ValidateNormalUserTest {

	@InjectMocks
	ValidateNormalUser validateCurrentUser = new ValidateNormalUser();

	UserPersistance userPersistence = spy(UserPersistance.class);

	private transient IPasswordEncryption passwordEncryption = spy(PasswordEncryption.class);

	@Test
	public void validateCurrentUserTest() throws SQLException {
		doReturn("Vriwzduh|345").when(userPersistence).getPassword("user123@gmail.com");
		Mockito.when(passwordEncryption.encryptPassword("Software@123")).thenReturn("Vriwzduh|345");
		Assertions.assertTrue(validateCurrentUser.validateCurrentUser("user123@gmail.com", "Software@123"));
	}

	@Test
	public void validateCurrentUserExceptionTest() throws SQLException {
		doThrow(new SQLException()).when(userPersistence).getPassword(Mockito.anyString());
		Assertions.assertFalse(validateCurrentUser.validateCurrentUser("user123@gmail.com", "Software@123"));
	}

}
