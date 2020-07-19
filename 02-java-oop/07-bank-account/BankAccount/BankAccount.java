package BankAccount;
public class BankAccount{

    protected String accountNumber;
    protected double checkingBalance;
    protected double savingsBalance;
    public static int numberOfAccounts = 0;
    public static double totalMoney = 0;

    public BankAccount(){
        accountNumber = randomAccount();
        numberOfAccounts++;
    }

    public static int totalAccounts(){
        return numberOfAccounts;
    }

    public void displayCash(){
        System.out.println("Total Amount In All Accounts: " + (savingsBalance + checkingBalance));
    }

    private static String randomAccount(){
        StringBuilder account = new StringBuilder(10);
        String accountNums = "0123456789";
        for (int i = 0; i < 10; i++){
            int nums = (int)(accountNums.length() * Math.random());
            account.append(accountNums.charAt(nums));
        }
        String builtAccount = String.valueOf(account.toString());
        return builtAccount;
    }

    public void setChecking(double checking){
        this.checkingBalance = checking;
    }

    public double getChecking(){
        return this.checkingBalance;
    }

    public void setSavings(double savings){
        this.savingsBalance = savings;
    }

    public double getSavings(){
        return this.savingsBalance;
    }

    public void depositeMoney(String accountNum, double money){
        if (accountNum.equals("Checking")){
                System.out.println(money + " Deposited To Checking Account");
                checkingBalance += money;
            }
        if (accountNum.equals("Savings")){
            System.out.println(money + " Deposited To Savings Account");
            savingsBalance += money;
            }
        }

    public void withdrawMoney(String accountNum, double money){
        if (accountNum.equals("Checking")){
            if (checkingBalance - money >= 0){
                System.out.println(money + " Withdraw From Checking");
                checkingBalance -= money;
            }else{
                    System.out.println("Checking Account Has Insufficent Funds ");
            }
        }
        if (accountNum.equals("Savings")){
            if (savingsBalance - money >= 0){
                System.out.println(money + " Withdraw From Savings");
                savingsBalance -= money;
            }else{
                    System.out.println("Savings Account Has Insufficent Funds ");
            }
        }
    }
}
