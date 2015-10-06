package basics.bankaccount;

/**
 * BankAccount class
 *
 * @author ahalikov
 */
class BankAccount implements Comparable<BankAccount> {

    private int id;
    private double balance;

    public BankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    void withdraw(double amount) {
        if (balance > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new RuntimeException("Not enough money on account ID=" + id);
        }
    }

    void deposit(double amount) {
        balance += amount;
    }

    @Override
    public int compareTo(BankAccount o) {
        return id - o.id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
