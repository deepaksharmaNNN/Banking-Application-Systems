package BankingSystems;

public interface Bank {
    public String addMoney(int money);
    public  String checkBalance(String password);
    public  String withdrawMoney(String password, int money);
    public double getRateOfInterest(int years);
}
