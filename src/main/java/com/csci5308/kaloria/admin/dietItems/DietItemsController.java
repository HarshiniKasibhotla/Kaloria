package com.csci5308.kaloria.admin.dietItems;

import com.csci5308.kaloria.admin.AdminPersistence;
import com.csci5308.kaloria.controller.PresentationModels.DietItem;
import com.csci5308.kaloria.errorHandling.ErrorMessages;
import com.csci5308.kaloria.utilities.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class DietItemsController implements ErrorMessages {

	Logger logger = LoggerUtility.getLoggerInstance(DietItemsController.class);

	@RequestMapping(value = "/viewDietItems", method = RequestMethod.GET)
	public String showDietItems(Model model) {

		ArrayList<DietItem> t = new ArrayList<DietItem>();
		AdminPersistence ap = new AdminPersistence();
		try {
			ArrayList<DietItems> results = ap.GetDietItems();
			for (DietItems dItem : results) {
				DietItem dt = new DietItem();
				dt.Name = dItem.getItemName();
				dt.NutrientType = dItem.getNutrientType();
				dt.Calories = dItem.getCalories();
				dt.Id = dItem.getItemId();
				dt.category = dItem.getCategory();
				dt.health = dItem.getHealth();
				dt.allergy = dItem.getAllergy();
				dt.meal = dItem.getMeal();
				t.add(dt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("dietitems", t.toArray());
		return "ViewDietItems.html";
	}

	// add link on click
	@GetMapping(value = { "/DietItem/Add" })
	public String AddDietItem(Model model) {

		DietItem dietItem = new DietItem();
		dietItem.IsEdit = false;

		model.addAttribute("DietItemsData", dietItem);
		return "CreateOrEditDietItem.html";
	}

	// on click of save in add link
	@PostMapping(value = { "/DietItem/Add" })
	public String AddDietItem(Model model, @ModelAttribute("DietItemsData") DietItem savableOject) {

		DietItem dietItem = new DietItem();
		dietItem.IsEdit = false;

		model.addAttribute("DietItemsData", dietItem);
		return "redirect:/admin";
	}

	@GetMapping(value = { "/DietItem/{editableId}/Edit" })
	public String EditDietItem(Model model, @PathVariable Integer editableId) {

		DietItem dt = new DietItem();
		dt.IsEdit = true;
		AdminPersistence ap = new AdminPersistence();
		try {
			ArrayList<DietItems> results = ap.GetDietItems();
			for (DietItems dItem : results) {
				if (dItem.getItemId() == editableId) {
					dt.Name = dItem.getItemName();
					dt.NutrientType = dItem.getNutrientType();
					dt.Calories = dItem.getCalories();
					dt.Id = dItem.getItemId();
					dt.category = dItem.getCategory();
					dt.health = dItem.getHealth();
					dt.allergy = dItem.getAllergy();
					dt.meal = dItem.getMeal();
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("DietItemsData", dt);
		return "CreateOrEditDietItem.html";
	}

	@PostMapping(value = { "/DietItem/{editableId}/Edit" })
	public String EditDietItem(Model model, @PathVariable Integer editableId,
			@ModelAttribute("DietItemsData") DietItem savableOject) {

		DietItem dietItem = new DietItem();
		dietItem.IsEdit = true;

		return "redirect:/admin";
	}

	@GetMapping(value = { "/DietItem/{deleteId}/Delete" })
	public String DeleteDietItem(Model model, @PathVariable Integer deleteId) throws SQLException {
		AdminPersistence ap = new AdminPersistence();

		ap.deleteDietItem(deleteId);

		return "redirect:/admin";
	}

	@GetMapping(value = {
			"/EditDietItem/{itemId}/{nutrientType}/{name}/{calories}/{category}/{health}/{allergy}/{meal}" })
	public String updateDietItem(Model model, @PathVariable Integer itemId, @PathVariable String nutrientType,
			@PathVariable String name, @PathVariable Integer calories, @PathVariable String category,
			@PathVariable String health, @PathVariable String allergy, @PathVariable String meal) throws SQLException {
		AdminPersistence ap = new AdminPersistence();
		if (itemId == 0) {
			IDietItems newItem = new DietItems();
			newItem.setNutrientType(nutrientType);
			newItem.setItemName(name);
			newItem.setCalories(calories);
			newItem.setCategory(category);
			newItem.setHealth(health);
			newItem.setHealth(allergy);
			newItem.setMeal(meal);
			ap.insertNewItem(newItem);
		} else {
			ap.updateDietItem(itemId, nutrientType, name, calories, category, health, allergy, meal);
		}
		return "redirect:/admin";
	}

}
