package java_bank_system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import java_bank_system.Account;
import java_bank_system.CurrentAccount;
import java_bank_system.InsufficientBalanceException;
import java_bank_system.SavingAccount;
import java_bank_system.Transaction;

public class BankSystem {
    static List<Account> accountList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Show All Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Delete Account");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1 -> createAccount();
                case 2 -> showAllAccounts();
                case 3 -> searchAccount();
                case 4 -> deleteAccount();
                case 5 -> depositToAccount();
                case 6 -> {
	                	try {
	                		withdrawFromAccount();
	                }
	                catch(InsufficientBalanceException e) {
	                		System.out.println(e.getMessage());
	                }
                }
                case 7 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNumber=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name=sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance=sc.nextDouble();
        System.out.print("Account Type \n 1. Saving  2. Current");
        int type=sc.nextInt();
        Account acc=null;
        if (type==1) {
            acc=new SavingAccount(accNumber,name,balance);
        } 
        else if(type==2) {
            acc=new CurrentAccount(accNumber,name,balance);
        } 
        else {
            return;
        }
        accountList.add(acc);
    }

    static void showAllAccounts() {
        if (accountList.isEmpty()) {
            System.out.println("No accounts to display.");
            return;
        }
        for (Account acc : accountList) {
            acc.displayDetails();
        }
    }
    static void searchAccount() {
        System.out.print("Enter Account Number to search: ");
        int accNumber=sc.nextInt();
        Account acc=findAccount(accNumber);
        if(acc!=null){
            acc.displayDetails();
        } 
        else{
            System.out.println("Account not found.");
        }
    }

    static void deleteAccount() {
        System.out.print("Enter Account Number to delete: ");
        int accNumber=sc.nextInt();
        Iterator<Account> it=accountList.iterator();
        boolean removed=false;
        while (it.hasNext()) {
            Account acc = it.next();
            if (acc.accNumber==accNumber) {
                it.remove();
                removed=true;
                System.out.println("Account deleted successfully.");
                break;
            }
        }
        if(!removed){
            System.out.println("Account not found.");
        }
    }
    static void depositToAccount() {
        System.out.print("Enter Account Number: ");
        int accNumber=sc.nextInt();
        Account acc=findAccount(accNumber);
        if(acc!=null) {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            acc.deposit(amount);
        } 
        
        else{
            System.out.println("Account not found.");
        }
    }
    static void withdrawFromAccount() throws InsufficientBalanceException {
        System.out.print("Enter Account Number: ");
        int accNumber=sc.nextInt();
        Account acc=findAccount(accNumber);
        if (acc!=null) {
            System.out.print("Enter amount to withdraw: ");
            double amount=sc.nextDouble();
            acc.withdraw(amount);
        } 
        else{
            System.out.println("Account not found.");
        }
    }
    static Account findAccount(int accNumber) {
        for (Account acc:accountList) {
            if (acc.accNumber==accNumber) {
                return acc;
            }
        }
        return null;
    }
}