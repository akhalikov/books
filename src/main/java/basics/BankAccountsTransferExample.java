package basics;

import utils.ThreadHelper;

import java.util.Random;

/**
 * Demonstration of deadlock and how to avoid it on a classic example of banking accounts
 *
 * @author ahalikov
 */
class BankAccountsTransferExample {

    private static final Random RANDOM = new Random();
    private static final int MAX_AMOUNT = 50;

    private final Account a = new Account(1, 10000);
    private final Account b = new Account(2, 20000);

    public static void main(String[] args) {
        BankAccountsTransferExample app = new BankAccountsTransferExample();
        //app.simulateDeadLock();
        app.simulateSafeTransfer();
    }

    void simulateDeadLock() {
        Thread t1 = new Thread(() -> {
            while (true) {
                transfer(a, b, RANDOM.nextInt(MAX_AMOUNT));
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                transfer(b, a, RANDOM.nextInt(MAX_AMOUNT));
            }
        });

        ThreadHelper.clog(getInfo(a, b));
        System.out.println("------------------------------------");

        t1.start();
        t2.start();
    }

    void simulateSafeTransfer() {
        Thread t1 = new Thread(() -> {
            while (true) {
                safeTransfer(a, b, RANDOM.nextInt(MAX_AMOUNT));
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                safeTransfer(b, a, RANDOM.nextInt(MAX_AMOUNT));
            }
        });

        ThreadHelper.clog(getInfo(a, b));
        System.out.println("------------------------------------");

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
                ThreadHelper.clog(getInfo(from, to));
                ThreadHelper.sleepSeconds(1);
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
                ThreadHelper.clog(getInfo(from, to));
            }
        }
    }

    static String getInfo(Account a, Account b) {
        return a.toString() + ", " + b.toString();
    }

    static class Account implements Comparable<Account> {
        int id;
        double balance;

        public Account(int id, double balance) {
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
        public int compareTo(Account o) {
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
}
