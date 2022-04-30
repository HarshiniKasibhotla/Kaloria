package com.csci5308.kaloria.dietSuggestions.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.csci5308.kaloria.admin.dietItems.DietItems;
import com.csci5308.kaloria.admin.dietItems.IDietItems;
import com.csci5308.kaloria.dietSuggestions.persistence.DietItemPersistence;
import com.csci5308.kaloria.dietSuggestions.persistence.IDietItemPersistence;

public class DietItemServiceTest {
	public static final String HEALTH_AILMENT = "";
	public static final String ALLERGY = "";
	public static final String MEAL_PREFERENCE = "Vegetarian";

	private IDietItemPersistence dietItemPersistence;
	private IDietItemService dietItemService;

	@BeforeEach
	void setup() {
		IDietItems dietItemA = new DietItems(null, "A", 50, 1, "", "", "", "Vegetarian");
		IDietItems dietItemB = new DietItems(null, "B", 30, 2, "", "", "", "Vegetarian");
		List<IDietItems> dietItems = new ArrayList<>();
		dietItems.add(dietItemA);
		dietItems.add(dietItemB);
		dietItemPersistence = mock(DietItemPersistence.class);
		when(dietItemPersistence.retrieveDietItems(HEALTH_AILMENT, ALLERGY, MEAL_PREFERENCE)).thenReturn(dietItems);
		dietItemService = new DietItemService(dietItemPersistence);
	}

	@Test
	@DisplayName("Test for retrieving the diet items based on health factors")
	void testGetAllDietCharts() {
		List<IDietItems> dietItems = dietItemService.retrieveDietItems(HEALTH_AILMENT, ALLERGY, MEAL_PREFERENCE);
		int expectedDietItemsSize = 2;
		assertEquals(expectedDietItemsSize, dietItems.size());
	}
}
