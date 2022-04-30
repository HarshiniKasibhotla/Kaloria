package com.csci5308.kaloria.dietSuggestions.healthFactorCalculator;

public class ImperialHealthFactorCalculator implements IHealthFactorCalculator {

	private final double weight;
	private final double height;
	private final double targetWeightLossPerWeek;

	public ImperialHealthFactorCalculator(double weight, double height, double targetWeightLossPerWeek) {
		this.weight = weight;
		this.height = height;
		this.targetWeightLossPerWeek = targetWeightLossPerWeek;
	}

	@Override
	public double getTargetWeightLossPerWeek() {
		return targetWeightLossPerWeek;
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public double getHeight() {
		return this.height;
	}

	@Override
	public double calculateHeightWeightFactor() {
		return getHeightWeightFactor();
	}

	@Override
	public double calculateCalorieLossByTargetWeight() {
		return (targetWeightLossPerWeek * 500) / 7;
	}

	private double getHeightWeightFactor() {
		return 10 * weight * 0.453592 + 6.25 * height * 2.54;
	}
}
