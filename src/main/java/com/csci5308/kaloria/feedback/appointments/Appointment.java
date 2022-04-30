package com.csci5308.kaloria.feedback.appointments;

import java.sql.Timestamp;

public class Appointment implements IAppointment{
    private int appointmentId;
    private int dieticianId;
    private Timestamp appointmentTime;
    private boolean isCompleted;
    private String address;
    private String firstName;
    private int rating;

    @Override
    public int getAppointmentId(){
        return appointmentId;
    }

    @Override
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Override
    public int getDieticianId(){
        return dieticianId;
    }

    @Override
    public void setDieticianId(int dieticianId){
        this.dieticianId = dieticianId;
    }

    @Override
    public Timestamp getAppointmentTime(){
        return appointmentTime;
    }

    @Override
    public void setAppointmentTime(Timestamp appointmentTime){
        this.appointmentTime = appointmentTime;
    }

    @Override
    public boolean getIsCompleted(){
        return isCompleted;
    }

    @Override
    public void setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }

    @Override
    public String getAddress(){
        return address;
    }

    @Override
    public void setAddress(String address, String zipCode){
        this.address = address + ", " + zipCode;
    }

    @Override
    public String getFirstName(){
        return firstName;
    }

    @Override
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    @Override
    public int getRating(){
        return rating;
    }

    @Override
    public void setRating(int rating){
        this.rating = rating;
    }
}
