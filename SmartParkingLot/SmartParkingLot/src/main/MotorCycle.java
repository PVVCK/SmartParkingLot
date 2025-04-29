package main;

public class MotorCycle implements Vehicle {

	 private String licensePlate;
	 
	    public MotorCycle(String licensePlate) {
	        this.licensePlate = licensePlate;
	    }
    
    @Override
    public String getLicensePlate() {
        return licensePlate;
    }
    
    @Override
    public VehicleType getVehicleType() {
        return VehicleType.MOTORCYCLE;
    }
    
    @Override
    public double calculateFee(long duration) {
        return FeeCalculator.calculateFee(VehicleType.MOTORCYCLE, duration);
    }
}
