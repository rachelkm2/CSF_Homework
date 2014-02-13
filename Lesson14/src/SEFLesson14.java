import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class SEFLesson14 {
    private static final int NUMBER_OF_COUNTERS = 100;

    public static void main(String[] args) {
        StopWatch stopWatch = new LoggingStopWatch("millions");

        //asyncMillions();
        syncMillions();

        System.out.flush();
        stopWatch.stop();
    }

    public static void asyncMillions() {
        // Create 100 threads counting to one million.

        List<Thread> threads = new ArrayList<>(NUMBER_OF_COUNTERS);
        for (int i = 0; i < NUMBER_OF_COUNTERS; i++) {
            Thread worker = new Thread(new CountToOneMillion());
            threads.add(worker);

            worker.start();
        }

        // Loop until no threads are left running.
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void syncMillions() {
        // Create 100 counters to one million
        for (int i = 0; i < NUMBER_OF_COUNTERS; i++) {
            CountToOneMillion counter = new CountToOneMillion();
            counter.run();
        }
    }
}
