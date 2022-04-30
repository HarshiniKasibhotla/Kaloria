package com.csci5308.kaloria.dietChart.services;

import com.csci5308.kaloria.dietChart.DietChart;
import com.csci5308.kaloria.dietChart.IDietChart;
import com.csci5308.kaloria.dietChart.persistence.DietChartPersistence;
import com.csci5308.kaloria.dietChart.persistence.IDietChartPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DietChartServiceTest {

    private IDietChartPersistence dietChartPersistence;
    private IDietChartService dietChartService;

    @BeforeEach
    void setup() {
        IDietChart dietChartA = new DietChart(2, 3, null, null, new Timestamp(15));
        IDietChart dietChartB = new DietChart(3, 3, null, null, new Timestamp(5));
        List<IDietChart> dietCharts = new ArrayList<>();
        dietCharts.add(dietChartA);
        dietCharts.add(dietChartB);
        dietChartPersistence = mock(DietChartPersistence.class);
        when(dietChartPersistence.getUserDietCharts(3)).thenReturn(dietCharts);
        dietChartService = new DietChartService(dietChartPersistence);
    }

    @Test
    @DisplayName("Test for retrieving all the diet charts for a user")
    void testGetAllDietCharts() {
        List<IDietChart> dietCharts = dietChartService.getDietCharts(3);
        assertEquals(2, dietCharts.size());
    }

    @Test
    @DisplayName("Test for retrieving the latest diet chart for a user")
    void testGetLatestDietChart() {
        IDietChart dietChart = dietChartService.getLatestDietChart(3);
        assertNotNull(dietChart);
    }

}
