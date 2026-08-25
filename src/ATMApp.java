import java.util.Scanner;
public class ATMApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ATMService atm = new ATMService();

        // Your test account. You may change the values.
        Account account = new SavingsAccount("SA-1001", "Carlo Nonot", 5000.0, 0.02);

        boolean running = true;
        while (running) {
            printHeader(account);
            printMenu();
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(input.nextLine());

                switch (choice) {
                    case 1:
                        System.out.printf("Balance: PHP %.2f%n", account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter an amount to deposit: ");
                        double amount = Double.parseDouble(input.nextLine());
                        atm.deposit(account, amount);
                        // TODO 1: ask for an amount, then call atm.deposit(account, amount)
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = Double.parseDouble(input.nextLine());
                        account.withdraw(withdrawAmount);
                        // TODO 2: ask for an amount, then call account.withdraw(amount)
                        break;
                    case 4:
                        // TODO 3: call atm.depositAll(account, 100, 250.5, 300);
                        //         then print the total returned
                        double total = atm.depositAll(account, 100, 250.5, 300);
                        System.out.printf("Total deposited: PHP %.2f%n", total);
                        break;
                    case 5:
                        System.out.printf("Before: PHP %.2f%n", account.getBalance());
                        atm.tryToReplace(account);
                        atm.addBonus(account, 50);
                        System.out.printf(
                                "After: PHP %.2f%n", account.getBalance());
                        // TODO 4: print the balance, call atm.tryToReplace(account)
                        //         and atm.addBonus(account, 50), then print it again
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Choose 0 to 5.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Please type a number, not letters.");
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("---------------------------------");
            }
        }

        input.close();
        System.out.println("Thank you for using Liceo ATM!");
    }

    private static void printHeader(Account account) {
        System.out.println("=================================");
        System.out.println("     LICEO ATM MACHINE");
        System.out.println("=================================");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Name: " + account.getOwnerName());
        System.out.println("TYPE: SAVINGS ");
        System.out.println("Balance: " + account.getBalance());
        System.out.println("---------------------------------");
        // TODO 5: print the account number, owner, type and balance
    }
    private static void printMenu() {
        System.out.println("[1] Check Balance");
        System.out.println("[2] Deposit");
        System.out.println("[3] Withdraw");
        System.out.println("[4] Deposit Multiple Amounts");
        System.out.println("[5] Pass-by-Value Demo");
        System.out.println("[0] Exit");
    }
}