package com.csci5308.kaloria.dietSuggestions.persistence;

import java.util.List;

import com.csci5308.kaloria.admin.dietItems.IDietItems;

public interface IDietItemPersistence {
    List<IDietItems> retrieveDietItems(String healthAilment, String allergy, String mealPreference);
}
