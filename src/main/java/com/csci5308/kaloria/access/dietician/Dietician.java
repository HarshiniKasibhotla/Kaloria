package com.csci5308.kaloria.access.dietician;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;

import com.csci5308.kaloria.access.user.User;
import com.csci5308.kaloria.notification.Email;
import com.csci5308.kaloria.notification.EmailService;
import com.csci5308.kaloria.notification.ICommunicationService;
import com.csci5308.kaloria.notification.IMessage;
import com.csci5308.kaloria.utilities.Constants;

public class Dietician extends User implements IDietician, Constants {

	private String dieticianName;
	private String registrationId;
	private String qualification;
	private String areasofExpertise;
	private String address;
	private String availabilityHours;
	private int timeSlot;
	private boolean verified;
	private boolean approvalIndicator;

	IDieticianPersistence dieticianPersistence;

	IMessage message;

	ICommunicationService communicationService;

	public Dietician() {
		super();
		this.dieticianPersistence = new DieticianPersistence();
	}

	@Override
	public void setDieticianName(String dieticianName) {
		this.dieticianName = dieticianName;
	}

	@Override
	public String getDieticianName() {
		return dieticianName;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getQualification() {
		return qualification;
	}

	public void setAreasOfExpertise(String areasOfExpertise) {
		this.areasofExpertise = areasOfExpertise;

	}

	public String getAreasOfExpertise() {
		return areasofExpertise;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAvailabilityHours(String availabilityHours) {
		this.availabilityHours = availabilityHours;

	}

	public String getAvailabilityHours() {
		return availabilityHours;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public static boolean isRegistrationIdValid(String registrationId) {

		Matcher registrationIdMatcher;

		if (registrationId.length() == 10) {
			registrationIdMatcher = compilePatternAndMatcher(DIETICIAN_ID_REGEX, registrationId);
		} else {
			return false;
		}
		return registrationIdMatcher.find();
	}

	public static boolean isTimeSlotValid(int timeSlot) {

		if (timeSlot != 0) {
			return true;
		}
		return false;
	}

	@Override
	public void createDietician(IDietician newDietician, String password) throws ParseException {
		password = passwordEncryptionService.encryptPassword(password);
		int age = ageCalculator.calculateAge(dateOfBirth);
		Timestamp timeStamp = dateConvertor.convertDate(new Date());
		newDietician.setPassword(password);
		newDietician.setVerified(false);
		newDietician.setApprovalIndicator(false);
		try {
			dieticianPersistence.createNewDietician(newDietician, age, timeStamp);
			message = new Email();
			List<String> recepients = new ArrayList<>();
			recepients.add(this.getEmail());
			message.setRecipients(recepients);
			message.setSubject(EMAIL_SUBJECT_FOR_SUCCESSFUL_REGISTRATION);
			message.setBody(EMAIL_BODY_FOR_CREDENTIALS + this.getEmail() + EMAIL_PASSWORD + password + DIETICIAN_MESSAGE
					+ EMAIL_CLOSING);
			communicationService = new EmailService();
			communicationService.send(message);
		} catch (Exception e) {
			System.out.println("Exception occured while storing data into db");
		}
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public boolean isApprovalIndicator() {
		return approvalIndicator;
	}

	public void setApprovalIndicator(boolean approvalIndicator) {
		this.approvalIndicator = approvalIndicator;
	}
}
