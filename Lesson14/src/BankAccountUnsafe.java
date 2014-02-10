public class BankAccountUnsafe {
	private float balance;

	public BankAccountUnsafe(float initialBalance) {
		balance = initialBalance;
	}
	
	public void withdraw(float amount) {
		balance -= amount;
	}
	
	public void deposit(float amount) {
		balance += amount;
	}
	
	public static void Transfer(BankAccountUnsafe fromAccount, BankAccountUnsafe toAccount, float amount) {
		synchronized(fromAccount) {
			synchronized(toAccount) {
				fromAccount.withdraw(amount);
				toAccount.deposit(amount);
			}
		}
	}
}