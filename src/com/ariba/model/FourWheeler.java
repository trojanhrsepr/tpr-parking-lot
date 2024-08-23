package com.ariba.model;

public abstract class FourWheeler {

    protected int id;
    protected int spacesNeeded;
    protected double timeCharge;
    protected String vehicleType;

    public FourWheeler(int id, double timeCharge) {
        this.id = id;
        this.timeCharge = timeCharge;
    }

    public int getSpacesNeeded() {
        return spacesNeeded;
    }
    public double getTimeCharge() {
        return timeCharge;
    }

    @Override
    public String toString() {
        return String.format("Vehicle Details: Name: %s, Vehicle ID: %d, Spaces needed: %d, Cost factor: %.2f", vehicleType, id,
                spacesNeeded, timeCharge);
    }
}
