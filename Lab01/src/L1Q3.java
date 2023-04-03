import java.util.Date;

public class L1Q3 {
    public static void main(String[] args) {

        Account a = new Account(1122,20000);
        a.setAnnualInterestRate(4.5);
        a.withdraw(2500);
        a.deposit(3000);
        System.out.printf("ID: %d\n",a.getId());
        System.out.printf("Annual Interest Rate: %.2f%%\n",a.getAnnualInterestRate());
        System.out.printf("Monthly Interest Rate: %.2f%%\n",a.getMonthlyInterestRate());
        System.out.printf("Balance: %.2f\n",a.getBalance());
        System.out.printf("Monthly Interest: %.2f\n",a.getMonthlyInterest());
        System.out.printf("Date Created: %s\n",a.getDateCreated());
    }
}

class Account {

    private int id;
    protected double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate() / 100;
    }

    public void withdraw(double amount) {
        if (amount < balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance in account!");
        }
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount! Amount entered must be at least 0.");
        } else {
            balance += amount;
        }
    }

    public String toString() {
        return "id =" + id +
                "\nbalance =" + balance +
                "\nannualInterestRate =" + annualInterestRate +
                "\ndateCreated =" + dateCreated;

    }

}


