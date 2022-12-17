package es.travelworld.travelling.repository.utils;

import static es.travelworld.travelling.utilities.Constants.HOST_URL;

import es.travelworld.travelling.repository.api.ApiHotels;
import es.travelworld.travelling.repository.api.ApiLogin;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

abstract public class ApiUtils {

    public static ApiHotels getApiHotels() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiHotels.class);
    }

    public static ApiLogin getApiLogin() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiLogin.class);
    }

}
