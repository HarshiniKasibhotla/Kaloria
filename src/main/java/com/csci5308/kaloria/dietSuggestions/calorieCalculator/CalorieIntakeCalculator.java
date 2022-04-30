package com.csci5308.kaloria.dietSuggestions.calorieCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

import com.csci5308.kaloria.access.calculators.AgeCalculator;
import com.csci5308.kaloria.access.calculators.IAgeCalculator;
import com.csci5308.kaloria.dietSuggestions.healthFactorCalculator.IHealthFactorCalculator;
import com.csci5308.kaloria.dietSuggestions.healthParameters.IHealthParameters;

public class CalorieIntakeCalculator implements ICalorieIntakeCalculator {

    private final IHealthFactorCalculator healthFactorCalculator;

    public CalorieIntakeCalculator(IHealthFactorCalculator healthFactorCalculator) {
        this.healthFactorCalculator = healthFactorCalculator;
    }

    @Override
    public double calculateCalorieIntake(IHealthParameters healthParameters) {
        IAgeCalculator ageCalculator = new AgeCalculator();

        int age = 0;
        try {
            age = ageCalculator.calculateAge(healthParameters.getDateOfBirth());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        double activityLevel = healthParameters.getActivityLevel();
        double calorieCount = healthFactorCalculator.calculateHeightWeightFactor() - 5.0 * age;

        if (healthParameters.getGender().equalsIgnoreCase("male")) {
            calorieCount += 5;
        } else {
            calorieCount -= 161;
        }

        calorieCount = calorieCount * activityLevel - healthFactorCalculator.calculateCalorieLossByTargetWeight();
        calorieCount = BigDecimal.valueOf(calorieCount).setScale(2, RoundingMode.HALF_UP).doubleValue();

        return calorieCount;
    }
}
