package com.csci5308.kaloria.access;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
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
import com.csci5308.kaloria.access.dietician.Dietician;
import com.csci5308.kaloria.access.dietician.DieticianPersistence;
import com.csci5308.kaloria.access.dietician.IDieticianPersistence;
import com.csci5308.kaloria.access.user.User;
import com.csci5308.kaloria.notification.Email;
import com.csci5308.kaloria.notification.EmailService;
import com.csci5308.kaloria.notification.ICommunicationService;

public class DieticianTest {

	private transient IPasswordEncryption passwordEncryptionService = mock(PasswordEncryption.class);

	private transient IDieticianPersistence dieticianPersistence = mock(DieticianPersistence.class);

	private transient IAgeCalculator ageCalculator = mock(AgeCalculator.class);

	private transient IDateConverter dateConvertor = mock(DateConverter.class);

	private transient ICommunicationService communicationService = mock(EmailService.class);

	@InjectMocks
	Dietician dietician;

	@BeforeEach
	public void setUp() {
		dietician = new Dietician();
	}

	@Test
	public void setIdTest() {
		dietician.setId(200);
		assertTrue(200 == dietician.getId());
	}

	@Test
	public void getIdTest() {
		dietician.setId(30);
		assertFalse(0 == dietician.getId());
	}

	@Test
	public void setFirstNameTest() {
		dietician.setFirstName("Sia");
		assertEquals("Sia", dietician.getFirstName());
	}

	@Test
	public void getFirstNameTest() {
		dietician.setFirstName("Simon");
		assertNotEquals("Sia", dietician.getFirstName());
	}

	@Test
	public void setLastNameTest() {
		dietician.setLastName("Paul");
		assertEquals("Paul", dietician.getLastName());
	}

	@Test
	public void getLastNameTest() {
		dietician.setLastName("Winston");
		assertNotEquals("Churchill", dietician.getLastName());
	}

	@Test
	public void setEmailTest() {
		dietician.setEmail("testEmail@gmail.com");
		assertEquals("testEmail@gmail.com", dietician.getEmail());
	}

	@Test
	public void getEmailTest() {
		dietician.setEmail("test123@gmail.com");
		assertNotEquals("testEmail@gmail.com", dietician.getEmail());
	}

	@Test
	public void setMobileNoTest() {
		dietician.setMobileNo("5689528788");
		assertEquals("5689528788", dietician.getMobileNo());
	}

	@Test
	public void getMobileNoTest() {
		dietician.setMobileNo("7896768676");
		assertNotEquals("5689528788", dietician.getMobileNo());
	}

	@Test
	public void setPasswordTest() {
		dietician.setPassword("hiutlysgJ@12");
		assertEquals("hiutlysgJ@12", dietician.getPassword());
	}

	@Test
	public void getDobTest() {
		dietician.setDOB("1992-16-07");
		assertNotEquals("1993-16-07", dietician.getDOB());
	}

	@Test
	public void setCityTest() {
		dietician.setCity("Halifax");
		assertEquals("Halifax", dietician.getCity());
	}

	@Test
	public void getCityTest() {
		dietician.setCity("Halifax");
		assertNotEquals("Toronto", dietician.getCity());
	}

	@Test
	public void setZipCodeTest() {
		dietician.setZipCode("B3HJ2K");
		assertEquals("B3HJ2K", dietician.getZipCode());
	}

	@Test
	public void getZipCodeTest() {
		dietician.setZipCode("B3HJ2K");
		assertNotEquals("B3HW3K", dietician.getZipCode());
	}

	@Test
	public void setRegistrationIdTest() {
		dietician.setRegistrationId("DIET15623P");
		assertEquals("DIET15623P", dietician.getRegistrationId());
	}

	@Test
	public void getRegistrationIdTest() {
		dietician.setRegistrationId("DIET15623P");
		assertNotEquals("DIET78558Q", dietician.getRegistrationId());
	}

	@Test
	public void setQualificationTest() {
		dietician.setQualification("Dietician");
		assertEquals("Dietician", dietician.getQualification());
	}

	@Test
	public void getQualificationTest() {
		dietician.setRegistrationId("Dietician");
		assertNotEquals("surgeon", dietician.getQualification());
	}

	@Test
	public void setAreasOfExpertiseTest() {
		dietician.setAreasOfExpertise("xyz,abc");
		assertEquals("xyz,abc", dietician.getAreasOfExpertise());
	}

	@Test
	public void getAreasOfExpertiseTest() {
		dietician.setAreasOfExpertise("xyz,abc");
		assertNotEquals("abc,def", dietician.getAreasOfExpertise());
	}

	@Test
	public void setAddressTest() {
		dietician.setAddress("xyz,abc");
		assertEquals("xyz,abc", dietician.getAddress());
	}

	@Test
	public void getAddressTest() {
		dietician.setAddress("xyz,abc");
		assertNotEquals("abc,def", dietician.getAddress());
	}

	@Test
	public void setAvailabilityHoursTest() {
		dietician.setAvailabilityHours("09:00AM-05:00PM");
		assertEquals("09:00AM-05:00PM", dietician.getAvailabilityHours());
	}

	@Test
	public void setTimeSlotTest() {
		dietician.setTimeSlot(30);
		assertEquals(30, dietician.getTimeSlot());
	}

	@Test
	public void getTimeSlotTest() {
		dietician.setTimeSlot(30);
		assertNotEquals(45, dietician.getTimeSlot());
	}

	@Test
	public void isFirstNameValidTest() {
		assertTrue(User.isFieldValid("abc"));
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
	public void isPasswordValidTest() {
		assertTrue(User.isPasswordValid("Hkotlsd@900"));
		assertFalse(User.isPasswordValid("shfjsn"));
	}

	@Test
	public void isRegistrationIdValidTest() {
		assertTrue(Dietician.isRegistrationIdValid("DIET45524P"));
		assertFalse(Dietician.isRegistrationIdValid("DIET4246"));
	}

	@Test
	public void isQualificationValidTest() {
		assertTrue(Dietician.isFieldValid("abc,xyz"));
		assertFalse(Dietician.isFieldValid(""));
	}

	@Test
	public void isAreasOfExpertiseValid() {
		assertTrue(Dietician.isFieldValid("abc,xyz"));
		assertFalse(Dietician.isFieldValid(""));
	}

	@Test
	public void isAddressValidTest() {
		assertTrue(Dietician.isFieldValid("abc,xyz"));
		assertFalse(Dietician.isFieldValid(""));
	}

	@Test
	public void isAvailabilityHoursValid() {
		assertTrue(Dietician.isFieldValid("09:00AM-05:00PM"));
		assertFalse(Dietician.isFieldValid(""));
	}

	@Test
	public void isTimeSlotValidTest() {
		assertTrue(Dietician.isTimeSlotValid(30));
		assertFalse(Dietician.isTimeSlotValid(0));
	}

	@Test
	public void createDieticianTest() throws ParseException {
		dietician.setDOB("1997-02-02");
		when(passwordEncryptionService.encryptPassword("fhadadhK@12")).thenReturn("ikdgdgkN|45");
		when(ageCalculator.calculateAge(dietician.getDOB())).thenReturn(24);
		when(dateConvertor.convertDate(new Date())).thenReturn(new Timestamp(0));
		doNothing().when(communicationService).send(new Email());
		when(dieticianPersistence.createNewDietician(dietician, 0, null)).thenReturn(true);
		dietician.createDietician(dietician, "fhadadhK@12");
	}
}
