import java.util.ArrayList;
import java.util.Date;

public class L1Q4 {
    public static void main(String[] args) {
        Account1 b = new Account1(123, 1122, "Johnson");
        b.setAnnualInterestRate(1.5);
        b.deposit(30);
        b.withdraw(5);
        b.withdraw(4);
        b.deposit(40);
        b.withdraw(2);
        b.deposit(50);
        System.out.println("******* Account Summary *******");
        System.out.printf("Name: %s\n", b.getName());
        System.out.printf("ID: %d\n", b.getId());
        System.out.printf("Annual Interest Rate: %.2f%%\n", b.getAnnualInterestRate());
        System.out.printf("Monthly Interest Rate: %.2f%%\n", b.getMonthlyInterestRate());
        System.out.printf("Balance: %.2f\n", b.getBalance());
        System.out.printf("Monthly Interest: %.2f\n", b.getMonthlyInterest());
        System.out.printf("Date Created: %s\n", b.getDateCreated());
        System.out.println("Transactions: ");
        System.out.printf("%s\n", b.getTransactions());
    }
}


class Account1 extends Account {
    private String name;
    ArrayList<Transaction> transactions;

    public Account1(int id, double balance, String name) {
        super(id, balance);
        this.name = name;
        transactions = new ArrayList<Transaction>();
    }

    public String getName() {
        return name;
    }

    @Override
    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount! Amount entered must be at least 0.");
        } else if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction('W', amount, balance, "Withdraw"));
        } else {
            System.out.println("Insufficient balance in account!");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount! Amount entered must be at least 0.");
        } else {
            balance += amount;
            transactions.add(new Transaction('D', amount, balance, "Deposit"));
        }
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}

class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String description) {
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("\nDate: %s \nType: %c \nAmount: %.2f \nBalance: %.2f \nDescription: %s", date, type, amount, balance, description);
    }

}
