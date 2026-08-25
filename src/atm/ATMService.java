package atm;

public class ATMService {

    // ---------- OVERLOADING: same name, different parameter lists ----------

    public void deposit(Account account, double amount) {
        account.deposit(amount);
        System.out.printf("Deposited PHP", amount);
    }

    public void deposit(Account account, double amount, String note) {
        // TODO 1: deposit the amount, then also print the note
        account.deposit(amount);
        System.out.printf("Reloaded PHP", amount, note);
    }

    // ---------- VARARGS: any number of amounts ----------

    public double depositAll(Account account, double... amounts) {
        double total = 0;
        for (double amount : amounts) {
            account.deposit(amount);
            total += amount;
        }
        return total;
    }

    // ---------- PASS-BY-VALUE: mutation vs. reassignment ----------

    public void tryToReplace(Account account) {
        account = new SavingsAccount("XX-000", "Carlo Nonot", 0, 0);
        System.out.println("Inside the method  : " + account);
        //account is a local copy siya for reference kung asa niya gi pasa ang invocation.
        //and by reassigning it here only points this local copy somewhere new.
        //caller's original variable still points to the original object.
    }

    public void addBonus(Account account, double bonus) {
        account.deposit(bonus);
        //kani na change is visible siya to the caller, even through na si java is
        //pass-by-value, because "account" still holds the same referecne as
        // the caller's varible. gi mutate niya ang object sa asa niya gi point
        //by not replacing the reference itself
    }

    // ---------- TRANSFER ----------

    public void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException {
        from.deposit(amount);
        to.withdraw(amount);
    }
}