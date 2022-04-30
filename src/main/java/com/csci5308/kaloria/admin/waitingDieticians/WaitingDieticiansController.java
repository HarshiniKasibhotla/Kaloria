package com.csci5308.kaloria.admin.waitingDieticians;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csci5308.kaloria.admin.AdminPersistence;
import com.csci5308.kaloria.controller.PresentationModels.WaitingDietician;

@Controller
public class WaitingDieticiansController {

	@RequestMapping(value = "/waitingDoc", method = RequestMethod.GET)
	public String waitingDieticians(Model model) {

		ArrayList<WaitingDietician> wd = new ArrayList<WaitingDietician>();
		AdminPersistence ap = new AdminPersistence();

		try {
			ArrayList<WaitingDieticians> results = ap.getWaitingDieticians();
			for (WaitingDieticians waitDietician : results) {
				WaitingDietician waiting = new WaitingDietician();
				waiting.dieticianName = waitDietician.getDieticianName();
				waiting.dAddress = waitDietician.getDieticianAddress();
				waiting.expertise = waitDietician.getExpertise();
				waiting.license = waitDietician.getLicense();
				waiting.dieticianId = waitDietician.getDieticianId();
				wd.add(waiting);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		model.addAttribute("waitingDieticians", wd.toArray());
		return "Waiting.html";

	}

	@GetMapping(value = { "/Dietician/{dieticianId}/{approvalStatus}" })
	public String ApproveDietician(Model model, @PathVariable Integer dieticianId, @PathVariable Boolean approvalStatus)
			throws SQLException {
		AdminPersistence ap = new AdminPersistence();
		ap.updateDieticianStatus(dieticianId, approvalStatus);
		return "Verified.html";
	}
}
