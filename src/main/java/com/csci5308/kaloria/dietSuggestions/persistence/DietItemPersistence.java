package com.csci5308.kaloria.dietSuggestions.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csci5308.kaloria.admin.dietItems.DietItems;
import com.csci5308.kaloria.admin.dietItems.IDietItems;
import com.csci5308.kaloria.database.CallStoredProcedures;
import com.csci5308.kaloria.utilities.StoredProcedureConstants;

public class DietItemPersistence implements IDietItemPersistence {
    @Override
    public List<IDietItems> retrieveDietItems(String healthAilment, String allergy, String mealPreference) {
        List<IDietItems> dietItems = new ArrayList<>();

        try {
            CallStoredProcedures retrieveDietItemsStoredProcedure = new CallStoredProcedures(StoredProcedureConstants.RETRIEVE_DIET_ITEMS_BY_FILTER);
            retrieveDietItemsStoredProcedure.setParameter(1, healthAilment);
            retrieveDietItemsStoredProcedure.setParameter(2, allergy);
            retrieveDietItemsStoredProcedure.setParameter(3, mealPreference);

            ResultSet dietItemsResultSet = retrieveDietItemsStoredProcedure.executeWithResults();

            if (dietItemsResultSet != null) {
                while (dietItemsResultSet.next()) {
                    String itemType = dietItemsResultSet.getString("Type");
                    String itemName = dietItemsResultSet.getString("ItemName");
                    String calories = dietItemsResultSet.getString("Calories");
                    int itemID = dietItemsResultSet.getInt("ItemId");
                    String category = dietItemsResultSet.getString("Category");
                    String healthCondition = dietItemsResultSet.getString("HealthCondition");
                    String mealType = dietItemsResultSet.getString("MealType");
                    String allergies = dietItemsResultSet.getString("Allergies");

                    IDietItems dietItem = new DietItems(itemType, itemName, Integer.parseInt(calories), itemID, category, healthCondition, allergies, mealType);
                    dietItems.add(dietItem);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (dietItems.isEmpty()) {
            return null;
        }

        return dietItems;
    }
}
