package entities;


import java.util.ArrayList;


public class Parking {
    private static Parking thisParking; // инстанс данной парковки
    private int emptyPlaces; // количество свободных парковочных мест
    Ticket [] tickets; // билеты
    ArrayList<Car> cars;

    public int getEmptyPlaces() {
        return emptyPlaces;
    }

    public void setEmptyPlaces(int emptyPlaces) {
        this.emptyPlaces = emptyPlaces;
    }

    public static Parking getThisParking() {
        return thisParking;
    }

    public static void setThisParking(Parking parking) {
        thisParking = parking;
    }

    public Parking(int emptyPlaces) {
        this.emptyPlaces = emptyPlaces;
        tickets = new Ticket[emptyPlaces];
        for (int i = 0; i < emptyPlaces; i++) {
            tickets[i] =  new Ticket(i,i,true);
        }
        thisParking = this;
    }

    public void park(String N){
        emptyPlaces--;
        int i = getEmpty();
        cars.add(new Car(tickets[i],N));
        tickets[i].setPlace(false);
    }

    public void unPark(int i){
        tickets[i].setPlace(true);
        emptyPlaces++;
        cars.remove(getCarByTicket(i));
    }

    private int getEmpty(){
        int i = 999;
        for (; i < tickets.length; i++) {
            if (tickets[i].getPlace() == true) break;
        }
        return i;
    }


    private Car getCarByTicket(int ticket){
        Car res = null;
        for (Car car:cars) {
            if (car.getTicket().getId() == ticket)res = car;
        }
        return res;
    }

    public void list (){
        for (Ticket ticket: tickets) {
            System.out.println("Порядковый номер машины:" + ticket.getPlaceNumber() + "  " + "Номер билета:" + ticket.getId());
        }

    }
}