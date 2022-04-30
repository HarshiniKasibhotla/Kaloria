package com.csci5308.kaloria.dietChart.persistence;

import com.csci5308.kaloria.database.CallStoredProcedures;
import com.csci5308.kaloria.dietChart.DietChart;
import com.csci5308.kaloria.dietChart.IDietChart;
import com.csci5308.kaloria.dietChart.serialization.IDietChartSerializer;
import com.csci5308.kaloria.utilities.Pair;
import com.csci5308.kaloria.utilities.StoredProcedureConstants;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DietChartPersistence implements IDietChartPersistence {
    private static final String DIET_CHART_ID_COLUMN = "id";
    private static final String DIET_CHART_USER_ID_COLUMN = "userId";
    private static final String DIET_CHART_COLUMN = "chart";
    private static final String DIET_CHART_CREATED_AT_COLUMN = "created_at";
    private static final String DIET_CHART_LAST_UPDATED_AT_COLUMN = "updated_at";

    private final IDietChartSerializer dietChartSerializer;

    public DietChartPersistence(IDietChartSerializer dietChartSerializer) {
        this.dietChartSerializer = dietChartSerializer;
    }

    @Override
    public void createDietChart(int userID, Map<String, List<Pair>> dietChart) {
        CallStoredProcedures createDietChartProcedure = null;
        try {
            ByteArrayOutputStream dietChartBlob = dietChartSerializer.serialize(dietChart);
            if (dietChartBlob == null) {
                System.out.println("Could not serialize diet chart");
                return;
            }
            createDietChartProcedure = new CallStoredProcedures(StoredProcedureConstants.CREATE_DIET_CHART);
            createDietChartProcedure.setInt(1, userID);
            createDietChartProcedure.setBlob(2, dietChartBlob);
            createDietChartProcedure.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (createDietChartProcedure != null) {
                createDietChartProcedure.cleanup();
            }
        }
    }

    @Override
    public List<IDietChart> getUserDietCharts(int userID) {
        List<IDietChart> dietCharts = new ArrayList<>();
        CallStoredProcedures getDietChartsProcedure = null;
        try {
            getDietChartsProcedure = new CallStoredProcedures(StoredProcedureConstants.GET_USER_DIET_CHARTS);
            getDietChartsProcedure.setInt(1, userID);
            ResultSet dietChartsResultSet = getDietChartsProcedure.executeWithResults();

            if (dietChartsResultSet != null) {
                while (dietChartsResultSet.next()) {
                    int dietChartID = dietChartsResultSet.getInt(DIET_CHART_ID_COLUMN);
                    int dietChartUserID = dietChartsResultSet.getInt(DIET_CHART_USER_ID_COLUMN);
                    Blob dietChartBlob = dietChartsResultSet.getBlob(DIET_CHART_COLUMN);
                    Timestamp dietChartCreatedAt = dietChartsResultSet.getTimestamp(DIET_CHART_CREATED_AT_COLUMN);
                    Timestamp dietChartLastUpdatedAt = dietChartsResultSet.getTimestamp(DIET_CHART_LAST_UPDATED_AT_COLUMN);

                    Map<String, List<Pair>> deserializedDietChart = dietChartSerializer.deserialize(dietChartBlob);
                    if (deserializedDietChart != null) {
                        IDietChart dietChart = new DietChart(dietChartID, dietChartUserID, deserializedDietChart, dietChartCreatedAt, dietChartLastUpdatedAt);
                        dietCharts.add(dietChart);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (getDietChartsProcedure != null) {
                getDietChartsProcedure.cleanup();
            }
        }
        return dietCharts;
    }

    @Override
    public void updateDietChart(int dietChartID, Map<String, List<Pair>> dietChart) {
        CallStoredProcedures updateDietChartProcedure = null;
        try {
            ByteArrayOutputStream dietChartBlob = dietChartSerializer.serialize(dietChart);
            if (dietChartBlob == null) {
                System.out.println("Could not serialize diet chart");
                return;
            }
            updateDietChartProcedure = new CallStoredProcedures(StoredProcedureConstants.UPDATE_DIET_CHART);
            updateDietChartProcedure.setInt(1, dietChartID);
            updateDietChartProcedure.setBlob(2, dietChartBlob);
            updateDietChartProcedure.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (updateDietChartProcedure != null) {
                updateDietChartProcedure.cleanup();
            }
        }
    }
}
