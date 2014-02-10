import java.util.ArrayList;
import java.util.List;
/*
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class BankWorker implements Runnable {

	private static final Logger logger = Logger.getLogger(BankWorker.class);
	
	private static final int numThreads = 10;
	
	private BankAccount account1, account2;

	public BankWorker(BankAccount testAccount1, BankAccount testAccount2) {
		account1 = testAccount1;
		account2 = testAccount2;
	}

	@Override
	public void run() {
    	account1.Withdraw(10000.0f);
    	account2.Deposit(500.0f);
    	
    	BankAccount.Transfer(account1,  account2,  15000.0f);
    	BankAccount.Transfer(account2, account1, 15000.0f);
	}

	public static void main(String[] args) {
    	BasicConfigurator.configure();
    	logger.info("Starting the bank simulator.");
    	
    	BankAccount testAccount1 = new BankAccount(1, 10000.0f);
    	BankAccount testAccount2 = new BankAccount(2, 40000.0f);
 
   		List<Thread> threads = new ArrayList<Thread>();
   		
    	for (int i = 0; i < numThreads; i++) {
    		BankWorker testBank = new BankWorker(testAccount1, testAccount2);
    		Thread worker = new Thread(testBank);
    		worker.start();
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

}      */
