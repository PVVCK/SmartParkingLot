package main;

import java.util.HashMap;
import java.util.Map;

import main.ParkingSpots.BusSpot;
import main.ParkingSpots.CarSpot;
import main.ParkingSpots.MotorCycleSpot;
import main.ParkingSpots.ParkingSpot;

public class ParkingLot {

    private Map<Integer, ParkingSpot> parkingSpots;  // Map to store ParkingSpot by id

    public ParkingLot(int totalSpots) {
        parkingSpots = new HashMap<>();
        for (int i = 1; i <= totalSpots / 3; i++) {  // Assume 1/3 of spots for each type
            parkingSpots.put(i, new CarSpot(i));
            parkingSpots.put(i + totalSpots / 3, new MotorCycleSpot(i + totalSpots / 3));
            parkingSpots.put(i + 2 * totalSpots / 3, new BusSpot(i + 2 * totalSpots / 3));
        }
    }

    public synchronized ParkingSpot findAvailableSpot(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots.values()) {
            if (!spot.isOccupied() && spot.matches(vehicle)) {
                return spot;
            }
        }
        return null;  // No available spot found
    }


    public synchronized ParkingSpot parkVehicle(Vehicle vehicle, ParkingTransaction transaction) {
        ParkingSpot spot = findAvailableSpot(vehicle);
        if (spot != null) {
            spot.setOccupied(true);
            transaction.recordEntry(spot, vehicle); // Record entry at the time of parking
            System.out.println(vehicle.getLicensePlate() + " parked in spot: " + spot.getId());
        } else {
            System.out.println("No available spot for " + vehicle.getLicensePlate());
        }
        return spot; // <-- IMPORTANT: always return spot (even if it's null)
    }

    public synchronized void freeSpot(ParkingSpot spot) {
        spot.setOccupied(false);
        System.out.println("Spot " + spot.getId() + " is now free.");
    }
}
