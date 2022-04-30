package com.csci5308.kaloria.dietChart.services;

import com.csci5308.kaloria.dietChart.IDietChart;
import com.csci5308.kaloria.dietChart.persistence.IDietChartPersistence;
import com.csci5308.kaloria.utilities.Pair;

import java.util.List;
import java.util.Map;

public class DietChartService implements IDietChartService {

    private final IDietChartPersistence dietChartPersistence;

    public DietChartService(IDietChartPersistence dietChartPersistence) {
        this.dietChartPersistence = dietChartPersistence;
    }

    @Override
    public List<IDietChart> getDietCharts(int userID) {
        return dietChartPersistence.getUserDietCharts(userID);
    }

    @Override
    public IDietChart getLatestDietChart(int userID) {
        List<IDietChart> dietCharts = dietChartPersistence.getUserDietCharts(userID);
        IDietChart mostRecentDietChart = null;
        if (dietCharts != null) {
            mostRecentDietChart = dietCharts.get(0);
            for (int i = 1; i < dietCharts.size(); i++) {
                IDietChart dietChart = dietCharts.get(i);
                if (mostRecentDietChart.getLastUpdatedTime().compareTo(dietChart.getLastUpdatedTime()) < 0) {
                    mostRecentDietChart = dietChart;
                }
            }
        }
        return mostRecentDietChart;
    }

    @Override
    public void createDietChart(int userID, Map<String, List<Pair>> dietChart) {
        dietChartPersistence.createDietChart(userID, dietChart);
    }
}
