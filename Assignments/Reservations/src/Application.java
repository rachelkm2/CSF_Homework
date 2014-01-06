import com.sun.org.apache.xpath.internal.operations.Bool;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static Scanner scanner = new Scanner(System.in);
    public static String invalidMessage = new String();

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Boolean keepTrying = true;

        Boolean addReservation = true;
        String resName = new String();
        int resNumber = 0;
        int resTime = 0;
        String resDetails = new String();

        //Create the restaurant
        Restaurant restaurant = createRestaurant();

        //Add reservations
        keepTrying = true;
        System.out.print("Would you like to enter reservations? Enter 'Yes' or 'No': ");
        String yesNo = scanner.next();
        if (yesNo.equals("Yes")){
            addReservation = true;
            while (addReservation == true) {

                restaurant.addReservation(takeReservation(restaurant));
                System.out.print("Add another reservation? Enter 'Yes' or 'No': ");
                String add = scanner.next();
                if (add.equals("Yes")) {
                    addReservation = true;
                    keepTrying = true;
                } else {
                    addReservation = false;
                    keepTrying = false;
                }
            }
        }

        System.out.print("Would you like to print reservations: ");
        yesNo = scanner.next();
        if (yesNo.equals("Yes")){
            //Print reservations
            for (int i = 0; i < restaurant.restReservations.size(); i++){
                resName = restaurant.restReservations.get(i).getReserveName();
                resTime = restaurant.restReservations.get(i).getReserveTime();
                resNumber = restaurant.restReservations.get(i).getReserveNumber();
                resDetails = "Name: " +resName + "; Time: " +resTime + "; Number: " +resNumber;
                System.out.println(resDetails);
            }
        }

    }

    public static int checkCapacity (Restaurant restaurant, int resTime){

        int resCheckTime = 0;
        int sum = 0;

        for (int i = 0; i < restaurant.restReservations.size(); i++){
          resCheckTime = restaurant.restReservations.get(i).getReserveTime();
            if ( resCheckTime == resTime){
                sum = sum + restaurant.restReservations.get(i).getReserveNumber();
            }
        }

        return sum;
    }


    public static Restaurant createRestaurant(){

        Boolean keepTrying = true;
        String name = new String();
        int capacity = 0;
        int open = 0;
        int close = 0;

        Restaurant restaurant = new Restaurant();


        while (keepTrying == true){
            try {
                System.out.print("Restaurant Name: ");
                name = scanner.next();

                System.out.print("Restaurant Capacity: ");
                if (scanner.hasNextInt()){
                    capacity = scanner.nextInt();
                } else {
                    scanner.next();
                    invalidMessage = "You must enter a valid integer.";
                    testEntry(invalidMessage);
                }

                System.out.print("Restaurant Open: ");
                if (scanner.hasNextInt()){
                    open = scanner.nextInt();
                    if (open < 1 || open > 12) {
                        invalidMessage = "Your restaurant cannot open before 1 or after 12.";
                        testEntry(invalidMessage);
                    }
                } else {
                    scanner.next();
                    invalidMessage = "You must enter a valid integer. ";
                    testEntry(invalidMessage);
                }

                System.out.print("Restaurant Close: ");
                if (scanner.hasNextInt()){
                    close = scanner.nextInt();
                    if (close < 3 || close > 12) {
                        invalidMessage = "Your restaurant cannot close before 2 or after 12.";
                        testEntry(invalidMessage);
                    } else if (close <= open) {
                        invalidMessage = "Your restaurant must close after it opens.";
                        testEntry(invalidMessage);
                    }
                } else {
                    scanner.next();
                    invalidMessage = "You must enter a valid integer.";
                    testEntry(invalidMessage);
                }

                keepTrying = false;

            } catch (MyAppException mae) {
                System.out.println(mae.getMessage());
                System.out.println("Try Again?: ");
                if (scanner.next() == "Yes"){
                    keepTrying = true;
                } else keepTrying = false;
            }
        }

        Restaurant newRestaurant;
        newRestaurant = new Restaurant(name, capacity, open, close);
        return newRestaurant;
    }

    public static Reservation takeReservation(Restaurant restaurant){

        Reservation newReservation = new Reservation();
        String type = new String();
        String name = new String();
        int number = 0;
        int time = 0;

        boolean keepTrying = true;

        while (keepTrying == true){
            try {
                System.out.print("Enter Reservation Type: 'Phone', 'Internet' or 'In-Person': ");
                type = scanner.next();
                if (type.equals("Phone") || type.equals("Internet") || type.equals("In-Person")) {
                    invalidMessage = null;
                } else {
                    invalidMessage = "You entered an invalid type.";
                    testEntry(invalidMessage);
                }
                System.out.print("Enter Name: ");
                name = scanner.next();

                System.out.print("Enter Number of Guests: ");
                if (scanner.hasNextInt()){
                    number = scanner.nextInt();
                } else {
                    scanner.next();
                    invalidMessage = "You must enter a valid integer.";
                    testEntry(invalidMessage);
                }

                System.out.print("Enter Reservation Time: ");
                if (scanner.hasNextInt()){
                    time = scanner.nextInt();
                } else {
                    scanner.next();
                    invalidMessage = "You must enter a valid integer.";
                    testEntry(invalidMessage);
                }

                int fullness = checkCapacity(restaurant, time);
                int restCapacity = restaurant.getRestCapacity();

                if ((restCapacity - fullness) >= number){
                    keepTrying = false;
                    newReservation = new Reservation(name, time, number);
                } else {
                    invalidMessage = "Your reservation exceeds capacity for that time";
                    testEntry(invalidMessage);
                }

            } catch (MyAppException mae) {
                System.out.println(mae.getMessage());
                System.out.println("Try Again?: ");
                if (scanner.next() == "Yes"){
                    keepTrying = true;
                } else keepTrying = false;
            }
       }

        return newReservation;

/*        Reservation newReservation;
        newReservation = new Reservation(name, time, number);
        return newReservation;
        */
    }


    public static void testEntry(String invalidMessage) throws MyAppException{
        if (invalidMessage != null)
        throw new MyAppException(invalidMessage);
    }


}