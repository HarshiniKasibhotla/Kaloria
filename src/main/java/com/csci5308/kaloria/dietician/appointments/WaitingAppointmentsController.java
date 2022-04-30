package com.csci5308.kaloria.dietician.appointments;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csci5308.kaloria.access.user.UserPersistance;

@Controller
public class WaitingAppointmentsController {

	@RequestMapping(value = "/waitingAppointment", method = RequestMethod.GET)
	public String waitingAppointments(Model model) {

		ArrayList<WaitingAppointments> wa = new ArrayList<WaitingAppointments>();
		UserPersistance up = new UserPersistance();

		try {
			ArrayList<WaitingAppointments> results = up.getWaitingAppointments();
			for (WaitingAppointments waitAppointment : results) {
				WaitingAppointments waiting = new WaitingAppointments();
				waiting.firstName = waitAppointment.getName();
				waiting.email = waitAppointment.getEmail();
				waiting.mobile = waitAppointment.getMobile();
				waiting.userId = waitAppointment.getUserId();
				wa.add(waiting);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("waitingAppointment", wa.toArray());
		return "WaitingAppointments.html";

	}

	@GetMapping(value = { "/User/{userId}/{appointmentApprovalStatus}" })
	public String ApproveAppointment(Model model, @PathVariable Integer userId,
			@PathVariable Boolean appointmentApprovalStatus) throws SQLException {
		UserPersistance up = new UserPersistance();
		up.updateAppointmentStatus(userId, appointmentApprovalStatus);
		return "redirect:/dietician";
	}

}
