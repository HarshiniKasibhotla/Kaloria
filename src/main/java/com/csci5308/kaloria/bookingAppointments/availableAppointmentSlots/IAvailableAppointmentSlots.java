package com.csci5308.kaloria.bookingAppointments.availableAppointmentSlots;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.csci5308.kaloria.access.dietician.IDietician;

public interface IAvailableAppointmentSlots {
    ArrayList<String> getSlotsForDietician(String appointmentDate, IDietician dietician, ArrayList<Timestamp> allExistingAppointments);
}
