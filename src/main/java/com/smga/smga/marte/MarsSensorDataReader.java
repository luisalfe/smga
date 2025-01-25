package com.smga.smga.marte;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarsSensorDataReader implements ItemReader<SensorData> {

    private final List<SensorData> sensorDataList;
    private int nextIndex;

    public MarsSensorDataReader() {
        this.sensorDataList = new ArrayList<>();
        this.nextIndex = 0;

        // Simula datos de sensores
        for (int i = 0; i < 50; i++) {
            SensorData data = new SensorData();
            data.setId("Sensor-" + i);
            data.setTemperature(20 + Math.random() * 10);
            data.setPressure(1000 + Math.random() * 100);
            this.sensorDataList.add(data);
        }
    }

    @Override
    public SensorData read() {
        if (nextIndex < sensorDataList.size()) {
            return sensorDataList.get(nextIndex++);
        }
        return null; // Indica el final del lote
    }
}
