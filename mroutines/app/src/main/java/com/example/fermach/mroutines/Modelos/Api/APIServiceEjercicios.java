package com.example.fermach.mroutines.Modelos.Api;

import com.example.fermach.mroutines.Modelos.Ejercicio.Ejercicio;
import com.example.fermach.mroutines.Modelos.Rutina.Rutina;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Interfaz con los métodos que usará Retrofit
 *
 *  @author Fermach
 * @version 1.0.
 */

public interface APIServiceEjercicios {

    @GET("ejercicios/rutina/{nombre}")
    Call<ArrayList<Ejercicio>> getEjercicios(@Path("nombre") String nombre_rutina);

    @POST("ejercicios")
    Call<Ejercicio> createEjercicio(@Body Ejercicio ejercicio);

    @PUT("ejercicios/id/{id}")
    Call<Ejercicio> updateEjercicio(@Path("id") String idEjercicio, @Body Ejercicio ejercicio);

    @DELETE("ejercicios/id/{id}")
    Call<Ejercicio> deleteEjercicio(@Path("id") String id_ejercicio);

    @DELETE("ejercicios/rutina/{nombre}")
    Call<Ejercicio> deleteEjercicios(@Path("nombre") String nombre_rutina);

}
