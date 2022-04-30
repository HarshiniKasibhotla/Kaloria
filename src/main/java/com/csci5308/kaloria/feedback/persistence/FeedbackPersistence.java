package com.csci5308.kaloria.feedback.persistence;

import com.csci5308.kaloria.database.CallStoredProcedures;
import com.csci5308.kaloria.feedback.ratingDietician.IRating;
import com.csci5308.kaloria.feedback.ratingDietician.Rating;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackPersistence implements IFeedbackPersistence{

    @Override
    public void updateAppointmentFeedback(int appointmentID, int rating, String review) {
        CallStoredProcedures updateAppointmentFeedbackProcedure = null;
        try {
            updateAppointmentFeedbackProcedure = new CallStoredProcedures("spUpdateDieticianAppointment(?, ?, ?)");// use constants for procedure name
            updateAppointmentFeedbackProcedure.setInt(1, appointmentID);
            updateAppointmentFeedbackProcedure.setInt(2, rating);
            updateAppointmentFeedbackProcedure.setParameter(3, review);
            updateAppointmentFeedbackProcedure.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (updateAppointmentFeedbackProcedure != null) {
                updateAppointmentFeedbackProcedure.cleanup();
            }
        }
    }

    @Override
    public void setDietitianRating(int dieticianID) {
        CallStoredProcedures getSelectedDietician = null;
        CallStoredProcedures updateDieticianRating = null;
        try {
            getSelectedDietician = new CallStoredProcedures("spGetDieticianAppointmentRating(?)");
            getSelectedDietician.setParameter(1, dieticianID);

            ResultSet dieticianReviews = getSelectedDietician.executeWithResults();
            IRating dieticianRating = Rating.getRatingInstance();
            long dieticianRatingAverage = dieticianRating.getAvergeDieticianRating(dieticianReviews);

            if(dieticianRatingAverage!=0) {
                updateDieticianRating = new CallStoredProcedures("spSetAvgRatings(?, ?)");
                updateDieticianRating.setParameter(1, dieticianID);

                updateDieticianRating.setParameter(2, (long) dieticianRatingAverage);
                updateDieticianRating.execute();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != getSelectedDietician) {
                getSelectedDietician.cleanup();
            }
        }
    }
}
