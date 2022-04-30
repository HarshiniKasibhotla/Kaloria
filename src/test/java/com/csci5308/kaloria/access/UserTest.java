package com.csci5308.kaloria.access;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.csci5308.kaloria.access.calculators.AgeCalculator;
import com.csci5308.kaloria.access.calculators.DateConverter;
import com.csci5308.kaloria.access.calculators.IAgeCalculator;
import com.csci5308.kaloria.access.calculators.IDateConverter;
import com.csci5308.kaloria.access.calculators.IPasswordEncryption;
import com.csci5308.kaloria.access.calculators.PasswordEncryption;
import com.csci5308.kaloria.access.user.User;
import com.csci5308.kaloria.access.user.UserPersistance;
import com.csci5308.kaloria.notification.Email;
import com.csci5308.kaloria.notification.EmailService;
import com.csci5308.kaloria.notification.ICommunicationService;

public class UserTest {

	private transient IPasswordEncryption passwordEncryptionService = spy(PasswordEncryption.class);

	private transient UserPersistance userPersistence = spy(UserPersistance.class);

	private transient IAgeCalculator ageCalculator = spy(AgeCalculator.class);

	private transient IDateConverter dateConvertor = spy(DateConverter.class);

	private transient ICommunicationService communicationService = spy(EmailService.class);

	@InjectMocks
	User user;

	@BeforeEach
	public void setUp() {
		user = new User();
	}

	@Test
	public void setIdTest() {
		user.setId(200);
		assertTrue(200 == user.getId());
	}

	@Test
	public void getIdTest() {
		user.setId(30);
		assertFalse(0 == user.getId());
	}

	@Test
	public void setFirstNameTest() {
		user.setFirstName("Sia");
		assertEquals("Sia", user.getFirstName());
	}

	@Test
	public void getFirstNameTest() {
		user.setFirstName("Simon");
		assertNotEquals("Sia", user.getFirstName());
	}

	@Test
	public void setLastNameTest() {
		user.setLastName("Paul");
		assertEquals("Paul", user.getLastName());
	}

	@Test
	public void getLastNameTest() {
		user.setLastName("Winston");
		assertNotEquals("Churchill", user.getLastName());
	}

	@Test
	public void setEmailTest() {
		user.setEmail("testEmail@gmail.com");
		assertEquals("testEmail@gmail.com", user.getEmail());
	}

	@Test
	public void getEmailTest() {
		user.setEmail("test123@gmail.com");
		assertNotEquals("testEmail@gmail.com", user.getEmail());
	}

	@Test
	public void setMobileNoTest() {
		user.setMobileNo("5689528788");
		assertEquals("5689528788", user.getMobileNo());
	}

	@Test
	public void getMobileNoTest() {
		user.setMobileNo("7896768676");
		assertNotEquals("5689528788", user.getMobileNo());
	}

	@Test
	public void setPasswordTest() {
		user.setPassword("hiutlysgJ@12");
		assertEquals("hiutlysgJ@12", user.getPassword());
	}

	@Test
	public void getDobTest() {
		user.setDOB("1992-16-07");
		assertNotEquals("1993-16-07", user.getDOB());
	}

	@Test
	public void setCityTest() {
		user.setCity("Halifax");
		assertEquals("Halifax", user.getCity());
	}

	@Test
	public void getCityTest() {
		user.setCity("Halifax");
		assertNotEquals("Toronto", user.getCity());
	}

	@Test
	public void setZipCodeTest() {
		user.setZipCode("B3HJ2K");
		assertEquals("B3HJ2K", user.getZipCode());
	}

	@Test
	public void getZipCodeTest() {
		user.setZipCode("B3HJ2K");
		assertNotEquals("B3HW3K", user.getZipCode());
	}

	@Test
	public void isFirstNameValidTest() {
		assertTrue(User.isFieldValid("abc"));
		assertFalse(User.isFieldValid(""));
	}

	@Test
	public void isMobileNoValid() {
		assertTrue(User.isFieldValid("8965328945"));
		assertFalse(User.isFieldValid(""));
	}

	@Test
	public void isCityValidTest() {
		assertTrue(User.isFieldValid("Halifax"));
		assertFalse(User.isFieldValid(""));
	}

	@Test
	public void isEmailValidTest() {
		assertTrue(User.isEmailValid("abc@gmail.com"));
		assertFalse(User.isEmailValid(""));
	}

	@Test
	public void isDOBValidTest() {
		assertTrue(User.isFieldValid("1999-23-03"));
		assertFalse(User.isFieldValid(""));
	}

	@Test
	public void isZipCodeValidTest() {
		assertTrue(User.isFieldValid("B3KH4J"));
		assertFalse(User.isFieldValid(""));
	}

	@Test
	public void isMobileNoValidTest() {
		assertTrue(User.isMobileNoValid("9855232325"));
		assertFalse(User.isMobileNoValid(""));
		assertFalse(User.isMobileNoValid("89989898"));
	}

	@Test
	public void isPasswordValid() {
		assertTrue(User.isPasswordValid("Hkotlsd@900"));
		assertFalse(User.isPasswordValid("shfjsn"));
	}

	@Test
	public void isGenderValid() {
		assertTrue(User.isFieldValid("Male"));
		assertFalse(User.isFieldValid(""));
	}

	@Test
	public void createUserTest() throws ParseException {
		user.setDOB("1997-02-02");
		when(passwordEncryptionService.encryptPassword("fhadadhK@12")).thenReturn("ikdgdgkN|45");
		when(ageCalculator.calculateAge(user.getDOB())).thenReturn(24);
		when(dateConvertor.convertDate(new Date())).thenReturn(new Timestamp(0));
		doNothing().when(communicationService).send(new Email());
		doReturn(true).when(userPersistence).createNewUser(user, 24, new Timestamp(0));
		user.createUser(user, "fhadadhK@12");
	}
}
