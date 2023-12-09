package BankingSystems;

import java.util.Random;

public class NoBank implements Bank{
    public long accountNumber;
    public String accountName;
    private final String secretCode;
    public double balance;
    public double minBalance;
    public static final double rateOfInterest = 8.5;

    public String getSecretCode() {
        return secretCode;
    }

    public NoBank(String accountName, String secretCode, double balance) {
        Random random = new Random();
        this.accountNumber = Long.parseLong(String.valueOf(Math.abs(random.nextLong())));
        this.accountName = accountName;
        this.secretCode = secretCode;
        this.balance = balance;
        this.minBalance = 5000.0;
    }

    public String addMoney(int money) {
        balance = balance + money;
        return "Money has been Added ! New balance is "+balance;
    }

    public String checkBalance(String password) {
        if(password.equals(this.secretCode)){
            return "The Balance is "+balance;
        }else{
            return "Wrong password !";
        }
    }

    public String withdrawMoney(String password, int money) {
        if (password.equals(this.secretCode)) {
            if (money <= (balance + minBalance)) {
                balance = balance - money;
                return "The Money has been withdrawn! New Balance is " + balance;
            } else {
                return "Insufficient funds. Withdrawal failed.";
            }
        } else {
            return "Wrong Password!";
        }
    }

    public double getRateOfInterest(int years) {
        return balance * (NoBank.rateOfInterest * years) / 100;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }
}