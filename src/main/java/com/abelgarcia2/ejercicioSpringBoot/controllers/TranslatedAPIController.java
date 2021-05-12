package com.abelgarcia2.ejercicioSpringBoot.controllers;

import com.abelgarcia2.ejercicioSpringBoot.services.TranslatedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TranslatedAPIController {
    @Autowired
    TranslatedService translatedService;

    @GetMapping("/traduce/{palabra}")
    public String traduce(@PathVariable String palabra) {
        String traduccion = translatedService.traduce(palabra);
        return traduccion;
    }
}
