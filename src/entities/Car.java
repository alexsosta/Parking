package entities;

public class Car{
    private Ticket ticket; // выданный билет
    private String number; // номер машины

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Car( Ticket ticket, String number) {
        this.ticket = ticket;
        this.number = number;
    }
}
