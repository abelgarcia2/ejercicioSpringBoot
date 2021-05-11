package com.abelgarcia2.ejercicioSpringBoot.services;

import java.util.ArrayList;

import com.abelgarcia2.ejercicioSpringBoot.models.MascotaModel;
import com.abelgarcia2.ejercicioSpringBoot.repositories.MascotaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaBDService {

    @Autowired
    MascotaRepository mascotaRepository;

    public MascotaModel guardarMascota(MascotaModel mascota) {
        return mascotaRepository.save(mascota);
    }

    public ArrayList<MascotaModel> obtenerMascotas() {
        return (ArrayList<MascotaModel>) mascotaRepository.findAll();
    }
}
