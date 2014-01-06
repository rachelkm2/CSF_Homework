import java.util.ArrayList;


public class Restaurant{

    private String restName;
    private int restCapacity;
    private int restOpen;
    private int restClose;

    public ArrayList<Reservation> restReservations = new ArrayList<Reservation>();

    public Restaurant(){
        super();
    }

    public Restaurant(String name, int capacity, int open, int close){
        this();
        this.restName = name;
        this.restCapacity = capacity;
        this.restOpen = open;
        this.restClose = close;
    }

    public void addReservation(Reservation newRes){
        restReservations.add(newRes);
    }

    public String getRestName() { return restName;}

    public void setRestName(String restName) { this.restName = restName;}

    public int getRestCapacity() { return restCapacity; }

    public void setRestCapacity(int restCapacity) { this.restCapacity = restCapacity; }

    public int getRestOpen() { return restOpen; }

    public void setRestOpen(int restOpen) {
        this.restOpen = restOpen;
    }

    public int getRestClose() {
        return restClose;
    }

    public void setRestClose(int restClose) {
        this.restClose = restClose;
    }
}