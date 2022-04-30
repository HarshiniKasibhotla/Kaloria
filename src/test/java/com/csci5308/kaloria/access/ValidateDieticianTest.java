package com.csci5308.kaloria.access;

import static org.mockito.Mockito.doThrow;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.csci5308.kaloria.access.calculators.IPasswordEncryption;
import com.csci5308.kaloria.access.calculators.PasswordEncryption;
import com.csci5308.kaloria.access.dietician.Dietician;
import com.csci5308.kaloria.access.dietician.DieticianPersistence;
import com.csci5308.kaloria.access.dietician.IDietician;

@SpringBootTest
public class ValidateDieticianTest {

	@InjectMocks
	ValidateDietician validateCurrentUser = new ValidateDietician();

	DieticianPersistence dieticianPersistence = Mockito.spy(new DieticianPersistence());

	private transient IPasswordEncryption passwordEncryption = Mockito.spy(new PasswordEncryption());

	@Test
	public void validateCurrentUserTest() throws SQLException {
		IDietician dietician = new Dietician();
		dietician.setPassword("Vriwzduh|456");
		dietician.setApprovalIndicator(true);
		Mockito.doReturn(dietician).when(dieticianPersistence).getDieticianDetails("DIET75636P");
		Mockito.when(passwordEncryption.encryptPassword("Software@123")).thenReturn("Vriwzduh|456");
		Assertions.assertTrue(validateCurrentUser.validateCurrentUser("DIET75636P", "Software@123"));
	}

	@Test
	public void validateCurrentUserExceptionTest() throws SQLException {
		doThrow(new SQLException()).when(dieticianPersistence).getPassword(Mockito.anyString());
		Assertions.assertFalse(validateCurrentUser.validateCurrentUser("user123@gmail.com", "Software@123"));
	}

}
