package com.ariba;

import com.ariba.model.Car.Car;
import com.ariba.model.Car.CarName;

public class ThreadLot extends Thread {

    ParkingLot parkingLot;

    public ThreadLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        try {
            synchronized (parkingLot) {
                parkingLot.parkVehicle(new Car(CarName.ETIOS, 2, 0.3));
                System.out.println("Thread function running");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
