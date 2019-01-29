package com.example.jgallo.usuarios.entidades;

import java.io.Serializable;

public class Mascota implements Serializable {

    private Integer idDuenio;
    private Integer idMascota;
    private String nombbreMascota;
    private String raza;

    public Mascota(){

    }

    public Mascota(Integer idDuenio, Integer idMascota, String nombbreMascota, String raza) {
        this.idDuenio = idDuenio;
        this.idMascota = idMascota;
        this.nombbreMascota = nombbreMascota;
        this.raza = raza;
    }

    public Integer getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(Integer idDuenio) {
        this.idDuenio = idDuenio;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombbreMascota() {
        return nombbreMascota;
    }

    public void setNombbreMascota(String nombbreMascota) {
        this.nombbreMascota = nombbreMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
