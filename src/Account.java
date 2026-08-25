public abstract class Account {

    // TODO 1: change these three fields to private
    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double openingBalance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account Number is Required");
        }
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner Name is Required");
        }

        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
    }
    // TODO 3: write the three getters here.
    //         Remember: NO setBalance()
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        balance = balance + amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        // TODO 5: if amount <= 0     -> throw new IllegalArgumentException("...")
        //         if amount > balance -> throw new InsufficientFundsException(amount - balance)
        //         otherwise           -> balance = balance - amount;
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance = balance - amount;
    }

    public abstract String getAccountType();

    protected void applyWithdrawal(double amount) {
        balance = balance - amount;
    }

    @Override
    public String toString() {
        return getAccountType() + " " + accountNumber + " (" + ownerName + ")";
    }
}