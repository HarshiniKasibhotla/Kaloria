package com.csci5308.kaloria.admin.dietItems;

import java.sql.SQLException;

public interface IDietItems {

	public void setItemId(int itemId);

	public int getItemId();

	public void setNutrientType(String nutrientType);

	public String getNutrientType();

	public void setItemName(String itemName);

	public String getItemName();

	public void setCalories(int calories);

	public int getCalories();

	public void setCategory(String category);

	public String getCategory();

	public void setHealth(String health);

	public String getHealth();

	public void setAllergy(String allergy);

	public String getAllergy();

	public void setMeal(String meal);

	public String getMeal();

	public void insertNewItem(IDietItems newItem) throws SQLException;

}
