package com.csci5308.kaloria.dietSuggestions.healthFactorCalculator;

public class MetricHealthFactorCalculator implements IHealthFactorCalculator {

	private final double weight;
	private final double height;
	private final double targetWeightLossPerWeek;

	public MetricHealthFactorCalculator(double weight, double height, double targetWeightLossPerWeek) {
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
		return (targetWeightLossPerWeek * 2.205 * 500) / 7;
	}

	private double getHeightWeightFactor() {
		return 10 * weight + 6.25 * height;
	}
}
