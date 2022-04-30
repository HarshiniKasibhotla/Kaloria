package com.csci5308.kaloria.dietSuggestions;

import com.csci5308.kaloria.dietSuggestions.calorieCalculator.CalorieIntakeCalculator;
import com.csci5308.kaloria.dietSuggestions.calorieCalculator.ICalorieIntakeCalculator;
import com.csci5308.kaloria.dietSuggestions.healthFactorCalculator.HealthFactorCalculatorFactory;
import com.csci5308.kaloria.dietSuggestions.healthFactorCalculator.HealthFactorCalculatorType;
import com.csci5308.kaloria.dietSuggestions.healthFactorCalculator.IHealthFactorCalculator;
import com.csci5308.kaloria.dietSuggestions.healthParameters.HealthParameters;
import com.csci5308.kaloria.dietSuggestions.healthParameters.IHealthParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalorieIntakeCalculatorTest {

    IHealthParameters healthParameters;

    @BeforeEach
    void setup() {
        healthParameters = new HealthParameters();
        healthParameters.setHealthFactorCalculatorType(HealthFactorCalculatorType.METRIC);
        healthParameters.setGender("male");
        healthParameters.setWeight(60.0);
        healthParameters.setHeight(180.0);
        healthParameters.setTargetWeightLossPerWeek(0.6);
        healthParameters.setActivityLevel(1.37);
        healthParameters.setDateOfBirth("1995-06-05");
    }

    @Test
    @DisplayName("Calorie intake calculation test with metric units")
    void testCalorieIntakeWithMetricUnits() {
        IHealthFactorCalculator healthFactorCalculator = HealthFactorCalculatorFactory.getInstance(healthParameters);
        ICalorieIntakeCalculator calorieIntakeCalculator = new CalorieIntakeCalculator(healthFactorCalculator);
        double actualValue = calorieIntakeCalculator.calculateCalorieIntake(healthParameters);
        assertEquals(2097.5, actualValue);
    }

    @Test
    @DisplayName("Calorie intake calculation test with imperial units")
    void testCalorieIntakeWithImperialUnits() {
        healthParameters.setHealthFactorCalculatorType(HealthFactorCalculatorType.IMPERIAL);
        healthParameters.setWeight(132.2);
        healthParameters.setHeight(70.86);
        healthParameters.setTargetWeightLossPerWeek(1.3);

        IHealthFactorCalculator healthFactorCalculator = HealthFactorCalculatorFactory.getInstance(healthParameters);
        ICalorieIntakeCalculator calorieIntakeCalculator = new CalorieIntakeCalculator(healthFactorCalculator);
        double actualValue = calorieIntakeCalculator.calculateCalorieIntake(healthParameters);
        assertEquals(2098.53, actualValue);
    }

}
