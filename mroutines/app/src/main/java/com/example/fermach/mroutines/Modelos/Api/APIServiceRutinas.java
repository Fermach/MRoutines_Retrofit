package com.example.fermach.mroutines.Modelos.Api;

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

public interface APIServiceRutinas {


    @GET("rutinas")
    Call<ArrayList<Rutina>> getRutinas();

    @POST("rutinas")
    Call<Rutina> createRutina(@Body Rutina rutina);

    @PUT("rutinas/nombre/{nombre}")
    Call<Rutina> updateRutina(@Path("nombre") String nombre_rutina,@Body Rutina rutina);

    @DELETE("rutinas/nombre/{nombre}")
    Call<Rutina> deleteRutina(@Path("nombre") String nombre_rutina);

}
