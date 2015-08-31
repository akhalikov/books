package basics;

/**
 * Demonstration of deadlock and how to avoid it on a classic example of banking accounts
 *
 * @author ahalikov
 */
public class BankAccountsDeadlock {

    public static void main(String[] args) {
        final Account a = new Account(1, 1000);
        final Account b = new Account(2, 300);

        Thread t1 = new Thread(() -> transfer(a, b, 200));
        Thread t2 = new Thread(() -> transfer(b, a, 300));

        t1.start();
        t2.start();
    }

    /**
     * The dead lock is from the ordering of the accounts (a,b vs b,a).
     */
    static void transfer(Account from, Account to, double amount) {
        synchronized (from) {
            synchronized (to) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    /**
     * Sorting accounts to prevent dead lock
     */
    static void safeTransfer(Account from, Account to, double amount) {
        Account first = from;
        Account second = to;
        if (first.compareTo(second) < 0) {
            first = to;
            second = from;
        }
        synchronized (first) {
            synchronized (second) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    static class Account implements Comparable<Account> {
        int id;
        double balance;

        public Account(int id, double balance) {
            this.id = id;
            this.balance = balance;
        }

        void withdraw(double amount) {
            balance -= amount;
        }

        void deposit(double amount) {
            balance += amount;
        }

        @Override
        public int compareTo(Account o) {
            return id - o.id;
        }
    }
}
