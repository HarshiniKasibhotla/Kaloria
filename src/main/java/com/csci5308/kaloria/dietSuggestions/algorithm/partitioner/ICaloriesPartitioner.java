package com.csci5308.kaloria.dietSuggestions.algorithm.partitioner;

import java.util.Map;

public interface ICaloriesPartitioner {
    Map<String, Integer> parition(int calories);
}
