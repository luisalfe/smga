package com.smga.smga.marte;

public class ProcessedSensorData {
    private String id;
    private double averageMetric;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAverageMetric() {
        return averageMetric;
    }

    public void setAverageMetric(double averageMetric) {
        this.averageMetric = averageMetric;
    }

    @Override
    public String toString() {
        return "ProcessedSensorData{" +
                "id='" + id + '\'' +
                ", averageMetric=" + averageMetric +
                '}';
    }
}

