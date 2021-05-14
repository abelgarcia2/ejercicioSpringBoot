package com.abelgarcia2.ejercicioSpringBoot.controllers;

import com.abelgarcia2.ejercicioSpringBoot.services.MascotaBDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    MascotaBDService mascotaBDService;

    @GetMapping("/listar")
    public String listarMascotas() {
        return mascotaBDService.obtenerMascotas().toString();
    }
}
