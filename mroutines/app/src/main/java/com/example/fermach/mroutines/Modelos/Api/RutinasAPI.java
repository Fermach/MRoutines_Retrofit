package com.example.fermach.mroutines.Modelos.Api;

import android.util.Log;

import com.example.fermach.mroutines.App;
import com.example.fermach.mroutines.Modelos.Rutina.Rutina;
import com.example.fermach.mroutines.Modelos.Rutina.RutinasDataSource;
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

public class RutinasAPI implements RutinasDataSource{


    /*
    Rutas para acceder a mi servidor AWS con la base de datos MongoDB
     */
    private APIServiceRutinas apiService;

    public RutinasAPI() {

    }


    /**
     * @param callback
     */
    @Override
    public void getRutinas(final CargaRutinasCallback callback) {

        apiService= ApiUtils.getAPIServiceRutinas();
        apiService.getRutinas().enqueue(new Callback<ArrayList<Rutina>>() {
            @Override
            public void onResponse(Call<ArrayList<Rutina>> call, Response<ArrayList<Rutina>> response) {
                Log.i("Respuesta_GET_Rutinas", response.body().toString());

                callback.onRutinasCargadas(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Rutina>> call, Throwable t) {
                Log.i("Respuesta_GET_Rutinas", "ERROR");

                callback.onRutinasCargadasError();
            }
        });

    }

    /**
     *
     * @param rutina
     * @param callback
     */
    @Override
    public void createRutina(final Rutina rutina, final CreateRutinaCallback callback) {
        apiService= ApiUtils.getAPIServiceRutinas();
        apiService.createRutina(rutina).enqueue(new Callback<Rutina>() {
            @Override
            public void onResponse(Call<Rutina> call, Response<Rutina> response) {
                Log.i("Respuesta_POST_Rutinas", response.message());

                callback.onRutinaCreada();
            }

            @Override
            public void onFailure(Call<Rutina> call, Throwable t) {
                Log.i("Respuesta_POST_Rutinas", "ERROR");

                callback.onRutinaCreadaError();
            }
        });

    }


    /**
     *
     * @param rutina_nombre
     * @param callback
     */
    @Override
    public void deleteRutina(String rutina_nombre, final DeleteRutinaCallback callback) {
      apiService= ApiUtils.getAPIServiceRutinas();
      apiService.deleteRutina(rutina_nombre).enqueue(new Callback<Rutina>() {
          @Override
          public void onResponse(Call<Rutina> call, Response<Rutina> response) {
              Log.i("Respuesta_DELETE_Rutina", response.message());

              callback.onRutinaEliminada();
          }

          @Override
          public void onFailure(Call<Rutina> call, Throwable t) {
              Log.i("Respuesta_DELETE_Rutina", "ERROR");

              callback.onRutinaEliminadaError();
          }
      });

    }

    /**
     *
     * @param rutina_nombre
     * @param rutina
     * @param callback
     */
    @Override
    public void updateRutina(final String rutina_nombre, final Rutina rutina, final UpdateRutinaCallback callback) {
      apiService=ApiUtils.getAPIServiceRutinas();
      apiService.updateRutina(rutina_nombre,rutina).enqueue(new Callback<Rutina>() {
          @Override
          public void onResponse(Call<Rutina> call, Response<Rutina> response) {
              Log.i("Respuesta_UPDATE_Rutina", response.message());

              callback.onRutinaActualizada(rutina_nombre);
          }

          @Override
          public void onFailure(Call<Rutina> call, Throwable t) {
              Log.i("Respuesta_DELETE_Rutina", "ERROR");

              callback.onRutinaActualizadaError();
          }
      });

    }


    /**
     *
     * @param posicion
     * @param callback
     */
    @Override
    public void getRutina(int posicion, CargaRutinaCallback callback) {

    }
}
