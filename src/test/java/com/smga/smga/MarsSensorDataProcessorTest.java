package com.smga.smga;

import com.smga.smga.marte.MarsSensorDataProcessor;
import com.smga.smga.marte.ProcessedSensorData;
import com.smga.smga.marte.SensorData;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsSensorDataProcessorTest {

    private final MarsSensorDataProcessor processor = new MarsSensorDataProcessor();

    @Test
    public void testProcessData() {
        // Crear objeto SensorData utilizando setters
        SensorData sensorData = new SensorData();
        sensorData.setId("Sensor-1");
        sensorData.setTemperature(500.0);
        sensorData.setPressure(1000.0);

        // Procesar el objeto
        ProcessedSensorData processedData = processor.process(sensorData);

        // Verificar los resultados
        assertThat(processedData.getId()).isEqualTo("Sensor-1");
        assertThat(processedData.getAverageMetric()).isEqualTo((500.0 + 1000.0) / 2);
    }
}


