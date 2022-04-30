package com.csci5308.kaloria.dietChart.services;

import com.csci5308.kaloria.dietChart.IDietChart;
import com.csci5308.kaloria.utilities.Pair;

import java.util.List;
import java.util.Map;

public interface IDietChartService {
    List<IDietChart> getDietCharts(int userID);

    IDietChart getLatestDietChart(int userID);

    void createDietChart(int userID, Map<String, List<Pair>> dietChart);
}
