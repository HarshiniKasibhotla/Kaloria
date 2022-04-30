package com.csci5308.kaloria.access.calculators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.csci5308.kaloria.utilities.Constants;

public class AgeCalculator implements IAgeCalculator, Constants {

	@Override
	public int calculateAge(String dob) {

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		Date date = null;
		try {
			date = sdf.parse(dob);
		} catch (ParseException e) {
			
		}
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.setTime(date);
		Calendar currentDay = Calendar.getInstance();
		int age = currentDay.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		int dobMonth = dateOfBirth.get(Calendar.MONTH);
		int currentMonth = currentDay.get(Calendar.MONTH);
		if (dobMonth > currentMonth) {
			age--;
		} else if (dobMonth == currentMonth) {
			if (dateOfBirth.get(Calendar.DAY_OF_MONTH) > currentDay.get(Calendar.DAY_OF_MONTH)) {
				age--;
			}
		}
		return age;
	}

}
