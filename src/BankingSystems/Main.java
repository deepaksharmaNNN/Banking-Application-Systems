package BankingSystems;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public String name(){
        System.out.println("Enter Your Name ");
        return sc.nextLine();
    }
    public String password(){
        System.out.println("Enter your password");
        return sc.nextLine();
    }
    public double initialBalance(){
        System.out.println("Enter the amount you want to add in Your account");
        double balance = sc.nextDouble();
        sc.nextLine();  // Consume the newline character left in the buffer
        return balance;
    }
    public void performBankingOperations(Bank bankAccount) {
        System.out.println("Enter Your Password to Start Banking");
        String userPassword = password();

        if (userPassword.equals(((NoBank) bankAccount).getSecretCode())) {
            while (true) {
                System.out.println("Choose an operation:");
                System.out.println("1. Check account details");
                System.out.println("2. Check balance");
                System.out.println("3. Add money");
                System.out.println("4. Withdraw money");
                System.out.println("5. Get rate of interest");
                System.out.println("6. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Account Details:");
                        System.out.println("Account Number: " + ((NoBank) bankAccount).getAccountNumber());
                        System.out.println("Account Holder Name: " + ((NoBank) bankAccount).getAccountName());
                        System.out.println("Balance: " + ((NoBank) bankAccount).getBalance());
                        break;
                    case 2:
                        System.out.println("Checking balance...");
                        System.out.println("Balance: " + ((NoBank) bankAccount).getBalance());
                        break;
                    case 3:
                        System.out.println("Enter the amount to add:");
                        int amountToAdd = sc.nextInt();
                        System.out.println(bankAccount.addMoney(amountToAdd));
                        break;
                    case 4:
                        System.out.println("Enter the amount to withdraw:");
                        int amountToWithdraw = sc.nextInt();
                        sc.nextLine();  // Consume the newline character left in the buffer
                        String withdrawalPassword = password();
                        System.out.println(bankAccount.withdrawMoney(withdrawalPassword, amountToWithdraw));
                        break;
                    case 5:
                        System.out.println("Enter the number of years for interest calculation:");
                        int years = sc.nextInt();
                        System.out.println(bankAccount.getRateOfInterest(years));
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                }
            }
        } else {
            System.out.println("Incorrect password. Access denied.");
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Bank bankAccount = new NoBank(main.name(),main.password(),main.initialBalance());
        System.out.println("Your Bank Account has been Created !");
        System.out.println();
        System.out.println();
        main.performBankingOperations(bankAccount);

    }
}