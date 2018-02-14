package com.example.fermach.mroutines.Modelos.Api;

import android.util.Log;

import com.example.fermach.mroutines.Modelos.Ejercicio.Ejercicio;
import com.example.fermach.mroutines.Modelos.Ejercicio.EjerciciosDataSource;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * En esta clase se utiliza Retrofit para conectarse a nuestro servidor
 * y manda las respuesta al repositorio de datos
 *
 * @author Fermach
 * @version 1.0.
 */


public class EjerciciosAPI implements EjerciciosDataSource {

    /*
     Rutas para acceder a mi servidor AWS con la base de datos MongoDB
     */
    private APIServiceEjercicios apiService;

    public EjerciciosAPI() {
    }

    @Override
    public void getEjercicios(CargaEjerciciosCallback callback) {

    }

    /**
     *
     * @param rutina
     * @param callback
     */
    @Override
    public void getEjerciciosPorRutina(String rutina, final CargaEjerciciosCallback callback) {
      apiService=ApiUtils.getAPIServiceEjercicios();
      apiService.getEjercicios(rutina).enqueue(new Callback<ArrayList<Ejercicio>>() {
          @Override
          public void onResponse(Call<ArrayList<Ejercicio>> call, Response<ArrayList<Ejercicio>> response) {
              Log.i("Respuesta_GET_Ejerc", response.body().toString());
              callback.onEjerciciosCargados(response.body());
          }

          @Override
          public void onFailure(Call<ArrayList<Ejercicio>> call, Throwable t) {
              Log.i("Respuesta_GET_Ejerc", "ERROR");
              callback.onEjerciciosCargadosError();

          }
      });

    }

    /**
     *
     * @param ejercicio
     * @param callback
     */
    @Override
    public void createEjercicio(final Ejercicio ejercicio, final CreateEjercicioCallback callback) {
       apiService= ApiUtils.getAPIServiceEjercicios();
       apiService.createEjercicio(ejercicio).enqueue(new Callback<Ejercicio>() {
           @Override
           public void onResponse(Call<Ejercicio> call, Response<Ejercicio> response) {
               Log.i("Respuesta_POST_Ejerc",response.message());
               callback.onEjercicioCreado();

           }

           @Override
           public void onFailure(Call<Ejercicio> call, Throwable t) {
               Log.i("Respuesta_POST_Ejerc","ERROR");
               callback.onEjercicioCreadoError();

           }
       });

    }

    /**
     *
     * @param id_ejercicio
     * @param callback
     */
    @Override
    public void deleteEjercicio(String id_ejercicio, final DeleteEjercicioCallback callback) {
         apiService=ApiUtils.getAPIServiceEjercicios();
         apiService.deleteEjercicio(id_ejercicio).enqueue(new Callback<Ejercicio>() {
             @Override
             public void onResponse(Call<Ejercicio> call, Response<Ejercicio> response) {
                 Log.i("Respuesta_DELETE_Ejerc", response.message());
                 callback.onEjercicioEliminado();
             }

             @Override
             public void onFailure(Call<Ejercicio> call, Throwable t) {
                 Log.i("Respuesta_DELETE_Ejerc", "ERROR");
                 callback.onEjercicioEliminadoError();
             }
         });

    }

    /**
     *
     * @param nombre_rutina
     * @param callback
     */
    @Override
    public void deleteEjercicios(String nombre_rutina, final DeleteEjerciciosCallback callback) {
       apiService=ApiUtils.getAPIServiceEjercicios();
       apiService.deleteEjercicios(nombre_rutina).enqueue(new Callback<Ejercicio>() {
           @Override
           public void onResponse(Call<Ejercicio> call, Response<Ejercicio> response) {
               Log.i("Respuesta_DELETE_Ejercs", response.message());
               callback.onEjerciciosEliminados();
           }

           @Override
           public void onFailure(Call<Ejercicio> call, Throwable t) {
               Log.i("Respuesta_DELETE_Ejercs", "ERROR");
               callback.onEjerciciosEliminadosError();
           }
       });

    }

    /**
     *
     * @param id_ejercicio
     * @param ejercicio
     * @param callback
     */
    @Override
    public void updateEjercicio(final String id_ejercicio, Ejercicio ejercicio, final UpdateEjercicioCallback callback) {
        apiService=ApiUtils.getAPIServiceEjercicios();
        apiService.updateEjercicio(id_ejercicio,ejercicio).enqueue(new Callback<Ejercicio>() {
            @Override
            public void onResponse(Call<Ejercicio> call, Response<Ejercicio> response) {
                Log.i("Respuesta_UPDATE_Ejerc", response.message());
                callback.onEjercicioActualizado(id_ejercicio);
            }

            @Override
            public void onFailure(Call<Ejercicio> call, Throwable t) {
                Log.i("Respuesta_UPDATE_Ejerc", "ERROR");
                callback.onEjercicioActualizadoError();
            }
        });
    }

    @Override
    public void getEjercicio(int posicion, CargaEjercicioCallback callback) {

    }
}
