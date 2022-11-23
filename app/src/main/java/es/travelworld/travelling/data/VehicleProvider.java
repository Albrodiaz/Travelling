package es.travelworld.travelling.data;

import java.util.ArrayList;
import java.util.List;

import es.travelworld.travelling.R;
import es.travelworld.travelling.model.Vehicle;

public class VehicleProvider {
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Classic", 34f, R.color.classicColor, R.drawable.classic_car));
        vehicles.add(new Vehicle("Sport", 55f, R.color.sportColor, R.drawable.sport_car));
        vehicles.add(new Vehicle("Flying", 500f, R.color.flyingColor, R.drawable.flying_car));
        vehicles.add(new Vehicle("Electric", 45f, R.color.electricColor, R.drawable.electric_car));
        vehicles.add(new Vehicle("Motorhome", 23f, R.color.motorhomeColor, R.drawable.motor_home));
        vehicles.add(new Vehicle("Pickup", 10f, R.color.pickupColor, R.drawable.pickup_car));
        vehicles.add(new Vehicle("Airplane", 11f, R.color.airplaneColor, R.drawable.airplane));
        vehicles.add(new Vehicle("Bus", 14f, R.color.busColor, R.drawable.bus));
        return vehicles;
    }
}
