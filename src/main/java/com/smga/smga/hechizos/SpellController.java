package com.smga.smga.hechizos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpellController {

    @Autowired
    private SpellService spellService;

    @GetMapping("/api/spells/cast")
    public String castSpell(@RequestParam String name) {
        return spellService.castSpell(name);
    }
}

