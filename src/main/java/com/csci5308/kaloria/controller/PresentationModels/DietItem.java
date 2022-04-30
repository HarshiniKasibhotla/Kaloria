package com.csci5308.kaloria.controller.PresentationModels;

public class DietItem extends FormOperations {

	public Integer Id;
	public String Name;
	public String NutrientType;
	public int Calories;
	public String category;
	public String health;
	public String allergy;
	public String meal;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getNutrientType() {
		return NutrientType;
	}

	public void setNutrientType(String nutrientType) {
		NutrientType = nutrientType;
	}

	public int getCalories() {
		return Calories;
	}

	public void setCalories(int calories) {
		Calories = calories;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getAllergy() {
		return allergy;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

}
