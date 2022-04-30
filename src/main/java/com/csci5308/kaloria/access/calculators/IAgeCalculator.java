package com.csci5308.kaloria.access.calculators;

import java.text.ParseException;

public interface IAgeCalculator {
	
	public int calculateAge(String dob) throws ParseException;

}
