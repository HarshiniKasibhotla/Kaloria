package com.csci5308.kaloria.bookingAppointments.Persistence;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.csci5308.kaloria.access.dietician.IDietician;
import com.csci5308.kaloria.admin.verifiedDieticians.VerifiedDietician;

public interface IPersistence {
	ArrayList<VerifiedDietician> getVerifiedDieticians() throws SQLException;

	IDietician getSelectedDietician(int dieticianId);

	ArrayList<Timestamp> getDietitianBlockedTime(int dieticianId);

	boolean insertAppointment(int dieticianId, int userId, Timestamp timeSlot, int timeSlotDuration);
}
