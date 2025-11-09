package Lab7;

public class BankAccount {
    private static int id = 0;
    private double balance;

    public BankAccount(){
        id++;
        this.balance = 0;
    }

    public static int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }


    public synchronized void deposit(int amount){
        this.balance += amount;
        System.out.println("Deposited 100, Balance: " + this.getBalance());
    }

    public synchronized void withdraw(int amount){
        if(amount > this.balance){
            throw new RuntimeException("Insufficient funds");
        }
        this.balance -= amount;
        System.out.println("Withdrew 100, Balance: " + this.getBalance());
    }
}
