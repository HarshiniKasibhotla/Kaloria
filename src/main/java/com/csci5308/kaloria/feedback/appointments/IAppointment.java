package com.csci5308.kaloria.feedback.appointments;


import java.sql.Timestamp;

public interface IAppointment {
    int getAppointmentId();

    void setAppointmentId(int Id);

    int getDieticianId();

    void setDieticianId(int Id);

    Timestamp getAppointmentTime();

    void setAppointmentTime(Timestamp Id);

    boolean getIsCompleted();

    void setIsCompleted(boolean isCompleted);

    String getAddress();

    void setAddress(String address, String zipCode);

    String getFirstName();

    void setFirstName(String firstName);

    int getRating();

    void setRating(int rating);
}
