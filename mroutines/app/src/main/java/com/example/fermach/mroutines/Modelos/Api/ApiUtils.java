package com.example.fermach.mroutines.Modelos.Api;

/**
 * Esta clase enlaza nuestra instancia del Cliente de Retrofit con con
 * la URL de nuestro servidor y la interfaz con nuestros metodos.
 *
 * @author Fermach
 * @version 1.0.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://ec2-18-219-167-230.us-east-2.compute.amazonaws.com:5000/";

    public static APIServiceRutinas getAPIServiceRutinas() {

        return RetrofitClient.getClient(BASE_URL).create(APIServiceRutinas.class);
    }

    public static APIServiceEjercicios getAPIServiceEjercicios() {

        return RetrofitClient.getClient(BASE_URL).create(APIServiceEjercicios.class);
    }
}