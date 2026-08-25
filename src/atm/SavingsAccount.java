package atm;

public class SavingsAccount extends Account {

    public static final double MAINTAINING_BALANCE = 500.0;

    private double interestRate; // example: 0.02 means 2% per year

    public SavingsAccount(String accountNumber, String ownerName,
                          double openingBalance, double interestRate) {
        super(accountNumber, ownerName, openingBalance);
        this.interestRate = interestRate;
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // TODO 3: compute what the balance WOULD become:
        //   double remaining = getBalance() - amount;
        // If remaining < MAINTAINING_BALANCE, throw a new
        // InsufficientFundsException with the shortfall as the argument.
        // Otherwise reuse the parent logic:
        //   super.withdraw(amount);
        double remaining = getBalance() - amount;
        if (remaining < MAINTAINING_BALANCE) {
            throw new InsufficientFundsException(MAINTAINING_BALANCE - amount);
        }
        super.withdraw(amount);
    }

    public double monthlyInterest() {
        // TODO 4: return getBalance() * interestRate / 12;
        return getBalance() * interestRate / 12;
    }
}