package com.csci5308.kaloria.feedback;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.csci5308.kaloria.access.CurrentAuthenticatedUser;
import com.csci5308.kaloria.bookingAppointments.BookingAppointmentsController;
import com.csci5308.kaloria.feedback.appointments.Appointment;
import com.csci5308.kaloria.feedback.persistence.AppointmentPersistence;
import com.csci5308.kaloria.feedback.persistence.FeedbackPersistence;
import com.csci5308.kaloria.feedback.persistence.IFeedbackPersistence;
import com.csci5308.kaloria.utilities.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class FeedbackController {
    Logger logger = (Logger) LoggerUtility.getLoggerInstance(BookingAppointmentsController.class);

    @RequestMapping(value = "/appointmentHistory", method = RequestMethod.GET)
    public String getAppointmentHistory(Model appointment){
        AppointmentPersistence appointmentPersistence = new AppointmentPersistence();
        ArrayList<Appointment> appointments = appointmentPersistence.getAppointmentHistoryByUser(
                CurrentAuthenticatedUser.getAuthenticatedUser().getId()
        );
        ArrayList<Appointment> pastAppointment = new ArrayList<>();
        ArrayList<Appointment> futureAppointment = new ArrayList<>();
        Timestamp t = new Timestamp(System.currentTimeMillis());
        for( Appointment a : appointments) {
            if(t.compareTo(a.getAppointmentTime()) >= 0) {
                pastAppointment.add(a);
            }
            else {
                futureAppointment.add(a);
            }
        }
        appointment.addAttribute("futureAppointments", futureAppointment.toArray());
        appointment.addAttribute("pastAppointments", pastAppointment.toArray());
        return "get-appointment-history";
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public String getDieticianForFeedback(Model dietician,
                  @RequestParam(name = "appointment-id", required = true) String appointmentID,
                  @RequestParam(name = "dietitianID") int dietitianID){
        dietician.addAttribute("appointmentID", appointmentID);
        dietician.addAttribute("dietitianID", dietitianID);
        return "dietician-feedback";
    }

    @RequestMapping(value = "/feedback/submit", method = RequestMethod.POST)
    public String submitFeedback(Model dietician,
                     @RequestParam(name = "dietitianID") int dietitianID,
                     @RequestParam(name = "appointmentID") int appointmentID,
                     @RequestParam(name = "rating") int rating,
                     @RequestParam(name = "feedback") String review
    ) {
        IFeedbackPersistence feedbackPersistence = new FeedbackPersistence();
        feedbackPersistence.updateAppointmentFeedback(appointmentID, rating, review);
        feedbackPersistence.setDietitianRating(dietitianID);
        return "get-appointment-history";
    }
}
