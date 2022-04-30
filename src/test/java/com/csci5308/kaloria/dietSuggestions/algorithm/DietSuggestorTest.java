package com.csci5308.kaloria.dietSuggestions.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.csci5308.kaloria.admin.dietItems.DietItems;
import com.csci5308.kaloria.admin.dietItems.IDietItems;
import com.csci5308.kaloria.dietSuggestions.algorithm.partitioner.CaloriesPartitioner;
import com.csci5308.kaloria.dietSuggestions.algorithm.partitioner.ICaloriesPartitioner;
import com.csci5308.kaloria.dietSuggestions.services.DietItemService;
import com.csci5308.kaloria.dietSuggestions.services.IDietItemService;
import com.csci5308.kaloria.utilities.Pair;

public class DietSuggestorTest {
	private static final String HEALTH_AILMENT = "NA";
	private static final String ALLERGY = "NA";
	private static final String MEAL_PREFERENCE = "Vegetarian";
	public static final int CALORIE_INTAKE = 70;

	private IDietItemService dietItemService;

	@BeforeEach
	void setup() {
		IDietItems dietItemA = new DietItems(null, "A", 50, 1, "NA", "NA", "", "Vegetarian");
		IDietItems dietItemB = new DietItems(null, "B", 30, 2, "NA", "NA", "", "Vegetarian");
		List<IDietItems> dietItems = new ArrayList<>();
		dietItems.add(dietItemA);
		dietItems.add(dietItemB);
		dietItemService = mock(DietItemService.class);
		when(dietItemService.retrieveDietItems(HEALTH_AILMENT, ALLERGY, MEAL_PREFERENCE)).thenReturn(dietItems);
	}

	@Test
	@DisplayName("Test for retrieving diet suggestions when items exist")
	void testGetDietSuggestionsWhenItemsExist() {
		ICaloriesPartitioner caloriesPartitioner = new CaloriesPartitioner();
		IDietSuggestor dietSuggestor = new DietSuggestor(dietItemService, caloriesPartitioner);
		Map<String, List<Pair>> dietSuggestions = dietSuggestor.getDietSuggestions(CALORIE_INTAKE, HEALTH_AILMENT,
				ALLERGY, MEAL_PREFERENCE);
		int expectedDietSuggestionsSize = 5;
		assertEquals(expectedDietSuggestionsSize, dietSuggestions.size());
	}

	@Test
	@DisplayName("Test for retrieving diet suggestions when items dont exist")
	void testGetDietSuggestionsWhenItemsDontExist() {
		ICaloriesPartitioner caloriesPartitioner = new CaloriesPartitioner();
		when(dietItemService.retrieveDietItems(HEALTH_AILMENT, ALLERGY, MEAL_PREFERENCE)).thenReturn(null);
		IDietSuggestor dietSuggestor = new DietSuggestor(dietItemService, caloriesPartitioner);
		Map<String, List<Pair>> dietSuggestions = dietSuggestor.getDietSuggestions(CALORIE_INTAKE, HEALTH_AILMENT,
				ALLERGY, MEAL_PREFERENCE);
		assertNull(dietSuggestions);
	}
}
