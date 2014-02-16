import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.*;

import static java.nio.file.StandardOpenOption.*;

public class SEFLesson15 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Set up some data to save and restore.
		byte[] binaryData = new byte[5];
		for (byte i = 0; i < 5; i++)
		{
			binaryData[i] = i;
		}

        String text = "The quick red fox jumped over the lazy brown dogs.";
		
        unbufferedUnstreamed(Paths.get("ub-us.dat"), binaryData);
		
		bufferedStreamed(Paths.get("b-s.txt"), text);

        unbufferedStreamed(Paths.get("ub-s.dat"), binaryData);

        channel(Paths.get("b-s.txt"));

	}

    public static void unbufferedUnstreamed(Path path, byte[] data) {
        // TODO: Unbuffered and unstreamed, write data to a file then read it back completely.
        // Use the methods available on the Files class

        // Sample soln
        try {
            Files.write(path,  data);

            byte[] readData = Files.readAllBytes(path);

            for (int i = 0; i < readData.length; i++)
            {
                System.out.println(readData[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferedStreamed(Path path, String text) {
        // TODO: Buffered and streamed, write data to a file then print it out to the console.
        // Use BufferedWriter and BufferedReader, respectively.

        Charset charset = Charset.forName("US-ASCII");
        try {
            BufferedWriter writer = Files.newBufferedWriter(path, charset);
            writer.write(text, 0, text.length());
            writer.close();

            BufferedReader reader = Files.newBufferedReader(path, charset);
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void unbufferedStreamed(Path path, byte[] data) {
        // TODO: Unbuffered and streamed, write data to a file then print it out to the console.
        // Use OutputStream and InputStream, respectively.

        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(path, CREATE))) {

            out.write(data, 0, data.length);
            out.close();

            InputStream in = Files.newInputStream(path);
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(in));
            int value;
            while ((value = reader.read()) != -1)
            {
                System.out.println(value);
            }
            in.close();
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    public static void channel(Path filePath) {
        // TODO: Channel file I/O reads and writes data to the stream one buffer at a time.
        // Use SeekableByteChannel to just print the contents of the file located at filePath

        // Channel I/O
        final int BUFFER_SIZE = 5;

        try (SeekableByteChannel sbc = Files.newByteChannel(filePath)) {
            ByteBuffer buf = ByteBuffer.allocate(BUFFER_SIZE);

            while (sbc.read(buf) > 0) {
                buf.rewind();
                System.out.print(Charset.defaultCharset().decode(buf));
                buf.flip();
            }
        } catch (IOException exception) {
            System.out.println("caught exception: " + exception);
        }
    }
}
