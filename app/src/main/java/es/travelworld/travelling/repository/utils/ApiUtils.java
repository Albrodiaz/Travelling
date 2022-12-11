package es.travelworld.travelling.repository.utils;

import static es.travelworld.travelling.utilities.Constants.HOST_HOTELS;

import es.travelworld.travelling.repository.api.ApiHotels;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

abstract public class ApiUtils {

    public static ApiHotels getApiHotels() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_HOTELS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiHotels.class);
    }

}
