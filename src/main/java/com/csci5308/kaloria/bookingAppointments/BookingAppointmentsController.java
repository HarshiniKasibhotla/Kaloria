package com.csci5308.kaloria.bookingAppointments;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.csci5308.kaloria.access.CurrentAuthenticatedUser;
import com.csci5308.kaloria.access.dietician.IDietician;
import com.csci5308.kaloria.admin.verifiedDieticians.VerifiedDietician;
import com.csci5308.kaloria.bookingAppointments.Persistence.IPersistence;
import com.csci5308.kaloria.bookingAppointments.Persistence.Persistence;
import com.csci5308.kaloria.bookingAppointments.availableAppointmentSlots.AvailableAppointmentSlots;
import com.csci5308.kaloria.bookingAppointments.availableAppointmentSlots.IAvailableAppointmentSlots;
import com.csci5308.kaloria.utilities.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingAppointmentsController {
    Logger logger = (Logger) LoggerUtility.getLoggerInstance(BookingAppointmentsController.class);
    IPersistence dieticianPersistence = new Persistence();

    @RequestMapping(value = "/bookAppointment", method = RequestMethod.GET)
    public String getVerfiedDietitians(Model dieticianModel) throws SQLException {
        ArrayList<VerifiedDietician> dieticians = dieticianPersistence.getVerifiedDieticians();
        dieticianModel.addAttribute("verifiedDieticians", dieticians.toArray());
        return "book-appointments-dieticians-table";
    }

     @RequestMapping(value = "/bookAppointmentUsingFilter", method = RequestMethod.POST)
    public String getVerfiedDietitiansSorted(Model dieticianModel,
                                             @RequestParam(name = "filterBy") String filterBy) throws SQLException {
        ArrayList<VerifiedDietician> dieticians = dieticianPersistence.getVerifiedDieticians();
        if(filterBy.equals("rating")) {
            dieticians.sort((d1, d2) -> {
                int i = Integer.valueOf(d1.getDieticianRating()).compareTo(Integer.valueOf(d2.getDieticianRating()));
                return i == 0? 0: -i;
            });
        }
        dieticianModel.addAttribute("verifiedDieticians", dieticians.toArray());
        return "book-appointments-dieticians-table";
    }

    @RequestMapping(value = "appointments/dietician-availability-slot", method = RequestMethod.GET)
    public String getDieticianSlots(Model dieticianSlots,
                                    @RequestParam(value="dietician-id",required=true) String dietitianID){
        IDietician selectedDietician = dieticianPersistence.getSelectedDietician(Integer.parseInt(dietitianID));
        dieticianSlots.addAttribute("selectedDietician", selectedDietician);
        dieticianSlots.addAttribute("dietitianID", dietitianID);
        dieticianSlots.addAttribute("showSlots", false);
        return "dietician-availability-slot";
    }

    @RequestMapping(value = "/appointments/dietician-availability-slot/selectTimeSlot", method=RequestMethod.POST)
    public ModelAndView processForm(@RequestParam(name = "appointmentDate") String appointmentDate,
                                    @RequestParam(name = "dietitianID") String dietitianID){

        IDietician selectedDietician = dieticianPersistence.getSelectedDietician(Integer.parseInt(dietitianID));
        ArrayList<Timestamp> allExistingAppointments = dieticianPersistence.getDietitianBlockedTime(Integer.parseInt(dietitianID));
        IAvailableAppointmentSlots availableAppointmentSlots = AvailableAppointmentSlots.getInstance();
        ArrayList<String> availableTimeSlots = availableAppointmentSlots.
                getSlotsForDietician(appointmentDate, selectedDietician, allExistingAppointments);

        ModelAndView modelAndView = new ModelAndView("dietician-availability-slot");
        modelAndView.addObject("selectedDietician", selectedDietician);
        modelAndView.addObject("dietitianID", dietitianID);
        modelAndView.addObject("appointmentDate", appointmentDate);
        modelAndView.addObject("timeSlotDuration", selectedDietician.getTimeSlot());
        modelAndView.addObject("showSlots", true);

        modelAndView.addObject("startTimeList", availableTimeSlots);

        return modelAndView;
    }

    @RequestMapping(value = "/appointments/dietician-availability-slot/bookingAppointmentSubmit", method=RequestMethod.POST)
    public ModelAndView processForm(@RequestParam(name = "appointmentDate") String appointmentDate,
                                    @RequestParam(name = "dietitianID") String dietitianID,
                                    @RequestParam(name = "selectedSlotTime") String timeSlot,
                                    @RequestParam(name = "timeSlotDuration") int timeSlotDuration
    ) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("book-dietician-appointment");

        Timestamp slotTime = Timestamp.valueOf(appointmentDate + " " + timeSlot + ":00");

        dieticianPersistence.insertAppointment(Integer.parseInt(dietitianID),
                CurrentAuthenticatedUser.getAuthenticatedUser().getId(),
                slotTime, timeSlotDuration);

        return modelAndView;
    }

}
