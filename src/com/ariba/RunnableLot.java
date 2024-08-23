package com.ariba;

import com.ariba.model.SUV.SUV;
import com.ariba.model.SUV.SUVName;

public class RunnableLot implements Runnable {

    ParkingLot parkingLot;

    public RunnableLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        try {
            synchronized (parkingLot) {
                parkingLot.parkVehicle(new SUV(SUVName.CRETA, 1, 0.5));
                System.out.println("Runnable function running");
                System.out.println(parkingLot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
