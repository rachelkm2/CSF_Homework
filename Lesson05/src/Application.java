import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.print("Enter a filename to print: ");
        String filename = console.next();
        FilePrinter example = new FilePrinter();
        try {
            example.printFile(filename);
        } catch (FileNotFoundException exception) {
            System.out.println("That file doesn't exist!");
        }
    }

}
