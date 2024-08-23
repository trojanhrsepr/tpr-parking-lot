package com.ariba;

import com.ariba.model.FourWheeler;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class ParkingLot {

    // All free parking spaces will be stored in this collection
    private final Collection<ParkingSpace> freeParkingSpaces = new HashSet<>();

    // Collection to handle all parking spaces in a lot
    private final Collection<ParkingSpace> allParkingSpaces = new HashSet<>();

    // Mapping all vehicles to parking spaces
    private final Map<FourWheeler, ParkingSpace> parkedVehicles = new HashMap<>();

    // List to maintain all parking tickets
    private final List<ParkingTicket> tickets = new ArrayList<>();

    private double parkingRevenue = 0.0;
    private static final CostCalculator cost = new CostCalculator();

    // Adding all slots in a map initialising parking slot
    public ParkingLot(int numberOfSlots) {
        Random random = new Random();
        for (int i = 0; i < numberOfSlots; i++) {

            // For adding random number of parking spaces
            // Can be replaced by Database values to avoid hard coding
            allParkingSpaces.add(new ParkingSpace(1 + random.nextInt(1)));
        }

        // Spaces will all be initially free
        freeParkingSpaces.addAll(allParkingSpaces);
    }

    public ParkingTicket parkVehicle(FourWheeler vehicle) {
        ParkingSpace targetParkingSpace = freeParkingSpaces.stream().filter(p -> p.accepts(vehicle)).findFirst()
                .orElseThrow(() -> new RuntimeException("No free slot for " + vehicle));
        targetParkingSpace.addVehicle(vehicle);
        if (!targetParkingSpace.isFree()) {
            freeParkingSpaces.remove(targetParkingSpace);
        }
        parkedVehicles.put(vehicle, targetParkingSpace);
        tickets.add(new ParkingTicket(vehicle));
        return new ParkingTicket(vehicle);
    }

    public void unparkVehicle(ParkingTicket parkingTicket) {
        ParkingSpace targetParkingSpace = parkedVehicles.remove(parkingTicket.getVehicle());
        targetParkingSpace.remove(parkingTicket.getVehicle());
        freeParkingSpaces.add(targetParkingSpace);
        parkingRevenue += parkingTicket.calculateCost(cost);
    }

    @Override
    public String toString() {
        return String.format("Parking Lot: Revenue Generated: %.2f, Free Spaces: %d, Vehicles parked: %d", parkingRevenue, freeParkingSpaces.size(),
                parkedVehicles.size());
    }
}

