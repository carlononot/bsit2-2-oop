package atm;
public class CheckingAccount extends Account {

    private double overdraftLimit;   // example: 1000.0

    public CheckingAccount(String accountNumber, String ownerName,
                           double openingBalance, double overdraftLimit) {
        super(accountNumber, ownerName, openingBalance);
        this.overdraftLimit = overdraftLimit;
        // TODO 1: super(...) first, then store overdraftLimit
    }

    @Override
    public String getAccountType() {
        return "CHECKING";
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if ((getBalance() - amount) < -overdraftLimit) {
            throw new InsufficientFundsException(amount - (getBalance() + overdraftLimit));
        }

        applyWithdrawal(amount);
    }
}