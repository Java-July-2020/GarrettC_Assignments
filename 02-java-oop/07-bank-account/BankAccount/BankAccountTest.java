package BankAccount;

public class BankAccountTest {
    public static void main(String[] args) {

        BankAccount newAccount = new BankAccount();
        System.out.println(newAccount.accountNumber);

        newAccount.depositeMoney("Checking", 100.0);
        System.out.println(newAccount.getChecking());

        newAccount.withdrawMoney("Checking", 50.0);
        System.out.println(newAccount.getChecking());

        newAccount.withdrawMoney("Checking", 70.0);
        System.out.println(newAccount.getChecking());

        newAccount.depositeMoney("Savings", 400.0);
        System.out.println(newAccount.getSavings());

        newAccount.withdrawMoney("Savings", 100.0);
        System.out.println(newAccount.getSavings());

        newAccount.withdrawMoney("Savings", 500.0);
        System.out.println(newAccount.getSavings());

        newAccount.displayCash();
    }
}