package com.csci5308.kaloria.dietSuggestions.services;

import java.util.List;

import com.csci5308.kaloria.admin.dietItems.IDietItems;

public interface IDietItemService {
    List<IDietItems> retrieveDietItems(String healthAilment, String allergy, String mealPreference);
}
