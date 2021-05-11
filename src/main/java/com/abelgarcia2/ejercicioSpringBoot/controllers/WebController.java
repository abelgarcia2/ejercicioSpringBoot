package com.abelgarcia2.ejercicioSpringBoot.controllers;

import com.abelgarcia2.ejercicioSpringBoot.models.MascotaModel;
import com.abelgarcia2.ejercicioSpringBoot.services.MascotaBDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    MascotaBDService mascotaBDService;

    @GetMapping("/contar/{palabra}")
    public String contarConsonantesVocales(@PathVariable String palabra) {
        char[] troceada = palabra.replaceAll(" ", "").toCharArray();
        int vocales = 0, consonantes = 0;

        for (char a : troceada) {
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O'
                    || a == 'U') {
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
            if (a != 'a' && a != 'e' && a != 'i' && a != 'o' && a != 'u' && a != 'A' && a != 'E' && a != 'I' && a != 'O'
                    && a != 'U') {
                salida += a;
            }
        }
        return salida;
    }

    @GetMapping("/guarda")
    public String getDato(@RequestParam int id, @RequestParam String nombre, @RequestParam String raza,
            @RequestParam int edad, @RequestParam boolean vacunado) {
        MascotaModel mascota = new MascotaModel();
        mascota.setId(id);
        mascota.setNombre(nombre);
        mascota.setRaza(raza);
        mascota.setEdad(edad);
        mascota.setVacunado(vacunado);
        mascotaBDService.guardarMascota(mascota);
        return "Mascota guardada";
    }
}
