public class CountToOneMillion implements Runnable {
	@Override
	public void run() {
		int sum = 0;
		for (int i = 0; i < 1E6; i++) {
			sum++;
		}
        System.out.println(sum);
	}
} 
