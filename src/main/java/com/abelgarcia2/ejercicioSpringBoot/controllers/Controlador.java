package com.abelgarcia2.ejercicioSpringBoot.controllers;

import com.abelgarcia2.ejercicioSpringBoot.models.MascotaModel;
import com.abelgarcia2.ejercicioSpringBoot.services.MascotaBDService;
import com.abelgarcia2.ejercicioSpringBoot.services.TranslatedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    @Autowired
    MascotaBDService mascotaBDService;


    @Autowired
    TranslatedService translatedService;

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

    @RequestMapping("/guarda")
    public String getDato(@RequestParam int id, @RequestParam String nombre, @RequestParam String raza,
            @RequestParam int edad, @RequestParam boolean vacunado, Model modelo) {
        MascotaModel mascota = new MascotaModel();
        mascota.setId(id);
        mascota.setNombre(nombre);
        mascota.setRaza(raza);
        mascota.setEdad(edad);
        mascota.setVacunado(vacunado);
        mascotaBDService.guardarMascota(mascota);
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("id", id);
        return "guarda";
    }

    @RequestMapping("/formulario")
    public String formulario(){
        return "formulario";
    }
    @RequestMapping("/{palabra}")
    public String eliminarVocales(@PathVariable String palabra, Model modelo) {
        char[] troceada = palabra.toCharArray();
        String salida = "";
        for (char a : troceada) {
            if (a != 'a' && a != 'e' && a != 'i' && a != 'o' && a != 'u' && a != 'A' && a != 'E' && a != 'I' && a != 'O'
                    && a != 'U') {
                salida += a;
            }
        }
        modelo.addAttribute("palabra", palabra);
        modelo.addAttribute("resultado", salida);
        return "eliminarVocales";
    }

    @RequestMapping("/traduce/{palabra}")
    public String traduce(@PathVariable String palabra, Model modelo) {
        String traduccion = translatedService.traduce(palabra);
        modelo.addAttribute("palabra", palabra);
        modelo.addAttribute("traduccion", traduccion);
        return "traduce";
    }

    @RequestMapping("/listar")
    public String listarMascotas(Model modelo) {
        String salida = mascotaBDService.obtenerMascotas().toString();
        modelo.addAttribute("salida", salida);
        return "lista";
    }
}
