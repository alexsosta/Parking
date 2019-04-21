package entities;

public class Ticket extends MainEntity{
    private int placeNumber; // Если я правильно понял, то билет закрепляется за парковочным местом( тк он забирается)
    private boolean place; // свободно ли место

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public boolean getPlace() {
        return place;
    }

    public void setPlace(boolean place) {
        this.place = place;
    }

    public Ticket(int id, int placeNumber, boolean place) {
        super(id);
        this.placeNumber = placeNumber;
        this.place = place;
    }
    public Ticket(Ticket ticket) {
        super(ticket.getId());
        this.placeNumber = ticket.getPlaceNumber();
        this.place = ticket.getPlace();
    }
}
