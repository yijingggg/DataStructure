public class tuto1_Q5 {
    public static void main(String[] args) {

        BankAccount user = new BankAccount(1000);
        System.out.println(user.deposit(100));
        System.out.println(user.withdraw(20));
        System.out.println(user.getBalance());
    }
}

interface Account{
    public abstract  double deposit(double amount);
    public abstract  boolean withdraw(double amount);

}

class BankAccount implements Account{
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        return balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}