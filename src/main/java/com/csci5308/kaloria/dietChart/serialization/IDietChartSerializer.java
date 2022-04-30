package com.csci5308.kaloria.dietChart.serialization;

import com.csci5308.kaloria.utilities.Pair;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.util.List;
import java.util.Map;

public interface IDietChartSerializer {
    ByteArrayOutputStream serialize(Map<String, List<Pair>> dietChart);

    Map<String, List<Pair>> deserialize(Blob dietChartBlob);
}
