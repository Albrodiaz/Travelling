package es.travelworld.travelling.view.home.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import es.travelworld.travelling.data.VehicleProvider;
import es.travelworld.travelling.domain.Vehicle;

public class VehicleViewModel extends ViewModel {
    private final VehicleProvider vehicleProvider;

    public VehicleViewModel(VehicleProvider vehicleProvider) {
        this.vehicleProvider = vehicleProvider;
    }

    private final MutableLiveData<List<Vehicle>> vehicles = new MutableLiveData<>();

    public LiveData<List<Vehicle>> getVehicles() {
        return vehicles;
    }

    public void loadVehicles() {
        vehicles.setValue(vehicleProvider.getVehicles());
    }

    public static class Factory implements ViewModelProvider.Factory {
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new VehicleViewModel(new VehicleProvider());
        }
    }
}
