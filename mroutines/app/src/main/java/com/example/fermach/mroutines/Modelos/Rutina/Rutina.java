package com.example.fermach.mroutines.Modelos.Rutina;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/**
 *
 * Modelo de Rutina
 *
 * @author Fermach
 * @version 1.0.
 *
 */

public class Rutina implements Serializable{

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("tipo")
    @Expose
    private String tipo;

    @SerializedName("nivel")
    @Expose
    private  String nivel;

    public Rutina() {

    }

    public Rutina(String nombre, String tipo, String nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Rutina{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}
