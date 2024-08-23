package com.ariba.model.Car;

public enum CarName {

    VERNA("Hyundai Verna", 1),
    ETIOS("Toyota Etios", 1),
    SWIFT("Maruti Swift", 1);

    // Can be removed on addition of DB Conn
    String vType;
    int size;

    CarName(String vType, int size) {
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
