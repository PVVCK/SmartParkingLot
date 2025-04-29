package main.ParkingSpots;

import main.Vehicle;
import main.VehicleType;

public abstract class ParkingSpot {

	 	private int id;
	    private boolean isOccupied;
	    private VehicleType vehicleType;

	    public ParkingSpot(int id, VehicleType vehicleType) {
	        this.id = id;
	        this.vehicleType = vehicleType;
	        this.isOccupied = false;
	    }

	    public int getId() {
	    	return id; 
	    }
	    
	    public boolean isOccupied() {
	    	return isOccupied; 
	    }
	    
	    public void setOccupied(boolean occupied) {
	    	isOccupied = occupied; 
	    }
	    
	    public VehicleType getVehicleType() { 
	    	return vehicleType;
	    }
	    
	    public abstract boolean matches(Vehicle vehicle);
}
