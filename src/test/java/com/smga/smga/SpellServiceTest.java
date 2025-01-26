package com.smga.smga;

import com.smga.smga.hechizos.SpellService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpellServiceTest {

    private final SpellService spellService = new SpellService();

    @Test
    public void testCastSpell() {
        String result = spellService.castSpell("Lumos");
        assertThat(result).isEqualTo("Ilumina la varita mágica.");
    }

    @Test
    public void testFallbackCastSpell() {
        String result = spellService.fallbackCastSpell("Avada Kedavra", new RuntimeException("Error"));
        assertThat(result).isEqualTo("El hechizo 'Avada Kedavra' no está disponible en este momento. Por favor, inténtalo más tarde.");
    }
}

