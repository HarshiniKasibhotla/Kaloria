package com.csci5308.kaloria.dietSuggestions.services;

import java.util.List;

import com.csci5308.kaloria.admin.dietItems.IDietItems;
import com.csci5308.kaloria.dietSuggestions.persistence.IDietItemPersistence;

public class DietItemService implements IDietItemService {
	private final IDietItemPersistence dietItemPersistence;

	public DietItemService(IDietItemPersistence dietItemPersistence) {
		this.dietItemPersistence = dietItemPersistence;
	}

	@Override
	public List<IDietItems> retrieveDietItems(String healthAilment, String allergy, String mealPreference) {
		return dietItemPersistence.retrieveDietItems(healthAilment, allergy, mealPreference);
	}
}
