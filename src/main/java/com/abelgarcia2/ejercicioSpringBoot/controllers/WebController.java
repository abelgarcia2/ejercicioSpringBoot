package com.abelgarcia2.ejercicioSpringBoot.controllers;

import com.abelgarcia2.ejercicioSpringBoot.services.MascotaBDService;
import com.abelgarcia2.ejercicioSpringBoot.services.TranslatedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    MascotaBDService mascotaBDService;

    @Autowired
    TranslatedService translatedService;

    @GetMapping("/listar")
    public String listarMascotas() {
        return mascotaBDService.obtenerMascotas().toString();
    }

    @GetMapping("/traduce/{palabra}")
    public String traduce(@PathVariable String palabra) {
        String traduccion = translatedService.traduce(palabra);
        return traduccion;
    }
}
