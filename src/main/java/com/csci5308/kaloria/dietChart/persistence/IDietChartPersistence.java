package com.csci5308.kaloria.dietChart.persistence;


import com.csci5308.kaloria.dietChart.IDietChart;
import com.csci5308.kaloria.utilities.Pair;

import java.util.List;
import java.util.Map;

public interface IDietChartPersistence {
    void createDietChart(int userID, Map<String, List<Pair>> dietChart);

    List<IDietChart> getUserDietCharts(int userID);

    void updateDietChart(int dietChartID, Map<String, List<Pair>> dietChart);
}
