import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rachelmann on 12/15/13.
 */
public class CSFStudents {

    public static ArrayList<String> createStudentArrayList() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many students do you want to enter?: ");
        int total = scanner.nextInt();

        if (total < 2){
            System.out.println("Please enter at least two students.  Try again.");
            System.exit(0);
        }

        ArrayList<String> array = new ArrayList<String>();

        for(int i = 0; i < total; i++){
            System.out.println("Enter a student: ");
            String student = scanner.next();
            array.add(student);
        }

        return array;
    }

}
