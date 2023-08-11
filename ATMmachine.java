import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

public class ATMmachine {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATMmachine(double initialBalance) {
        bankAccount = new BankAccount(initialBalance);
        scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void handleTransaction(int option) {
        switch (option) {
            case 1:
                System.out.println("Your balance: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter the amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    bankAccount.deposit(depositAmount);
                    System.out.println("Deposited $" + depositAmount + " successfully.");
                } else {
                    System.out.println("Invalid deposit amount.");
                }
                break;
            case 3:
                System.out.print("Enter the amount to withdraw: $");
                double withdrawAmount = scanner.nextDouble();
                if (withdrawAmount > 0) {
                    if (bankAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawn $" + withdrawAmount + " successfully.");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                } else {
                    System.out.println("Invalid withdrawal amount.");
                }
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Have a nice day!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

    public static void main(String[] args) {
        double initialBalance = 10000.0; // set any initial balance here.
        ATMmachine atmMachine = new ATMmachine(initialBalance);

        while (true) {
            atmMachine.displayOptions();
            System.out.print("Enter your choice: ");
            int option = atmMachine.scanner.nextInt();
            atmMachine.handleTransaction(option);
        }
    }
}

