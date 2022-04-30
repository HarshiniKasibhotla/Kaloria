package com.csci5308.kaloria.feedback.persistence;

import com.csci5308.kaloria.feedback.appointments.Appointment;

import java.util.ArrayList;

public interface IAppointmentPersistence {
    ArrayList<Appointment> getAppointmentHistoryByUser(int userID);
}
