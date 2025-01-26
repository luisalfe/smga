package com.smga.smga.hechizos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpellService {

    private final List<Spell> spells;

    public SpellService() {
        this.spells = new ArrayList<>();
        spells.add(new Spell("Lumos", "Ilumina la varita mágica."));
        spells.add(new Spell("Alohomora", "Abre puertas cerradas."));
        spells.add(new Spell("Expecto Patronum", "Invoca un Patronus para repeler Dementores."));
    }

    @CircuitBreaker(name = "spellService", fallbackMethod = "fallbackCastSpell")
    public String castSpell(String spellName) {
        return spells.stream()
                .filter(spell -> spell.getName().equalsIgnoreCase(spellName))
                .map(Spell::getDescription)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Hechizo no encontrado: " + spellName));
    }

    public String fallbackCastSpell(String spellName, Throwable t) {
        return "El hechizo '" + spellName + "' no está disponible en este momento. Por favor, inténtalo más tarde.";
    }
}

