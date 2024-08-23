package com.ariba.model.SUV;

public enum SUVName {

    CRETA("Hyundai Creta", 1),
    FORTUNER("Toyota Fortuner", 2),
    DUSTER("Renault Duster", 1);

    // Can be removed on addition of DB Conn
    String vType;
    int size;

    SUVName(String vType, int size) {
        this.vType = vType;
        this.size = size;
    }

    public int returnSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return this.vType;
    }
}
