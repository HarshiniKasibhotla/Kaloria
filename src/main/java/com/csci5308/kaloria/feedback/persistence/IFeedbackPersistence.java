package com.csci5308.kaloria.feedback.persistence;

public interface IFeedbackPersistence {
    void updateAppointmentFeedback(int appointmentID, int rating, String review);
    void setDietitianRating(int dieticianID);

}
