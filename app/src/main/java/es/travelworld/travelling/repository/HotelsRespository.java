package es.travelworld.travelling.repository;

import static es.travelworld.travelling.utilities.Constants.TAG_HOTELS;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.List;

import es.travelworld.travelling.domain.Hotels;
import es.travelworld.travelling.repository.mapper.MapperHotels;
import es.travelworld.travelling.repository.response.hotels.Response;
import es.travelworld.travelling.repository.utils.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;

public class HotelsRespository {

    public interface CallbackHotels {
        void onSuccess(List<Hotels> hotelsList);
        void onError(Throwable error);
    }

    public void getResultHotel(CallbackHotels callbackHotels) {
        ApiUtils.getApiHotels().searchHotels().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(@NonNull Call<Response> call, @NonNull retrofit2.Response<Response> response) {
                if (response.isSuccessful()){
                    callbackHotels.onSuccess(MapperHotels.mapToHotels(response.body()));
                } else {
                    Log.e(TAG_HOTELS, "Error al cargar");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Response> call, @NonNull Throwable t) {

            }
        });
    }
}
