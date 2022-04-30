package com.csci5308.kaloria.dietSuggestions.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.csci5308.kaloria.admin.dietItems.IDietItems;
import com.csci5308.kaloria.dietSuggestions.algorithm.partitioner.ICaloriesPartitioner;
import com.csci5308.kaloria.dietSuggestions.services.IDietItemService;
import com.csci5308.kaloria.utilities.Pair;

public class DietSuggestor implements IDietSuggestor {
	private final IDietItemService dietItemService;
	private final ICaloriesPartitioner caloriesPartitioner;

	public DietSuggestor(IDietItemService dietItemService, ICaloriesPartitioner caloriesPartitioner) {
		this.dietItemService = dietItemService;
		this.caloriesPartitioner = caloriesPartitioner;
	}

	public Map<String, List<Pair>> getDietSuggestions(int calorieIntake, String healthAilment, String allergy,
			String mealPreference) {
		String requiredHealthAilment = "NA";
		String requiredAllergy = "NA";
		String requiredMealPreference = "%";

		if (healthAilment != null && !healthAilment.isEmpty()) {
			requiredHealthAilment = healthAilment;
		}
		if (allergy != null && !allergy.isEmpty()) {
			requiredAllergy = allergy;
		}
		if (mealPreference != null && !mealPreference.isEmpty()) {
			requiredMealPreference = mealPreference;
		}

		List<IDietItems> dietItems = dietItemService.retrieveDietItems(requiredHealthAilment, requiredAllergy,
				requiredMealPreference);

		if (dietItems == null) {
			return null;
		}

		Map<String, Integer> partitions = caloriesPartitioner.parition(calorieIntake);
		Map<String, List<Pair>> dietSuggestions = getSuggestions(partitions, dietItems);
		return dietSuggestions;
	}

	private Map<String, List<Pair>> getSuggestions(Map<String, Integer> partitions, List<IDietItems> dietItems) {
		Map<String, List<Pair>> dietSuggestions = new HashMap<>();
		for (Map.Entry<String, Integer> partition : partitions.entrySet()) {
			String dietCategory = partition.getKey();
			int calorieDistribution = partition.getValue();
			List<Pair> recommendations = getRecommendations(dietItems, calorieDistribution);
			dietSuggestions.put(dietCategory, recommendations);
		}
		return dietSuggestions;
	}

	private List<Pair> getRecommendations(List<IDietItems> dietItems, Integer totalCalories) {
		List<Pair> recommendations = new ArrayList<>();
		int bound = Math.max(1, dietItems.size());
		int randItemIndex = new Random().nextInt(bound);
		int currentCalories = 0;

		while (currentCalories + dietItems.get(randItemIndex).getCalories() <= totalCalories) {
			IDietItems dietItem = dietItems.get(randItemIndex);
			recommendations.add(new Pair(dietItem.getItemName(), dietItem.getCalories()));
			currentCalories += dietItem.getCalories();
			randItemIndex = new Random().nextInt(bound);
		}

		if (currentCalories < totalCalories) {
			IDietItems dietItem = dietItems.get(randItemIndex);
			int remainingCalories = (totalCalories - currentCalories);
			recommendations.add(new Pair(dietItem.getItemName(), remainingCalories));
		}

		return recommendations;
	}
}
