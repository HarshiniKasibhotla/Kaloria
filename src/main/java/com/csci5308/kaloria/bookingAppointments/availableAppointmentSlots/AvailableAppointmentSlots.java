package com.csci5308.kaloria.bookingAppointments.availableAppointmentSlots;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.csci5308.kaloria.access.dietician.IDietician;

public class AvailableAppointmentSlots implements IAvailableAppointmentSlots{

    private static AvailableAppointmentSlots instance;
    private AvailableAppointmentSlots(){}
    public static AvailableAppointmentSlots getInstance(){
        if(instance == null) {
            instance = new AvailableAppointmentSlots();
        }
        return instance;
    }

    public ArrayList<String> getSlotsForDietician(String appointmentDate, IDietician selectedDietician,  ArrayList<Timestamp> allExistingAppointments){
        ArrayList<String> availableTimeSlots = new ArrayList<>();
        ArrayList<LocalTime> existingAppointmentsOnGivenDate = new ArrayList<>();
        LocalDate proposedDate = LocalDate.parse(appointmentDate);
        for(Timestamp t : allExistingAppointments) {
            LocalDate i = t.toLocalDateTime().toLocalDate();
            if(i.compareTo(proposedDate) == 0) {
                existingAppointmentsOnGivenDate.add(t.toLocalDateTime().toLocalTime());
            }
        }
        int  timeSlotDuration = selectedDietician.getTimeSlot();
        LocalTime startTime = LocalTime.parse(selectedDietician.getAvailabilityHours().split("-")[0].trim());
        LocalTime endTime = LocalTime.parse(selectedDietician.getAvailabilityHours().split("-")[1].trim());
        while(startTime.compareTo(endTime) < 0) {
            boolean exist = false;
            for(LocalTime t : existingAppointmentsOnGivenDate) {
                if(startTime.compareTo(t) == 0){
                    exist = true;
                }
            }
            if(exist == false) {
                availableTimeSlots.add(startTime.toString());
            }
            startTime = startTime.plusMinutes(timeSlotDuration);
        }
        return availableTimeSlots;
    }
}
