package com.abelgarcia2.ejercicioSpringBoot.repositories;

import com.abelgarcia2.ejercicioSpringBoot.models.MascotaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends CrudRepository<MascotaModel, Integer>{
    
}
