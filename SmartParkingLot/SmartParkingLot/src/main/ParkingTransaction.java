package main;

import java.util.HashMap;
import java.util.Map;

import main.ParkingSpots.ParkingSpot;

public class ParkingTransaction {

    // Map to store entry times and vehicles parked in spots
    private Map<ParkingSpot, Long> entryTimes;
    private Map<ParkingSpot, Vehicle> parkedVehicles;  // To store which vehicle is in which spot

    public ParkingTransaction() {
        entryTimes = new HashMap<>();
        parkedVehicles = new HashMap<>();
    }

    // Records the entry of a vehicle into a parking spot
    public synchronized void recordEntry(ParkingSpot spot, Vehicle vehicle) {
        entryTimes.put(spot, System.currentTimeMillis());  // Store the entry time
        parkedVehicles.put(spot, vehicle);  // Store the vehicle in the spot
        System.out.println(vehicle.getLicensePlate() + " entered at spot: " + spot.getId());
    }

    // Calculate the fee for a vehicle in a specific spot
    public double calculateFee(ParkingSpot spot) {
        long duration = System.currentTimeMillis() - entryTimes.get(spot);  // Duration in ms
        Vehicle vehicle = parkedVehicles.get(spot);  // Get the vehicle from the parkedVehicles map
        double fee = FeeCalculator.calculateFee(vehicle.getVehicleType(), duration);
        System.out.println("Parking fee for " + vehicle.getLicensePlate() + ": " + fee);
        return fee;
    }

    // Records the exit of a vehicle from a parking spot
    public synchronized void recordExit(ParkingSpot spot) {
        Vehicle vehicle = parkedVehicles.get(spot);  // Fetch vehicle first
        double fee = calculateFee(spot);             // Calculate fee
        freeSpot(spot);                              // Now free the spot
        System.out.println("Vehicle with license plate " + vehicle.getLicensePlate() + " has exited.");
    }


    // Frees the parking spot and removes the vehicle
    public void freeSpot(ParkingSpot spot) {
        spot.setOccupied(false);  // Mark the spot as free
        entryTimes.remove(spot);  // Remove the entry time for this spot
        parkedVehicles.remove(spot);  // Remove the vehicle from the spot
        System.out.println("Spot " + spot.getId() + " is now free.");
    }
}
