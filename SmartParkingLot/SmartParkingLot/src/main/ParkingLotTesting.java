package main;

import main.ParkingSpots.ParkingSpot;

public class ParkingLotTesting {
	 public static void main(String[] args) throws InterruptedException {
	
		 	ParkingLot parkingLot = new ParkingLot(9);
	        ParkingTransaction transaction = new ParkingTransaction();

	        // Step 3: Create Vehicles
	        Vehicle car1 = new Car("CAR-123");
	        Vehicle motorcycle1 = new MotorCycle("BIKE-456");
	        Vehicle car2 = new Car("CAR-789");

	        // Step 4: Park the vehicles
	        ParkingSpot carSpot1 = parkingLot.parkVehicle(car1, transaction);
	        ParkingSpot bikeSpot1 = parkingLot.parkVehicle(motorcycle1, transaction);
	        ParkingSpot carSpot2 = parkingLot.parkVehicle(car2, transaction);

	        // Step 5: Simulate some parking time
	        System.out.println("\nVehicles are parked... Waiting...\n");
	        Thread.sleep(2000); // Sleep for 2 seconds

	        // Step 6: Record exits
	        System.out.println("\n--- Vehicles Exiting ---\n");
	        if (carSpot1 != null) transaction.recordExit(carSpot1);
	        Thread.sleep(7000);
	        if (bikeSpot1 != null) transaction.recordExit(bikeSpot1);
	        Thread.sleep(19000);
	        if (carSpot2 != null) transaction.recordExit(carSpot2);

	        System.out.println("\n--- All operations completed ---\n");
	}

}
