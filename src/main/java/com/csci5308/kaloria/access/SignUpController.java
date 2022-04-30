package com.csci5308.kaloria.access;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csci5308.kaloria.access.dietician.Dietician;
import com.csci5308.kaloria.access.dietician.IDietician;
import com.csci5308.kaloria.access.user.IUser;
import com.csci5308.kaloria.access.user.User;
import com.csci5308.kaloria.errorHandling.ErrorMessages;
import com.csci5308.kaloria.utilities.Constants;
import com.csci5308.kaloria.utilities.LoggerUtility;

@Controller
public class SignUpController implements ErrorMessages, Constants {

	Logger logger = LoggerUtility.getLoggerInstance(SignUpController.class);

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String register() {
		return "Signup";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processSignup(@RequestParam(name = FIRST_NAME) String firstName,
			@RequestParam(name = LAST_NAME) String lastName, @RequestParam(name = EMAIL) String email,
			@RequestParam(name = MOBILE_NO) String mobileNo, @RequestParam(name = DOB) String dob,
			@RequestParam(name = CITY) String city, @RequestParam(name = ZIPCODE) String zipCode,
			@RequestParam(name = PASSWORD) String password, @RequestParam(name = "gender") String gender) {

		ModelAndView modelAndView;
		IUser newUser = new User();
		if (User.isFieldValid(firstName) && User.isFieldValid(lastName) && User.isEmailValid(email)
				&& User.isMobileNoValid(mobileNo) && User.isPasswordValid(password) && User.isFieldValid(dob)
				&& User.isFieldValid(city) && User.isFieldValid(zipCode) && User.isFieldValid(gender)) {

			newUser.setFirstName(firstName);
			newUser.setLastName(lastName);
			newUser.setEmail(email);
			newUser.setMobileNo(mobileNo);
			newUser.setDOB(dob);
			newUser.setCity(city);
			newUser.setZipCode(zipCode);
			newUser.setGender(gender);
			try {
				newUser.createUser(newUser, password);
			} catch (Exception e) {
				logger.error(USER_REGISTER_EXCEPTION + email);
				modelAndView = new ModelAndView("Signup");
				modelAndView.addObject("errorMessage", KLR_USR_ERR_CODE_001);
				return modelAndView;
			}
		} else {
			logger.error(USER_REGISTER_EXCEPTION + email + BAD_FIELD_VALUES);
			modelAndView = new ModelAndView("Signup");
			modelAndView.addObject("errorMessage", KLR_USR_ERR_CODE_002);
			return modelAndView;
		}

		modelAndView = new ModelAndView("Login");
		System.out.println(newUser.getFirstName() + " " + newUser.getLastName());
		return modelAndView;

	}

	@RequestMapping(value = "/registerDietician", method = RequestMethod.POST)
	public ModelAndView processSignupDietician(@RequestParam(name = FIRST_NAME) String firstName,
			@RequestParam(name = LAST_NAME) String lastName, @RequestParam(name = EMAIL) String email,
			@RequestParam(name = MOBILE_NO) String mobileNo, @RequestParam(name = DOB) String dob,
			@RequestParam(name = CITY) String city, @RequestParam(name = ZIPCODE) String zipCode,
			@RequestParam(name = PASSWORD) String password, @RequestParam(name = QUALIFICATION) String qualification,
			@RequestParam(name = AREAS_OF_EXPERTISE) String areasOfExpertise,
			@RequestParam(name = ADDRESS) String address, @RequestParam(name = REGISTRATION_ID) String registrationId,
			@RequestParam(name = AVAILABILITY_HOURS) String availabilityHours,
			@RequestParam(name = TIMESLOT) int timeSlot, @RequestParam(name = "gender") String gender) {

		ModelAndView modelAndView;

		if (Dietician.isFieldValid(firstName) && Dietician.isFieldValid(lastName) && Dietician.isEmailValid(email)
				&& Dietician.isMobileNoValid(mobileNo) && Dietician.isPasswordValid(password)
				&& Dietician.isFieldValid(dob) && Dietician.isFieldValid(city) && Dietician.isFieldValid(zipCode)
				&& Dietician.isFieldValid(address) && Dietician.isFieldValid(areasOfExpertise)
				&& Dietician.isFieldValid(availabilityHours) && Dietician.isFieldValid(qualification)
				&& Dietician.isFieldValid(registrationId) && Dietician.isTimeSlotValid(timeSlot)
				&& Dietician.isFieldValid(gender)) {

			IDietician newDietician = new Dietician();
			newDietician.setFirstName(firstName);
			newDietician.setLastName(lastName);
			newDietician.setEmail(email);
			newDietician.setMobileNo(mobileNo);
			newDietician.setDOB(dob);
			newDietician.setCity(city);
			newDietician.setZipCode(zipCode);
			newDietician.setAddress(address);
			newDietician.setGender(gender);
			newDietician.setAreasOfExpertise(areasOfExpertise);
			newDietician.setAvailabilityHours(availabilityHours);
			newDietician.setRegistrationId(registrationId);
			newDietician.setQualification(qualification);
			newDietician.setTimeSlot(timeSlot);

			try {
				newDietician.createDietician(newDietician, password);
			} catch (Exception e) {
				logger.error(DIETICIAN_REGISTER_EXCEPTION + email);
				modelAndView = new ModelAndView("Signup");
				modelAndView.addObject("errorMessage", KLR_USR_ERR_CODE_001);
				return modelAndView;
			}
		} else {
			logger.error(DIETICIAN_REGISTER_EXCEPTION + email + BAD_FIELD_VALUES);
			modelAndView = new ModelAndView("Signup");
			modelAndView.addObject("errorMessage", KLR_USR_ERR_CODE_002);
			return modelAndView;
		}

		modelAndView = new ModelAndView("Login");
		modelAndView.addObject("successMessage", REGISTRATION_SUCCESS);
		return modelAndView;

	}
}
