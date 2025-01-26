package com.smga.smga;

import com.smga.smga.dinosaurios.DinosaurMonitoringService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class DinosaurMonitoringServiceTest {

    private final DinosaurMonitoringService service = new DinosaurMonitoringService();

    @Test
    public void testGetDinosaurData() {
        Flux<Integer> dinosaurData = service.getDinosaurData();

        // Verificar los primeros 3 valores generados por el flujo
        StepVerifier.create(dinosaurData)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .thenCancel() // Cancela después de verificar 3 valores
                .verify();
    }
}


