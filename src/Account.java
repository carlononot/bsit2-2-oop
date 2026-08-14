//PIN: 0000

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String owner;
    private double balance;
    private String pin;
    private List<String> transactions;

    public Account(String owner, double openingBalance, String pin) {
        this.owner = owner;
        if (openingBalance < 0) {
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
        this.pin = pin;
        this.transactions = new ArrayList<>();
        transactions.add(String.format("Account opened. Balance: %.2f", this.balance));
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkPin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        balance += amount;
        System.out.printf("Deposited %.2f. New balance: %.2f%n", amount, balance);
        transactions.add(String.format("Deposit: +%.2f (Balance: %.2f)", amount, balance));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
        System.out.printf("Withdrew %.2f. New balance: %.2f%n", amount, balance);
        transactions.add(String.format("Withdraw: -%.2f (Balance: %.2f)", amount, balance));
    }

    public void printTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("----- Transaction History -----");
        for (String t : transactions) {
            System.out.println(t);
        }
        System.out.println("--------------------------------");
    }
}