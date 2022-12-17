package es.travelworld.travelling.repository.api;

import static es.travelworld.travelling.utilities.Constants.ENDPOINT_LOGIN;

import es.travelworld.travelling.repository.response.login.ResponseLogin;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiLogin {
    @POST(ENDPOINT_LOGIN)
    Call<ResponseLogin> doLogin(@Query("usuario") String user,
                                @Query("password") String password);

}
