package com.csci5308.kaloria.access;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.csci5308.kaloria.access.calculators.DateConverter;
import com.csci5308.kaloria.access.calculators.IDateConverter;

public class DateConverterTest {

	IDateConverter dateConverter = new DateConverter();

	@Test
	@DisplayName("Convert Util Date to SQL Date(positive scenario)")
	public void dateConvertorSuccessCaseTest() throws ParseException {

		Date date = new Date();
		Timestamp returnedTimeStamp = dateConverter.convertDate(date);
		assertEquals(0, returnedTimeStamp.compareTo(date));
	}

}
