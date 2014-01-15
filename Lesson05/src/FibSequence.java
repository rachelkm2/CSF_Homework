public class FibSequence {
    public long numberAtPosition(int n) {
        long[] fibArray = new long[n];
        if (n > 1) {
            fibArray[1] = 1;
            for (int i = 2; i < n; i++) {
                fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
            }
        }
        return fibArray[n - 1];
    }
}