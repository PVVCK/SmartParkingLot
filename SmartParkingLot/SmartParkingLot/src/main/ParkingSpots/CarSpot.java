package main.ParkingSpots;

import main.Vehicle;
import main.VehicleType;

public class CarSpot extends ParkingSpot {

	public CarSpot(int id) {
        super(id, VehicleType.CAR);
    }

    @Override
    public boolean matches(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.CAR;
    }
}
