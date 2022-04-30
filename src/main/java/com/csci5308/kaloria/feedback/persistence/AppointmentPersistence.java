package com.csci5308.kaloria.feedback.persistence;

import com.csci5308.kaloria.database.CallStoredProcedures;
import com.csci5308.kaloria.feedback.appointments.Appointment;
import com.csci5308.kaloria.feedback.appointments.IAppointment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class AppointmentPersistence implements IAppointmentPersistence{

    @Override
    public ArrayList<Appointment> getAppointmentHistoryByUser(int userID) {
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        CallStoredProcedures getAppointmentHistory = null;

        try {
            getAppointmentHistory = new CallStoredProcedures("spGetAppointmentHistory(?)");
            getAppointmentHistory.setInt(1, userID);
            ResultSet allAppointmentsForUser = getAppointmentHistory.executeWithResults();

            while (allAppointmentsForUser.next()) {
                Appointment appointment = new Appointment();
                int appointmentId = allAppointmentsForUser.getInt("appointment_id");
                int dieticianId = allAppointmentsForUser.getInt("dietitian_id");
                Timestamp appointmentTime = allAppointmentsForUser.getTimestamp("start_time");
                boolean isCompleted = allAppointmentsForUser.getBoolean("completed");
                String firstName = allAppointmentsForUser.getString("FirstName");
                String address = allAppointmentsForUser.getString("Address");
                String zipCode = allAppointmentsForUser.getString("ZipCode");
                int rating = allAppointmentsForUser.getInt("rating");

                appointment.setAppointmentId(appointmentId);
                appointment.setDieticianId(dieticianId);
                appointment.setAppointmentTime(appointmentTime);
                appointment.setIsCompleted(isCompleted);
                appointment.setAddress(address, zipCode);
                appointment.setFirstName(firstName);
                appointment.setRating(rating);
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (getAppointmentHistory != null) {
                getAppointmentHistory.cleanup();
            }
        }
    return appointments;
    }
}
