package Vityarthi_Project;

import java.util.Scanner;

class BankAccount {
    private String ownerName;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String ownerName, String accountNumber, double initialBalance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit Amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Amount
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully!");
        }
    }

    // Check Balance
    public double getBalance() {
        return balance;
    }

    // Show Account Info
    public void showDetails() {
        System.out.println("===== ACCOUNT DETAILS =====");
        System.out.println("Owner: " + ownerName);
        System.out.println("Account No: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

public class mainFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create Bank Account
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        BankAccount account = new BankAccount(name, accNo, bal);

        while (true) {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Show Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double w = sc.nextDouble();
                    account.withdraw(w);
                    break;

                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;

                case 4:
                    account.showDetails();
                    break;

                case 5:
                    System.out.println("Thank you! Goodbye.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}