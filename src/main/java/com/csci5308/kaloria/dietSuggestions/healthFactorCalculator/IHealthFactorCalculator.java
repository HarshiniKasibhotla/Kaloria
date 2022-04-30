package com.csci5308.kaloria.dietSuggestions.healthFactorCalculator;

public interface IHealthFactorCalculator {

	double getWeight();

	double getHeight();

	double getTargetWeightLossPerWeek();

	double calculateHeightWeightFactor();

	double calculateCalorieLossByTargetWeight();
}
