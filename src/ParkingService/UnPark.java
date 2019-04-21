package ParkingService;

import entities.Parking;

public class UnPark implements Runnable {
    int ticket;

    public UnPark(int param) {
        this.ticket = param;
    }

    @Override
    public void run() {
        Parking.getThisParking().unPark(this.ticket);
        try {
            Thread.currentThread().sleep((long) Math.random()*5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
