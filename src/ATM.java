import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account account = new Account("Carlo Cagande Nonot", 1000.0, "0000");
        System.out.print("Enter 4-digit PIN: ");
        String enteredPin = input.next();

        if (!account.checkPin(enteredPin)) {
            System.out.println("Incorrect PIN. Access denied.");
            input.close();
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("WELCOME TO CLI ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Account Holder: " + account.getOwner());
                    System.out.printf("Current Balance: %.2f%n", account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double d = input.nextDouble();
                    account.deposit(d);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double w = input.nextDouble();
                    account.withdraw(w);
                    break;
                case 4:
                    account.printTransactionHistory();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using CLI ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        input.close();
    }
}