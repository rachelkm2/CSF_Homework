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


    }

    public static void bufferedStreamed(Path path, String text) {
        // TODO: Buffered and streamed, write data to a file then print it out to the console.
        // Use BufferedWriter and BufferedReader, respectively.


    }

    public static void unbufferedStreamed(Path path, byte[] data) {
        // TODO: Unbuffered and streamed, write data to a file then print it out to the console.
        // Use OutputStream and InputStream, respectively.
    }

    public static void channel(Path filePath) {
        // TODO: Channel file I/O reads and writes data to the stream one buffer at a time.
        // Use SeekableByteChannel to just print the contents of the file located at filePath
    }
}
