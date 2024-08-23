package com.ariba;

public class Main {

    private final ParkingLot parkingLot;

    public Main(int numberOfSlots) {
        parkingLot = new ParkingLot(numberOfSlots);
    }

    public static void main(String[] args) {
	    // write your code here
        int numberOfSlots = 100;
        new Main(numberOfSlots).start();
    }

    private void start() {
        ThreadLot threadLot = new ThreadLot(this.parkingLot);
        RunnableLot runnableLot = new RunnableLot(this.parkingLot);

        threadLot.start();
        runnableLot.run();
    }
}
