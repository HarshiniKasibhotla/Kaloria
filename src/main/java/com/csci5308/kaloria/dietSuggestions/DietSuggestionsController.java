package com.csci5308.kaloria.dietSuggestions;

import com.csci5308.kaloria.dietSuggestions.activityLevel.ActivityLevel;
import com.csci5308.kaloria.dietSuggestions.activityLevel.IActivityLevel;
import com.csci5308.kaloria.dietSuggestions.algorithm.DietSuggestor;
import com.csci5308.kaloria.dietSuggestions.algorithm.IDietSuggestor;
import com.csci5308.kaloria.dietSuggestions.algorithm.partitioner.CaloriesPartitioner;
import com.csci5308.kaloria.dietSuggestions.algorithm.partitioner.ICaloriesPartitioner;
import com.csci5308.kaloria.dietSuggestions.calorieCalculator.CalorieIntakeCalculator;
import com.csci5308.kaloria.dietSuggestions.calorieCalculator.ICalorieIntakeCalculator;
import com.csci5308.kaloria.dietSuggestions.healthFactorCalculator.HealthFactorCalculatorFactory;
import com.csci5308.kaloria.dietSuggestions.healthFactorCalculator.HealthFactorCalculatorType;
import com.csci5308.kaloria.dietSuggestions.healthFactorCalculator.IHealthFactorCalculator;
import com.csci5308.kaloria.dietSuggestions.healthParameters.HealthParameters;
import com.csci5308.kaloria.dietSuggestions.healthParameters.IHealthParameters;
import com.csci5308.kaloria.dietSuggestions.persistence.DietItemPersistence;
import com.csci5308.kaloria.dietSuggestions.persistence.IDietItemPersistence;
import com.csci5308.kaloria.dietSuggestions.services.DietItemService;
import com.csci5308.kaloria.dietSuggestions.services.IDietItemService;
import com.csci5308.kaloria.utilities.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class DietSuggestionsController {

    private final IDietItemService dietItemService;

    public DietSuggestionsController() {
        IDietItemPersistence dietItemPersistence = new DietItemPersistence();
        this.dietItemService = new DietItemService(dietItemPersistence);
    }

    @RequestMapping(value = "/")
    public String getDietSuggestions(Model formDataModel) {
        setFormData(formDataModel);
        return "diet_suggestions";
    }

    @RequestMapping(value = "/dietSuggestions", method = RequestMethod.POST)
    public String getDietSuggestions(@ModelAttribute("healthParameters") HealthParameters healthParameters,
                                     Model formDataModel) {
        IHealthFactorCalculator healthFactorCalculator = HealthFactorCalculatorFactory.getInstance(healthParameters);

        ICalorieIntakeCalculator calorieIntakeCalculator = new CalorieIntakeCalculator(healthFactorCalculator);
        double calorieIntake = calorieIntakeCalculator.calculateCalorieIntake(healthParameters);

        setFormData(formDataModel);
        formDataModel.addAttribute("healthParameters", healthParameters);
        formDataModel.addAttribute("calorieIntake", calorieIntake);
        return "diet_suggestions";
    }

    private void setFormData(Model formDataModel) {
        IHealthParameters healthParameters = new HealthParameters();

        List<HealthFactorCalculatorType> units = new ArrayList<>();
        units.add(HealthFactorCalculatorType.METRIC);
        units.add(HealthFactorCalculatorType.IMPERIAL);

        List<String> healthAilments = new ArrayList<>();
        healthAilments.add("Diabetes");
        healthAilments.add("Thyroid");
        healthAilments.add("None");

        List<String> allergies = new ArrayList<>();
        allergies.add("Gluten");
        allergies.add("Lactose");
        allergies.add("None");

        List<String> mealPreferences = Arrays.asList("Vegetarian", "Non-Vegetarian", "Vegan");

        List<IActivityLevel> activityLevels = new ArrayList<>();
        activityLevels.add(new ActivityLevel("Little to no exercise", 1.2));
        activityLevels.add(new ActivityLevel("Light - Exercise 1-3 times/week", 1.37));
        activityLevels.add(new ActivityLevel("Moderate - Exercise 4-5 times/week", 1.46));
        activityLevels.add(new ActivityLevel("Active - Daily exercise", 1.55));

        formDataModel.addAttribute("healthParameters", healthParameters);
        formDataModel.addAttribute("units", units);
        formDataModel.addAttribute("healthAilments", healthAilments);
        formDataModel.addAttribute("activityLevels", activityLevels);
        formDataModel.addAttribute("allergies", allergies);
        formDataModel.addAttribute("mealPreferences", mealPreferences);
    }

    @RequestMapping(value = "/viewDietSuggestions", method = RequestMethod.POST)
    public String viewDietSuggestions(@RequestParam("calorieIntake") double calorieIntake, @RequestParam("healthAilment") String healthAilment, @RequestParam("allergy") String allergy, @RequestParam("mealPreference") String mealPreference, Model dataModel) {
        ICaloriesPartitioner caloriesPartitioner = new CaloriesPartitioner();
        IDietSuggestor dietSuggestor = new DietSuggestor(dietItemService, caloriesPartitioner);
        Map<String, List<Pair>> dietSuggestions = dietSuggestor.getDietSuggestions((int) calorieIntake, healthAilment, allergy, mealPreference);
        dataModel.addAttribute("dietSuggestions", dietSuggestions);
        return "view_diet_suggestions";
    }
}
