package com.ariba.model.SUV;

import com.ariba.model.FourWheeler;

public class SUV extends FourWheeler {

    public SUV(SUVName suv, int id, double timeCharge) {
        super(id, timeCharge);
        this.vehicleType = suv.toString();
        this.spacesNeeded = suv.returnSize();
        addSUVCount();
    }

    // Value can be persisted from DB
    static int suvCount = 0;
    public static int getSUVCount() { return suvCount; }
    public static void addSUVCount() { suvCount++; }
}
