package main;

public class Car implements Vehicle {
	
	 private String licensePlate;
	 
	    public Car(String licensePlate) {
	        this.licensePlate = licensePlate;
	    }

	    @Override
	    public String getLicensePlate() {
	        return licensePlate;
	    }
	    
	    @Override
	    public VehicleType getVehicleType() {
	        return VehicleType.CAR;
	    }
	    
	    @Override
	    public double calculateFee(long duration) {
	        return FeeCalculator.calculateFee(VehicleType.CAR, duration);
	    }
}
