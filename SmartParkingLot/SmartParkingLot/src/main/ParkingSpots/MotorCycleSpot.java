package main.ParkingSpots;

import main.Vehicle;
import main.VehicleType;

public class MotorCycleSpot extends ParkingSpot{

	public MotorCycleSpot(int id) {
        super(id, VehicleType.MOTORCYCLE);
    }

    @Override
    public boolean matches(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.MOTORCYCLE;
    }
}
