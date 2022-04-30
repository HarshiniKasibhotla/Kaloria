package com.csci5308.kaloria.dietChart;

import com.csci5308.kaloria.utilities.Pair;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class DietChart implements IDietChart {
    private final int id;
    private final int userId;
    private final Map<String, List<Pair>> dietChart;
    private final Timestamp createdTime;
    private final Timestamp lastUpdatedTime;

    public DietChart(int id, int userId, Map<String, List<Pair>> dietChart, Timestamp createdTime, Timestamp lastUpdatedTime) {
        this.id = id;
        this.userId = userId;
        this.dietChart = dietChart;
        this.createdTime = createdTime;
        this.lastUpdatedTime = lastUpdatedTime;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public Map<String, List<Pair>> getDietChart() {
        return dietChart;
    }

    @Override
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    @Override
    public Timestamp getLastUpdatedTime() {
        return lastUpdatedTime;
    }
}
