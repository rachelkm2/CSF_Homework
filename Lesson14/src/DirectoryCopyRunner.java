import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryCopyRunner {
    private static final Logger logger = Logger.getLogger(DirectoryCopyRunner.class);

    public static void main(String[] args) {
        // Configure log4j to log to console
        BasicConfigurator.configure();

        System.out.print("Enter a directory name to copy: ");
        Scanner scanner = new Scanner(System.in);
        String sourcePath = scanner.next();
        System.out.print("\nEnter a destination directory name (directory must exist): ");
        String destPath = scanner.next();

        DirectoryCopier dirCopier = new DirectoryCopier();
        AsyncDirectoryCopier async = new AsyncDirectoryCopier();

        File source = new File(sourcePath);
        File dest = new File(destPath);

        StopWatch stopWatch = new LoggingStopWatch("files");
        try {
            dirCopier.copyDirectory(source, dest);
            //async.copyDirectory(source, dest);

            logger.info("Copied " + source + " to " + dest);
        }
        catch (IOException exception) {
            logger.error("Failed to copy directory. Exception information: " + exception);
        }
        stopWatch.stop();
    }
}
