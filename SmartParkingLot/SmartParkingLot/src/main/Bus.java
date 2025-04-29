package main;

public class Bus implements Vehicle {

	private String licensePlate;
	
    public Bus(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    @Override
    public String getLicensePlate() {
        return licensePlate;
    }
    
    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BUS;
    }
    
    @Override
    public double calculateFee(long duration) {
        return FeeCalculator.calculateFee(VehicleType.BUS, duration);
    }

}
