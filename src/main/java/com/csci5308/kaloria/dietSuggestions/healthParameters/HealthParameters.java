package com.csci5308.kaloria.dietSuggestions.healthParameters;

import com.csci5308.kaloria.dietSuggestions.healthFactorCalculator.HealthFactorCalculatorType;

public class HealthParameters implements IHealthParameters {

	private HealthFactorCalculatorType healthFactorCalculatorType;
	private String gender;
	private String dateOfBirth;
	private double weight;
	private double height;
	private double targetWeightLossPerWeek;
	private double activityLevel;
	private String healthAilments;
	private String allergies;
	private String mealPreference;

	@Override
	public HealthFactorCalculatorType getHealthFactorCalculatorType() {
		return healthFactorCalculatorType;
	}

	@Override
	public void setHealthFactorCalculatorType(HealthFactorCalculatorType healthFactorCalculatorType) {
		this.healthFactorCalculatorType = healthFactorCalculatorType;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getTargetWeightLossPerWeek() {
		return targetWeightLossPerWeek;
	}

	@Override
	public void setTargetWeightLossPerWeek(double targetWeightLossPerWeek) {
		this.targetWeightLossPerWeek = targetWeightLossPerWeek;
	}

	@Override
	public double getActivityLevel() {
		return activityLevel;
	}

	@Override
	public void setActivityLevel(double activityLevel) {
		this.activityLevel = activityLevel;
	}

	@Override
	public String getHealthAilments() {
		return healthAilments;
	}

	@Override
	public void setHealthAilments(String healthAilments) {
		this.healthAilments = healthAilments;
	}

	@Override
	public String getAllergies() {
		return allergies;
	}

	@Override
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	@Override
	public String getMealPreference() {
		return mealPreference;
	}

	@Override
	public void setMealPreference(String mealPreference) {
		this.mealPreference = mealPreference;
	}
}
