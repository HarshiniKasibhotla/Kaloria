package com.csci5308.kaloria.admin.dietItems;

import java.sql.SQLException;

import com.csci5308.kaloria.admin.AdminPersistence;
import com.csci5308.kaloria.admin.IAdminPersistence;

public class DietItems implements IDietItems {

	private String nutrientType;
	private String itemName;
	private int calories;
	private int itemId;
	private String category;
	private String health;
	private String allergy;
	private String meal;

	public DietItems(String nutrientType, String itemName, int calories, int itemId, String category, String health,
			String allergy, String meal) {
		this.nutrientType = nutrientType;
		this.itemName = itemName;
		this.calories = calories;
		this.itemId = itemId;
		this.category = category;
		this.health = health;
		this.allergy = allergy;
		this.meal = meal;
	}

	IAdminPersistence adminpersistence;

	public DietItems() {
		super();
		this.adminpersistence = new AdminPersistence();
	}

	@Override
	public String toString() {
		return "DietItems [nutrientType=" + nutrientType + ", itemName=" + itemName + ", calories=" + calories
				+ ", itemId=" + itemId + ", category=" + category + ", health=" + health + ", meal=" + meal
				+ ", adminpersistence=" + adminpersistence + "]";
	}

	@Override
	public void setItemId(int itemId) {
		this.itemId = itemId;

	}

	@Override
	public int getItemId() {
		// TODO Auto-generated method stub
		return itemId;
	}

	@Override
	public void setNutrientType(String nutrientType) {
		this.nutrientType = nutrientType;

	}

	public String getNutrientType() {

		return nutrientType;
	}

	@Override
	public void setItemName(String itemName) {
		this.itemName = itemName;

	}

	@Override
	public String getItemName() {

		return itemName;
	}

	@Override
	public void setCalories(int calories) {
		this.calories = calories;

	}

	@Override
	public int getCalories() {

		return calories;
	}

	protected static boolean notNullAndNotEmptyCheck(String s) {

		if (s == null || s.isEmpty()) {
			return false;
		}

		return true;
	}

	public static boolean isNutrientTypeValid(String nutrientType) {

		if (notNullAndNotEmptyCheck(nutrientType)) {
			return true;
		}
		return false;

	}

	public static boolean isItemNameValid(String itemName) {

		if (notNullAndNotEmptyCheck(itemName)) {
			return true;
		}
		return false;

	}

	public static boolean isCaloriesValid(int calories) {
		if (calories != 0) {
			return true;
		}
		return false;
	}

	@Override
	public void insertNewItem(IDietItems newItem) throws SQLException {
		adminpersistence.insertNewItem(newItem);

	}

	@Override
	public void setCategory(String category) {
		this.category = category;

	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public void setHealth(String health) {
		this.health = health;

	}

	@Override
	public String getHealth() {
		return health;
	}

	@Override
	public void setMeal(String meal) {
		this.meal = meal;

	}

	@Override
	public String getMeal() {
		return meal;
	}

	@Override
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	@Override
	public String getAllergy() {
		return allergy;
	}

}
