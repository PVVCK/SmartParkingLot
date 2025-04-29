package main;

public class FeeCalculator {

	  public static double calculateFee(VehicleType vehicleType, long duration) {
	        double ratePerHour = getRate(vehicleType);
	        return (duration / 3600000.0) * ratePerHour; // Convert duration from ms to hours
	    }

	    private static double getRate(VehicleType vehicleType) {
	        switch (vehicleType) {
	            case MOTORCYCLE: return 2.0;
	            case CAR: return 5.0;
	            case BUS: return 10.0;
	            default: return 0;
	        }
	    }
}
