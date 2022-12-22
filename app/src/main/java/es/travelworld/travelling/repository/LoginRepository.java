package es.travelworld.travelling.repository;

import static es.travelworld.travelling.utilities.Constants.TAG_HOTELS;
import static es.travelworld.travelling.utilities.Constants.TAG_LOGIN;

import android.util.Log;

import androidx.annotation.NonNull;

import es.travelworld.travelling.domain.User;
import es.travelworld.travelling.repository.response.login.ResponseLogin;
import es.travelworld.travelling.repository.utils.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    public interface CallbackLogin {
        void onSuccess();

        void onError(Throwable error);
    }


    public void getResultLogin(User user, CallbackLogin callbackLogin) {
        ApiUtils.getApiLogin().doLogin(user).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(@NonNull Call<ResponseLogin> call, @NonNull Response<ResponseLogin> response) {
                if (response.isSuccessful()) {
                    callbackLogin.onSuccess();
                    Log.e("ApiLogin", "Resultado: " + response);
                    Log.e("ApiLogin", "Body: " + response.body());
                } else {
                    Log.e(TAG_LOGIN, "Error al hacer login");
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.e(TAG_HOTELS, "Error response http");
            }
        });
    }
}
