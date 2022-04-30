package com.csci5308.kaloria.dietSuggestions.healthFactorCalculator;

import com.csci5308.kaloria.dietSuggestions.healthParameters.IHealthParameters;

public class HealthFactorCalculatorFactory {

	public static IHealthFactorCalculator getInstance(IHealthParameters healthParameters) {

		HealthFactorCalculatorType healthFactorCalculatorType = healthParameters.getHealthFactorCalculatorType();

		if (healthFactorCalculatorType == HealthFactorCalculatorType.METRIC) {
			return new MetricHealthFactorCalculator(healthParameters.getWeight(), healthParameters.getHeight(),
					healthParameters.getTargetWeightLossPerWeek());
		}
		if (healthFactorCalculatorType == HealthFactorCalculatorType.IMPERIAL) {
			return new ImperialHealthFactorCalculator(healthParameters.getWeight(), healthParameters.getHeight(),
					healthParameters.getTargetWeightLossPerWeek());
		}
		return null;
	}
}
