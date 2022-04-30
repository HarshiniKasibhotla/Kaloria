package com.csci5308.kaloria.access.calculators;

import java.sql.Timestamp;
import java.util.Date;

public class DateConverter implements IDateConverter {

	public Timestamp convertDate(Date utilDate) {

		Timestamp timestamp = new Timestamp(utilDate.getTime());
		return timestamp;
	}

}
