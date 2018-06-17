package p03_Test_Client;

public class BankAccount {
    private int id;
    private double balance;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient balance");
        }
        else {
            this.balance -= amount;
        }
    }

    public void print(int Id) {
        System.out.printf("Account %s, balance %.2f", this.toString(), this.balance);
    }

    public String toString() {
        return "ID" + this.id;
    }
}
