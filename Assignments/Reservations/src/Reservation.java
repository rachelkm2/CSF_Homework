public class Reservation{

    private String reserveName;
    private int reserveTime;
    private int reserveNumber;
    private String reserveType;
    private String reservePhone;

    public Reservation(){
        super();
    }

    public Reservation(String name, int time, int number){
        this();
        this.reserveName = name;
        this.reserveTime = time;
        this.reserveNumber = number;
    }

    public String getReserveName() {

        return reserveName;
    }

    public void setReserveName(String reserveName) {


        this.reserveName = reserveName;
    }

    public int getReserveTime() { return reserveTime; }

    public void setReserveTime(int reserveTime) { this.reserveTime = reserveTime; }

    public int getReserveNumber() { return reserveNumber; }

    public void setReserveNumber(int reserveNumber) {
        this.reserveNumber = reserveNumber;
    }

}
