package com.csci5308.kaloria.access;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.csci5308.kaloria.access.calculators.AgeCalculator;
import com.csci5308.kaloria.access.calculators.IAgeCalculator;

public class AgeCalculatorTest {

	IAgeCalculator ageCalculator = new AgeCalculator();

	@Test
	@DisplayName("Calculate age test")
	public void testCalculateAge() throws ParseException {
		String dob = "1999-03-16";
		int expectedResult = 22;
		assertEquals(ageCalculator.calculateAge(dob), expectedResult);
	}

	@Test
	@DisplayName("Calculate age when current month is greater than dob month")
	public void testCalculateAgeMonth() throws ParseException {
		String dob = "1999-12-16";
		int expectedResult = 21;
		assertEquals(ageCalculator.calculateAge(dob), expectedResult);
	}

	@Test
	@DisplayName("Calculate age when current day is greater than dob day")
	public void testCalculateAgeDays() throws ParseException {
		String dob = "1999-11-16";
		int expectedResult = 22;
		assertEquals(ageCalculator.calculateAge(dob), expectedResult);
	}
}
