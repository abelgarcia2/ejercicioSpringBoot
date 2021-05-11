package com.abelgarcia2.ejercicioSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/contar/{palabra}")
    public String contarConsonantesVocales(@PathVariable String palabra) {
        char[] troceada = palabra.replaceAll(" ", "").toCharArray();
        int vocales = 0, consonantes = 0;

        for (char a : troceada) {
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u'|| a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {
                vocales++;
            } else {
                consonantes++;
            }
        }
        return "La palabra " + palabra + " tiene " + vocales + " vocales y " + consonantes + " consonantes.";
    }

    @GetMapping("/{palabra}")
    public String eliminarVocales(@PathVariable String palabra) {
        char[] troceada = palabra.toCharArray();
        String salida = "";
        for (char a : troceada) {
            if (a != 'a' && a != 'e' && a != 'i' && a != 'o' && a != 'u' && a != 'A' && a != 'E' && a != 'I' && a != 'O' && a != 'U') {
                salida += a;
            }
        }
        return salida;
    }
}
