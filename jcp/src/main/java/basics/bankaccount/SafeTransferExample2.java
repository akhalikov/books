package basics.bankaccount;

import utils.ThreadHelper;

import java.util.Random;

/**
 * Demonstration of deadlock and how to avoid it on a classic example of banking accounts
 *
 * @author ahalikov
 */
class SafeTransferExample2 {
    static final Random rand = new Random();
    static final int MAX_TRANSFER_AMOUNT = 100;

    public static void main(String[] args) {
        final Transfer transfer = new TryLockTransfer();
        final BankAccount a = new BankAccount(1, 1000);
        final BankAccount b = new BankAccount(2, 2000);

        Thread t1 = new Thread(() -> {
            while (true) {
                transfer.execute(a, b, rand.nextInt(MAX_TRANSFER_AMOUNT));
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                transfer.execute(b, a, rand.nextInt(MAX_TRANSFER_AMOUNT));
            }
        });

        ThreadHelper.clog(Transfer.getInfo(a, b));
        System.out.println("------------------------------------");

        t1.start();
        t2.start();
    }
}
