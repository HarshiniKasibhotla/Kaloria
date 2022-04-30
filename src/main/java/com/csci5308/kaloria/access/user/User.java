package com.csci5308.kaloria.access.user;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.csci5308.kaloria.access.calculators.AgeCalculator;
import com.csci5308.kaloria.access.calculators.DateConverter;
import com.csci5308.kaloria.access.calculators.IAgeCalculator;
import com.csci5308.kaloria.access.calculators.IDateConverter;
import com.csci5308.kaloria.access.calculators.IPasswordEncryption;
import com.csci5308.kaloria.access.calculators.PasswordEncryption;
import com.csci5308.kaloria.notification.Email;
import com.csci5308.kaloria.notification.EmailService;
import com.csci5308.kaloria.notification.ICommunicationService;
import com.csci5308.kaloria.notification.IMessage;
import com.csci5308.kaloria.utilities.Constants;

public class User implements IUser, Constants {

	private int Id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	protected String password;
	protected String dateOfBirth;
	private String city;
	private String zipCode;
	private String gender;

	protected IPasswordEncryption passwordEncryptionService = new PasswordEncryption();

	protected IUserPersistance userPersistence = new UserPersistance();

	protected IAgeCalculator ageCalculator = new AgeCalculator();

	protected IDateConverter dateConvertor = new DateConverter();

	IMessage message;

	ICommunicationService communicationService;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDOB(String dob) {
		this.dateOfBirth = dob;
	}

	public String getDOB() {
		return dateOfBirth;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	protected static boolean notNullAndNotEmptyCheck(String s) {

		if (s == null || s.isEmpty()) {
			return false;
		}

		return true;
	}

	public static boolean isFieldValid(String fieldName) {

		if (notNullAndNotEmptyCheck(fieldName)) {
			return true;
		}

		return false;
	}

	public static boolean isMobileNoValid(String mobileNo) {

		if (notNullAndNotEmptyCheck(mobileNo) && mobileNo.length() == 10) {
			return true;
		}

		return false;

	}

	public static boolean isEmailValid(String email) {

		Matcher matcher = compilePatternAndMatcher(EMAIL_REGEX, email);
		return matcher.matches();

	}

	public static boolean isPasswordValid(String password) {

		Matcher lowerCaseLetterMatcher;
		Matcher upperCaseLetterMatcher;
		Matcher digitMatcher;
		Matcher specialCharactersMatcher;

		if (password.length() >= 8) {

			lowerCaseLetterMatcher = compilePatternAndMatcher(LOWERCASE_LETTER_REGEX, password);
			upperCaseLetterMatcher = compilePatternAndMatcher(UPPERCASE_LETTER_REGEX, password);
			digitMatcher = compilePatternAndMatcher(DIGIT_REGEX, password);
			specialCharactersMatcher = compilePatternAndMatcher(SPECIAL_CHARACTERS_REGEX, password);

		} else {
			return false;
		}

		return lowerCaseLetterMatcher.find() && upperCaseLetterMatcher.find() && digitMatcher.find()
				&& specialCharactersMatcher.find();
	}

	protected static Matcher compilePatternAndMatcher(String regex, String input) {

		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(input);
	}

	public void createUser(IUser newUser, String password) throws ParseException {

		this.password = passwordEncryptionService.encryptPassword(password);
		int age = ageCalculator.calculateAge(dateOfBirth);
		Timestamp timeStamp = dateConvertor.convertDate(new Date());
		newUser.setPassword(this.password);

		try {
			userPersistence.createNewUser(newUser, age, timeStamp);
			message = new Email();
			List<String> recepients = new ArrayList<>();
			recepients.add(this.getEmail());
			message.setRecipients(recepients);
			message.setSubject(EMAIL_SUBJECT_FOR_SUCCESSFUL_REGISTRATION);
			message.setBody(EMAIL_BODY_FOR_CREDENTIALS + this.getEmail() + EMAIL_PASSWORD + password);
			communicationService = new EmailService();
			communicationService.send(message);
		} catch (Exception e) {
			System.out.println("Exception occured while storing user data into db");
		}
	}

}
