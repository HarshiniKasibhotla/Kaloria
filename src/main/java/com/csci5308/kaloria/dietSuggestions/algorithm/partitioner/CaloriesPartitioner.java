package com.csci5308.kaloria.dietSuggestions.algorithm.partitioner;

import java.util.HashMap;
import java.util.Map;

public class CaloriesPartitioner implements ICaloriesPartitioner {
    @Override
    public Map<String, Integer> parition(int calories) {
        if (calories <= 0) {
            return null;
        }

        Map<String, Integer> partitions = new HashMap<>();
        int twoFifthPartition = (int) (0.4 * calories);
        int oneFifthPartition = (int) (0.2 * calories);

        partitions.put("Breakfast", twoFifthPartition);
        partitions.put("Lunch", twoFifthPartition);
        partitions.put("Dinner", twoFifthPartition);
        partitions.put("Morning Snack", oneFifthPartition);
        partitions.put("Evening Snack", oneFifthPartition);

        return partitions;
    }
}
