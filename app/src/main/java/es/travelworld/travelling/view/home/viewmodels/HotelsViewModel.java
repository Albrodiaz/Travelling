package es.travelworld.travelling.view.home.viewmodels;

import static es.travelworld.travelling.utilities.Constants.TAG_HOTELVIEWMODEL;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import es.travelworld.travelling.domain.Hotels;
import es.travelworld.travelling.repository.HotelsRespository;

public class HotelsViewModel extends ViewModel {

    private HotelsRespository respository;

    public HotelsViewModel(HotelsRespository respository) {
        this.respository = respository;
    }

    private MutableLiveData<List<Hotels>> hotelList = new MutableLiveData<>();

    public LiveData<List<Hotels>> getHotelList() {
        return hotelList;
    }

    public void loadHotels() {
        respository.getResultHotel(new HotelsRespository.CallbackHotels() {
            @Override
            public void onSuccess(List<Hotels> list) {
                hotelList.setValue(list);
            }

            @Override
            public void onError(Throwable error) {
                Log.e(TAG_HOTELVIEWMODEL, "Error: " + error.getMessage());
            }
        });
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        private final HotelsRespository hotelsRespository;

        public Factory(HotelsRespository hotelsRespository) {
            this.hotelsRespository = hotelsRespository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new HotelsViewModel(hotelsRespository);
        }
    }

}
