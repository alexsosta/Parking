package ParkingService;

import entities.Parking;

public class Park implements Runnable {
    String CarNumber;

    public Park(String param) {
        this.CarNumber = param;
    }

    @Override
    public void run() {
        Parking.getThisParking().park(this.CarNumber);
        try {
            Thread.currentThread().sleep((long) Math.random()*5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
