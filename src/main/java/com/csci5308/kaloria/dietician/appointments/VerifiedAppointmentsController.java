package com.csci5308.kaloria.dietician.appointments;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csci5308.kaloria.access.user.UserPersistance;

@Controller
public class VerifiedAppointmentsController {

	@RequestMapping(value = "/verifiedAppointment", method = RequestMethod.GET)
	public String verifiedAppointments(Model model) {

		ArrayList<VerifiedAppointments> va = new ArrayList<VerifiedAppointments>();
		UserPersistance up = new UserPersistance();

		try {
			ArrayList<VerifiedAppointments> results = up.getVerifiedAppointments();
			for (VerifiedAppointments verAppointments : results) {
				VerifiedAppointments verified = new VerifiedAppointments();
				verified.firstName = verAppointments.getName();
				verified.email = verAppointments.getEmail();
				verified.mobile = verAppointments.getMobile();
				verified.userId = verAppointments.getUserId();
				va.add(verified);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("verifiedAppointment", va.toArray());

		return "VerifiedAppointments.html";
	}
}
