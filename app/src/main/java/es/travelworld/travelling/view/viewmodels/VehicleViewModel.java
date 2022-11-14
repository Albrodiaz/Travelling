package es.travelworld.travelling.view.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import es.travelworld.travelling.data.VehicleProvider;
import es.travelworld.travelling.domain.Vehicle;

public class VehicleViewModel extends ViewModel {
    private final MutableLiveData<List<Vehicle>> vehicles = new MutableLiveData<>();

    public LiveData<List<Vehicle>> getVehicles() {
        return vehicles;
    }

    public void loadVehicles() {
        vehicles.setValue(VehicleProvider.getVehicles());
    }
}
