package com.csci5308.kaloria.bookingAppointments.Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.csci5308.kaloria.access.dietician.Dietician;
import com.csci5308.kaloria.admin.verifiedDieticians.VerifiedDietician;
import com.csci5308.kaloria.database.CallStoredProcedures;

public class Persistence implements IPersistence {
    @Override
    public ArrayList<VerifiedDietician> getVerifiedDieticians() throws SQLException {
        ArrayList<VerifiedDietician> verifiedDieticians = new ArrayList<VerifiedDietician>();

        CallStoredProcedures getverifiedDietician = null;
        try {

            getverifiedDietician = new CallStoredProcedures("spGetVerifiedDietician");
            ResultSet dieticians = getverifiedDietician.executeWithResults();
            while (dieticians.next()) {
                VerifiedDietician verifiedDietician = new VerifiedDietician();
                String dieticianName = dieticians.getString("FirstName") + dieticians.getString("LastName");
                String dieticianAddress = dieticians.getString("Address");
                String zipCode = dieticians.getString("ZipCode");
                int rating = dieticians.getInt("Rating");
                int dieticianId = dieticians.getInt("DietitianId");


                verifiedDietician.setDieticianId(dieticianId);
                verifiedDietician.setDieticianName(dieticianName);
                verifiedDietician.setDieticianAddress(dieticianAddress);
                verifiedDietician.setDieticianRating(rating);
                verifiedDietician.setDieticianZipCode(zipCode);
                verifiedDieticians.add(verifiedDietician);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != getverifiedDietician) {
                getverifiedDietician.cleanup();
            }
        }
        return verifiedDieticians;
    }

    public Dietician getSelectedDietician(int id){
        Dietician selectedDietician = new Dietician();

        CallStoredProcedures getSelectedDietician = null;
        try {
            getSelectedDietician = new CallStoredProcedures("spGetDieticianByUniqueId(?)");
            getSelectedDietician.setParameter(1, id);
            ResultSet dieticians = getSelectedDietician.executeWithResults();
            if(dieticians.next()){
                String firstName = dieticians.getString("FirstName");
                String lastName = dieticians.getString("LastName");
                String dieticianName;
                if(lastName != null){
                    dieticianName = firstName + " " + lastName;
                } else{
                    dieticianName = firstName;
                }
                String availabilityHours = dieticians.getString("Availability_Hours");
                selectedDietician.setDieticianName(dieticianName);
                selectedDietician.setAvailabilityHours(availabilityHours);
                selectedDietician.setTimeSlot(dieticians.getInt("TimeSlot"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != getSelectedDietician) {
                getSelectedDietician.cleanup();
            }
        }
        return selectedDietician;
    }

    public ArrayList getDietitianBlockedTime(int dietitianID) {
        ArrayList<Timestamp> bookedTimings = new ArrayList();
        CallStoredProcedures getBookedTimeSlots = null;
        try {
            getBookedTimeSlots = new CallStoredProcedures("spGetDieticianAppointments(?)");
            getBookedTimeSlots.setParameter(1, dietitianID);
            ResultSet dieticianAppointments = getBookedTimeSlots.executeWithResults();

            while (dieticianAppointments.next()) {

                bookedTimings.add(dieticianAppointments.getTimestamp("start_time"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            getBookedTimeSlots.cleanup();
        }
        return bookedTimings;
    }

    public boolean insertAppointment(int dietitianID, int userID, Timestamp timestamp, int duration) {
        CallStoredProcedures insertAppointment = null;
        try {
            insertAppointment = new CallStoredProcedures("spInsertAppointment(?, ?, ?, ?)");
            insertAppointment.setParameter(1, dietitianID);
            insertAppointment.setParameter(2, userID);
            insertAppointment.setParameter(3, timestamp);
            insertAppointment.setParameter(4, duration);
            ResultSet dieticians = insertAppointment.executeWithResults();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            insertAppointment.cleanup();
        }
        return true;
    }


}
