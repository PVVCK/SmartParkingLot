package main.ParkingSpots;

import main.Vehicle;
import main.VehicleType;

public class BusSpot extends ParkingSpot {

	 public BusSpot(int id) {
	        super(id, VehicleType.BUS);
	    }

	    @Override
	    public boolean matches(Vehicle vehicle) {
	        return vehicle.getVehicleType() == VehicleType.BUS;
	    }
}
