package java_bank_system;

public interface Transaction {
	void deposit(double amount);
	void withdraw(double amount) throws InsufficientBalanceException;
}
