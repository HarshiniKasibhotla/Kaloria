package com.csci5308.kaloria.dietSuggestions.algorithm.partitioner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CaloriesPartitionerTest {
    public static final int CALORIES_LESS_THAN_ZERO = -5;
    public static final int CALORIES_EQUAL_TO_ZERO = 0;
    public static final int CALORIES_GREATER_THAN_ZERO = 100;

    private static ICaloriesPartitioner caloriesPartitioner;

    @BeforeAll
    static void setup() {
        caloriesPartitioner = new CaloriesPartitioner();
    }

    @Test
    @DisplayName("Test for creating calorie partitions when calorie value is less than zero")
    void testCaloriePartitionerForCaloriesLessThanZero() {
        Map<String, Integer> caloriesPartition = caloriesPartitioner.parition(CALORIES_LESS_THAN_ZERO);
        assertNull(caloriesPartition);
    }

    @Test
    @DisplayName("Test for creating calorie partitions when calorie value is zero")
    void testCaloriePartitionerForCaloriesEqualToZero() {
        Map<String, Integer> caloriesPartition = caloriesPartitioner.parition(CALORIES_EQUAL_TO_ZERO);
        assertNull(caloriesPartition);
    }

    @Test
    @DisplayName("Test for creating calorie partitions when calorie value is greater than zero")
    void testCaloriePartitionerForCaloriesGreaterThanZero() {
        Map<String, Integer> caloriesPartition = caloriesPartitioner.parition(CALORIES_GREATER_THAN_ZERO);
        int expectedPartitionSize = 5;
        assertEquals(expectedPartitionSize, caloriesPartition.size());
    }
}
