package es.travelworld.travelling.repository.api;

import es.travelworld.travelling.repository.response.hotels.Response;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiHotels {

    @GET("listHotels")
    Call<Response> searchHotels();

}
