package com.csci5308.kaloria.Feedback.appointments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csci5308.kaloria.feedback.appointments.Appointment;

class AppointmentTest {

	Appointment appointment;

	@BeforeEach
	public void setUp() {
		appointment = new Appointment();
	}

	@Test
	void getAppointmentId() {
		appointment.setAppointmentId(20);
		assertEquals(20, appointment.getAppointmentId());
	}

	@Test
	void getDieticianId() {
		appointment.setDieticianId(1);
		assertEquals(1, appointment.getDieticianId());
	}

	@Test
	void getAddress() {
		appointment.setAddress("Street 123", "B3J 2K9");
		assertEquals("Street 123, B3J 2K9", appointment.getAddress());
	}

	@Test
	void getFirstName() {
		appointment.setFirstName("Smily");
		assertEquals("Smily", appointment.getFirstName());
	}

}