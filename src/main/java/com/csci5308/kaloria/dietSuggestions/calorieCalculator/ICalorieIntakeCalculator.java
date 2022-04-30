package com.csci5308.kaloria.dietSuggestions.calorieCalculator;

import com.csci5308.kaloria.dietSuggestions.healthParameters.IHealthParameters;

public interface ICalorieIntakeCalculator {
    double calculateCalorieIntake(IHealthParameters healthParameters);
}
