package es.travelworld.travelling.data;

import java.util.ArrayList;
import java.util.List;

import es.travelworld.travelling.R;
import es.travelworld.travelling.domain.Vehicle;

public class VehicleProvider {
    public static List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("classic", 34f, R.color.classicColor, R.drawable.classic_car));
        vehicles.add(new Vehicle("sport", 55f, R.color.sportColor, R.drawable.sport_car));
        vehicles.add(new Vehicle("flying", 500f, R.color.flyingColor, R.drawable.flying_car));
        vehicles.add(new Vehicle("electric", 45f, R.color.electricColor, R.drawable.electric_car));
        vehicles.add(new Vehicle("motorhome", 23f, R.color.motorhomeColor, R.drawable.motor_home));
        vehicles.add(new Vehicle("pickup", 10f, R.color.pickupColor, R.drawable.pickup_car));
        vehicles.add(new Vehicle("airplane", 11f, R.color.airplaneColor, R.drawable.airplane));
        vehicles.add(new Vehicle("bus", 14f, R.color.busColor, R.drawable.bus));
        return vehicles;
    }
}
