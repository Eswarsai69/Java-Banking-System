package java_bank_system;

public abstract class Account {
	int accNumber;
	String accHolderName;
	double balance;
	public Account(int accNumber,String accHolderName,double balance) {
		this.accNumber=accNumber;
		this.accHolderName=accHolderName;
		this.balance=balance;
	}
	public abstract void deposit(double amount);
	public abstract void  withdraw(double amount) throws InsufficientBalanceException;
	public abstract void displayDetails();
}
