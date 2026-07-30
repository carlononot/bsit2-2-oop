// Lab Activity 5
//Mini ATM (Command-Line Interface)
//Name: Carlo Cagande Nonot

import java.util.Scanner;

public class MiniATM {

    //marking account balance shared by the whole program.
    static double balance = 1000.00;

    // one Scanner for reading everything the user types.
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("         WELCOME TO THE MINI ATM");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    deposit();
                    break;
                case "2":
                    withdraw();
                    break;
                case "3":
                    checkBalance();
                    break;
                case "4":
                    running = false;
                    System.out.println("\nThank you for using the Mini ATM. Goodbye!");
                    break;
                default:
                    // Task 5: menu is already safe - switching on a String never
                    // throws for unrecognized input, it just falls to default.
                    System.out.println("\n[!] Please choose a number from 1 to 4.\n");
            }
        }
    }

    static void printMenu() {
        System.out.println("Current options:");
        System.out.println("  [1] Deposit");
        System.out.println("  [2] Withdraw");
        System.out.println("  [3] Check balance");
        System.out.println("  [4] Exit");
        System.out.print("Enter your choice: ");
    }

    static void deposit() {
        System.out.print("Enter amount to deposit: ");
        String line = input.nextLine().trim();

        try {
            double amount = Double.parseDouble(line);

            if (amount <= 0) {
                throw new InvalidAmountException("Deposit amount must be positive.");
            }

            balance += amount;
            System.out.printf("Deposited PHP %.2f. New balance: PHP %.2f%n%n", amount, balance);

        } catch (NumberFormatException e) {
            System.out.println("[!!!] Please enter a valid number.");
        } catch (InvalidAmountException e) {
            System.out.println("[!!!] " + e.getMessage());
        } finally {
            System.out.println("-- transaction finished --");
        }
    }

    // WITHDRAW
    static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        String line = input.nextLine().trim();

        try {
            double amount = Double.parseDouble(line);

            if (amount <= 0) {
                throw new InvalidAmountException("Withdrawal amount must be positive.");
            }

            if (amount > balance) {
                double shortfall = amount - balance;
                throw new InsufficientFundsException(
                        "Insufficient funds. You are short by PHP " + String.format("%.2f", shortfall) + ".",
                        shortfall);
            }

            balance -= amount;
            System.out.printf("Withdrew PHP %.2f. New balance: PHP %.2f%n%n", amount, balance);

        } catch (NumberFormatException e) {
            System.out.println("[!] Please enter a valid number.");
        } catch (InvalidAmountException | InsufficientFundsException e) {
            // Task 4: both custom exceptions get the same handling, so they
            // share one multi-catch block.
            System.out.println("[!] " + e.getMessage());
        } finally {
            System.out.println("-- transaction finished --");
        }
    }

    // CHECK BALANCE

    static void checkBalance() {
        System.out.printf("%nYour current balance is: PHP %.2f%n%n", balance);
    }
}

class InsufficientFundsException extends Exception {
    private double shortfall;

    public InsufficientFundsException(String message, double shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public double getShortfall() {
        return shortfall;
    }
}

// Thrown when a deposit or withdrawal amount is zero or negative.
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}