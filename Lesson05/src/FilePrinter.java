import java.io.*;
import java.util.Scanner;

public class FilePrinter {

    public void printFile(String filename) throws FileNotFoundException {
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader(filename)));

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        }
        catch (FileNotFoundException exception) {
            throw exception;
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
