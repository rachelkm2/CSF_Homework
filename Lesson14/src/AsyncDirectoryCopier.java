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
     * Asynchronous file copier
     */
    private class FileCopyRunner implements Runnable {
        private File source;
        private File destination;

        /**
         * @param source      Source file. Must be an actual file.
         * @param destination Destination file.
         */
        public FileCopyRunner(File source, File destination) {
            if (!source.isFile())
                throw new IllegalArgumentException("Input file must be an actual file!");
            this.source = source;
            this.destination = destination;
        }

        public void run() {
            try {
                copyFile(this.source, this.destination);
            } catch (IOException exception) {
                System.out.println("Exception copying file: " + exception);
            }
        }

        /**
         * Copies a file from one place to another.
         * @throws IOException An exception raised while copying the file.
         */
        private void copyFile(File source, File destination) throws IOException {
            if (!destination.exists())
                destination.createNewFile();
            InputStream in = null;
            OutputStream out = null;

            try {
                in = new FileInputStream(source);
                out = new FileOutputStream(destination);

                byte[] buf = new byte[BUFFER_SIZE];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } finally {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
            }
        }
    }

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
        if (!sourceDir.isDirectory() || !destinationDir.isDirectory()) {
            throw new IllegalArgumentException("Must pass directories into copyDirectory function");
        }

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();
            }
        };

        File[] filesToCopy = sourceDir.listFiles(fileFilter);
        Thread[] threads = new Thread[filesToCopy.length];

        for (int i = 0; i < filesToCopy.length; i++) {
            File sourceFile = filesToCopy[i];
            File destinationFile = new File(destinationDir, sourceFile.getName());

            threads[i] = new Thread(new FileCopyRunner(sourceFile, destinationFile));
            threads[i].start();
        }

        // Loop until no threads are left running.
        int running = 0;
        do {
            running = 0;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    running++;
                }
            }
        } while (running > 0);
    }
}
