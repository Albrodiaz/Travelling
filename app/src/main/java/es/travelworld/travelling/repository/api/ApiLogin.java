package es.travelworld.travelling.repository.api;

import static es.travelworld.travelling.utilities.Constants.ENDPOINT_LOGIN;

import es.travelworld.travelling.repository.response.hotels.Response;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiLogin {

    @GET(ENDPOINT_LOGIN)
    Call<Response> searchUsers();

}
