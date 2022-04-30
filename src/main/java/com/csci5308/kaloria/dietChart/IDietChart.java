package com.csci5308.kaloria.dietChart;

import com.csci5308.kaloria.utilities.Pair;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface IDietChart {
    int getId();

    int getUserId();

    Map<String, List<Pair>> getDietChart();

    Timestamp getCreatedTime();

    Timestamp getLastUpdatedTime();
}
