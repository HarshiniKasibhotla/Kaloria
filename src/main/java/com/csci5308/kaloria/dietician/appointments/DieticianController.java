package com.csci5308.kaloria.dietician.appointments;

import com.csci5308.kaloria.dietChart.IDietChart;
import com.csci5308.kaloria.dietChart.persistence.DietChartPersistence;
import com.csci5308.kaloria.dietChart.persistence.IDietChartPersistence;
import com.csci5308.kaloria.dietChart.serialization.DietChartSerializer;
import com.csci5308.kaloria.dietChart.serialization.IDietChartSerializer;
import com.csci5308.kaloria.dietChart.services.DietChartService;
import com.csci5308.kaloria.dietChart.services.IDietChartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DieticianController {
	private final IDietChartService dietChartService;

	public DieticianController() {
		IDietChartSerializer dietChartSerializer = new DietChartSerializer();
		IDietChartPersistence dietChartPersistence = new DietChartPersistence(dietChartSerializer);
		this.dietChartService = new DietChartService(dietChartPersistence);
	}

	@RequestMapping("/userDietChart")
	public String getUserDietChart(@RequestParam("userID") int userID, Model dietChartModel) {
		IDietChart dietChart = dietChartService.getLatestDietChart(userID);
		dietChartModel.addAttribute("dietChart", dietChart);
		return "dietician_user_diet_chart";
	}
}
