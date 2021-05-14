package com.abelgarcia2.ejercicioSpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {

    @RequestMapping("/contar/{palabra}")
    public String contarConsonantesVocales(@PathVariable String palabra, Model modelo) {
        char[] troceada = palabra.replaceAll(" ", "").toCharArray();
        int vocales = 0, consonantes = 0;

        for (char a : troceada) {
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O'
                    || a == 'U') {
                vocales++;
            } else {
                consonantes++;
            }
            modelo.addAttribute("palabra", palabra);
            modelo.addAttribute("consonantes", consonantes);
            modelo.addAttribute("vocales", vocales);
        }
        return "contar";
    }
}
