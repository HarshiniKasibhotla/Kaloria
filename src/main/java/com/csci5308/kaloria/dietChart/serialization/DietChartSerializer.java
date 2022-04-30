package com.csci5308.kaloria.dietChart.serialization;

import com.csci5308.kaloria.utilities.Pair;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DietChartSerializer implements IDietChartSerializer {
    @Override
    public ByteArrayOutputStream serialize(Map<String, List<Pair>> dietChart) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(dietChart);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }

    @Override
    public Map<String, List<Pair>> deserialize(Blob dietChartBlob) {
        Map<String, List<Pair>> dietChart = null;
        try {
            int startingPosition = 1;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dietChartBlob.getBytes(startingPosition, (int) dietChartBlob.length()));
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            dietChart = (Map<String, List<Pair>>) objectInputStream.readObject();
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dietChart;
    }
}
