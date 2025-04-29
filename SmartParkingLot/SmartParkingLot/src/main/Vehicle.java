	package main;
	
	public interface Vehicle {
	  public String getLicensePlate();
	  public VehicleType getVehicleType();
	  public double calculateFee(long duration);
	}