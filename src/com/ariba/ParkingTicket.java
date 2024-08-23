package com.ariba;

import com.ariba.model.FourWheeler;

public class ParkingTicket {

    private final long startTime = System.currentTimeMillis();
    private final FourWheeler vehicle;

    public ParkingTicket(FourWheeler vehicle) {
        this.vehicle = vehicle;
    }

    public long calcualteParkingDuration(){
        return System.currentTimeMillis() - startTime;
    }

    public double calculateCost(CostCalculator calculator){
        return calculator.getCost(calcualteParkingDuration(), vehicle.getTimeCharge());
    }

    public FourWheeler getVehicle(){
        return vehicle;
    }
}

