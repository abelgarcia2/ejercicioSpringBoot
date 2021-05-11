package com.abelgarcia2.ejercicioSpringBoot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mascota")
public class MascotaModel {
    @Id
    @Column(unique = true, nullable = false)
    private int id;

    private String nombre;

    private String raza;

    private int edad;

    private boolean vacunado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    @Override
    public String toString() {
        return "MascotaModel [edad=" + edad + ", id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", vacunado="
                + vacunado + "]";
    }

}