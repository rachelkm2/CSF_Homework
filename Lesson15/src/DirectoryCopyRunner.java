import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ruddtaylor
 * Date: 6/1/13
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class DirectoryCopyRunner {
    public static void main(String[] args) {
        System.out.print("Enter a directory name to copy: ");
        Scanner scanner = new Scanner(System.in);
        String sourcePath = scanner.next();
        System.out.print("\nEnter a destination directory name: ");
        String destPath = scanner.next();

        AsyncDirectoryCopier dirCopier = new AsyncDirectoryCopier();
        //DirectoryCopier dirCopier = new DirectoryCopier();

        File source = new File(sourcePath);
        File dest = new File(destPath);
        try {
            dirCopier.copyDirectory(source, dest);
        }
        catch (IOException exception) {
            System.out.println("Failed to copy directory. Exception information: " + exception);
        }
    }
}
