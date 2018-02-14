package com.example.fermach.mroutines.Modelos.Ejercicio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * Modelo de Ejercicio
 *
 * @author Fermach
 * @version 1.0.
 *
 */
public class Ejercicio implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nombre")
    @Expose
    private String nombre="";

    @SerializedName("series")
    @Expose
    private String series="0";

    @SerializedName("repeticiones")
    @Expose
    private String repeticiones="0";

    @SerializedName("tiempo")
    @Expose
    private String tiempo ="0";

    @SerializedName("tipo")
    @Expose
    private String tipo;

    @SerializedName("rutina")
    @Expose
    private String rutina;


    public Ejercicio(String id, String nombre, String series, String repeticiones, String tiempo, String tipo, String rutina) {
        this.id=id;
        this.nombre = nombre;
        this.series = series;
        this.repeticiones = repeticiones;
        this.tiempo = tiempo;
        this.tipo = tipo;
        this.rutina = rutina;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(String repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRutina() {
        return rutina;
    }

    public void setRutina(String rutina) {
        this.rutina = rutina;
    }

    @Override
    public String toString() {
        return "Ejercicio{" +
                "ID= "+ id+ "\n"+
                "nombre='" + nombre + '\'' +
                ", series=" + series +
                ", repeticiones=" + repeticiones +
                ", tiempo='" + tiempo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", rutina='" + rutina + '\'' +
                '}';
    }
}
