package com.csci5308.kaloria.dietSuggestions.algorithm;

import com.csci5308.kaloria.utilities.Pair;

import java.util.List;
import java.util.Map;

public interface IDietSuggestor {
    Map<String, List<Pair>> getDietSuggestions(int calorieIntake, String healthAilment, String allergy,
                                               String foodCategory);
}
