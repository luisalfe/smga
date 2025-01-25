package com.smga.smga.dinosaurios;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

@Service
public class DinosaurMonitoringService {

    public Flux<Integer> getDinosaurData() {
        Random random = new Random();
        return Flux.interval(Duration.ofSeconds(1))
                .map(tick -> random.nextInt(100)); // Simula datos de sensores
    }
}
