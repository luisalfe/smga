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

/* No tira bien el test

public class DinosaurMonitoringService {

    public Flux<Integer> getDinosaurData() {
        // Simula datos de sensores de dinosaurios emitiendo números cada segundo
        return Flux.range(1, 100) // Genera números del 1 al 100
                .delayElements(Duration.ofSeconds(1)) // Simula un retraso de 1 segundo entre emisiones
                .log(); // Registra el flujo para depuración
    }
}
*/
