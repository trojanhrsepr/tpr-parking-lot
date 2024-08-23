package com.ariba.model.Car;

import com.ariba.model.FourWheeler;

public class Car extends FourWheeler {

    public Car(CarName car, int id, double timeCharge) {
        super(id, timeCharge);
        this.vehicleType = car.toString();
        this.spacesNeeded = car.returnSize();
        addCarCount();
    }

    static int carCount;
    public static int getCarCount() {
        return carCount;
    }
    public static void addCarCount() { carCount++; }
}
