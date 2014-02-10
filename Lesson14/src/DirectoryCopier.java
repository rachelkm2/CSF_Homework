import java.io.*;

public class DirectoryCopier {
    private static final int BUFFER_SIZE = 1024;

    /**
     * Copies one directory to another directory
     * Only works with existing directories, and only copies the first level of files
     * (Does not recursively copy directory structure)
     * @param sourceDir The source directory file. Must be an existing directory.
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
        for (File sourceFile : filesToCopy) {
            File destinationFile = new File(destinationDir, sourceFile.getName());
            copyFile(sourceFile, destinationFile);
        }
    }

    /**
     * Copies a file from one place to another.
     * @param source Source file. Must be an actual file.
     * @param destination Destination file.
     * @throws IOException An exception raised while copying the file.
     */
    private void copyFile(File source, File destination) throws IOException {
        if (!source.isFile())
            throw new IllegalArgumentException("Input file must be an actual file!");

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
        }
        finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }
}
