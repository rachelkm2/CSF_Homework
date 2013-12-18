public class Application {

    public static void main(String[] args){
        Restaurant cosi = new Restaurant();
        cosi.addReservation(7, "Terry", 5);
        cosi.printAllReservations();
    }
}