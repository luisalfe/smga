package com.smga.smga.marte;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MarsSensorDataProcessor implements ItemProcessor<SensorData, ProcessedSensorData> {

    @Override
    public ProcessedSensorData process(SensorData sensorData) {
        ProcessedSensorData processed = new ProcessedSensorData();
        processed.setId(sensorData.getId());
        processed.setAverageMetric((sensorData.getTemperature() + sensorData.getPressure()) / 2);
        return processed;
    }
}

