import java.util.LinkedList;

public class Restaurant {
    private String name;
    private LinkedList<Reservation> reservationListing;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addReservation(int time, String name, int numberOfGuests) {
        Reservation res = new Reservation(time, name, numberOfGuests);
        reservationListing.add(res);
    }

    public void printAllReservations() {
        for(int i = 0; i < reservationListing.size(); i++) {

            System.out.println(reservationListing.get(i).toString());
        }
    }

}