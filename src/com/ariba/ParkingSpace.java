package com.ariba;

import com.ariba.model.FourWheeler;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {

    private static int idCounter = 0;
    private final int id = ++idCounter;
    private final int capacity;
    private final List<FourWheeler> parkedVehicles = new ArrayList<>();

    public ParkingSpace(int capacity) {
        this.capacity = capacity;
    }

    public boolean accepts(FourWheeler vehicle) {
        return isSlotFree(() -> (capacity >= parkedVehicles.get(0).getSpacesNeeded() + vehicle.getSpacesNeeded()));
    }

    public void addVehicle(FourWheeler vehicle) {
        parkedVehicles.add(vehicle);
        System.out.println(String.format("%s is parked in space number %d", vehicle, id));
    }

    public boolean isFree() {
        return isSlotFree(() -> (capacity > parkedVehicles.get(0).getSpacesNeeded()));
    }

    // Adds default boolean for full and empty cases. Lambda handles other cases
    private boolean isSlotFree(CapacityCalculator b) {
        switch (parkedVehicles.size()) {
            case 0:
                return true;
            case 2:
                return false;
            default:
                return b.isCapacityLeft();
        }
    }

    public void remove(FourWheeler vehicle) {
        parkedVehicles.remove(vehicle);
        System.out.println(String.format("%s removed from slot %d", vehicle, id));
    }

    @Override
    public String toString() {
        return "ParkingSpace [id: " + id + ", capacity=" + capacity + ", parkingVehicles=" + parkedVehicles + "]";
    }
}

// Functional interface implementation from OCAJP
interface CapacityCalculator {
    boolean isCapacityLeft();
}