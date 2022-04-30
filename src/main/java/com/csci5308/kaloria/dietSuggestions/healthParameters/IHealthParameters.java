package com.csci5308.kaloria.dietSuggestions.healthParameters;

import com.csci5308.kaloria.dietSuggestions.healthFactorCalculator.HealthFactorCalculatorType;

public interface IHealthParameters {

	HealthFactorCalculatorType getHealthFactorCalculatorType();

	void setHealthFactorCalculatorType(HealthFactorCalculatorType healthFactorCalculatorType);

	String getGender();

	void setGender(String gender);

	String getDateOfBirth();

	void setDateOfBirth(String dateOfBirth);

	double getWeight();

	void setWeight(double weight);

	double getHeight();

	void setHeight(double height);

	double getTargetWeightLossPerWeek();

	void setTargetWeightLossPerWeek(double targetWeightLossPerWeek);

	double getActivityLevel();

	void setActivityLevel(double activityLevel);

	String getHealthAilments();

	void setHealthAilments(String healthAilments);

	String getAllergies();

	void setAllergies(String allergies);

	void setMealPreference(String mealPreference);

	String getMealPreference();
}
