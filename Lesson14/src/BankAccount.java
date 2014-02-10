import org.apache.log4j.Logger;

/**
 * A thread-safe Bank Account class.
 */

public class BankAccount {
	// Note we marked the balance as volatile to be safe.
	private volatile float balance;
	int custID;
	
	private static final Logger logger = Logger.getLogger(BankAccount.class);
	

	public BankAccount(int customerID, float startingBalance) {
		custID = customerID;
		balance = startingBalance;
	}

	public float getBalance() {
		logger.info("Balance inquiry for account " + custID + " is " + balance);
		return balance;
	}

	public int getCustomerID() {
		return custID;
	}

	public synchronized boolean withdraw(float amount) {
		if (amount > balance ) {
			logger.error("Account for customer ID " + custID + " overdrawn.");
			return false;
		}
		
		logger.info("Withdrew " + amount + " from account " + custID);
		balance -= amount;
		return true;
	}
	

	public synchronized void deposit(float amount) {
		balance += amount;
		logger.info("Deposited " + amount + " to account " + custID);
	}
	

	private static boolean transferUnsafe(BankAccount from, BankAccount to, float amount) {
		if (from.withdraw(amount)) {
			to.deposit(amount);
			return true;
		}
		logger.error("Transfer failed between accounts " + from.getCustomerID() + " and " + to.getCustomerID());
		return false;
	}

	public static boolean transfer(BankAccount from, BankAccount to, float amount) {
		// Always lock the account with the lowest customer ID first to prevent deadlocks
		
		if (from.getCustomerID() < to.getCustomerID()) {
			synchronized(from) {
				synchronized(to) {
					return transferUnsafe(from, to, amount);
				}
			}
		} else {
			synchronized(to) {
				synchronized(from) {
					return transferUnsafe(from, to, amount);
				}
			}
		}
	}
}