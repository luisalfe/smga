package com.smga.smga.marte;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarsSensorDataWriter implements ItemWriter<ProcessedSensorData> {


    @Override
    public void write(Chunk<? extends ProcessedSensorData> chunk) throws Exception {
        chunk.getItems().forEach(data -> System.out.println("Processed Data: " + data));
    }
}


