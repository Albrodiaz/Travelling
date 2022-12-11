package es.travelworld.travelling.repository.api;

import static es.travelworld.travelling.utilities.Constants.ENDPOINT_HOTELS;

import es.travelworld.travelling.repository.response.hotels.Response;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiHotels {

    @GET(ENDPOINT_HOTELS)
    Call<Response> searchHotels();

}
