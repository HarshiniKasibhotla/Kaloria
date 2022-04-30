package com.csci5308.kaloria.admin.verifiedDieticians;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csci5308.kaloria.admin.AdminPersistence;
import com.csci5308.kaloria.controller.PresentationModels.VerifiedDieticians;

@Controller
public class VerifiedDieticiansController {

	@RequestMapping(value = "/verifiedDoc", method = RequestMethod.GET)
	public String verifiedDieticians(Model model) {

		ArrayList<VerifiedDieticians> vd = new ArrayList<VerifiedDieticians>();
		AdminPersistence ap = new AdminPersistence();

		try {
			ArrayList<VerifiedDietician> results = ap.getVerifiedDieticians();
			for (VerifiedDietician verDietician : results) {
				VerifiedDieticians verified = new VerifiedDieticians();
				verified.dieticianName = verDietician.getDieticianName();
				verified.dAddress = verDietician.getDieticianAddress();
				verified.expertise = verDietician.getExpertise();
				verified.license = verDietician.getLicense();
				verified.dietitianId = verDietician.getDieticianId();
				vd.add(verified);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("verifiedDieticians", vd.toArray());

		return "Verified.html";
	}

}
