package java_bank_system;

public class CurrentAccount extends Account implements Transaction {
	public CurrentAccount(int accNumber,String accHolderName,double balance) {
		super(accNumber,accHolderName,balance);
	}
	public void deposit(double amount) {
		balance+=amount;
	}
	public void withdraw(double amount) throws InsufficientBalanceException{
		if(amount<=balance) {
			balance-=amount;
		}
		else {
			throw new InsufficientBalanceException("Cannot withdraw! due to Insufficient balance in your Current Account");
		}	
	}
	public void displayDetails() {
		System.out.println("Current Account");
		System.out.println("Account Number:"+accNumber);
		System.out.println("Account Holder Name:"+accHolderName);
		System.out.println("Account Balance:"+balance);
	}
}
