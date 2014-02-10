import java.io.*;

/*
 * Your assignment: The DirectoryCopier class will copy all the files in one
 * directory to another directories in series (not in parallel). Use that code
 * as a starting point and modify this class to copy files in parallel using threads.
 */
public class AsyncDirectoryCopier {
    // Sample soln
    private static final int BUFFER_SIZE = 1024;

    /**
     * Copies one directory to another directory
     * Only works with existing directories, and only copies the first level of files
     * (Does not recursively copy directory structure)
     *
     * @param sourceDir      The source directory file. Must be an existing directory.
     * @param destinationDir The destination directory file. Must be an existing directory.
     * @throws IOException An IOException raised while copying the files.
     */
    public void copyDirectory(File sourceDir, File destinationDir) throws IOException {
        // TODO: Fill in
    }
}
