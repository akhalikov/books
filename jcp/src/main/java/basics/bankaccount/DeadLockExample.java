package basics.bankaccount;

import com.ahalikov.toolkit.threads.*;

import java.util.Random;

/**
 * The dead lock is from the ordering of the accounts (a,b vs b,a).
 *
 * @author ahalikov
 */
class DeadLockExample {
  static final Random rand = new Random();
  static final int MAX_AMOUNT = 50;

  public static void main(String[] args) {
    final Transfer transfer = new DeadlockTransfer();
    final BankAccount a = new BankAccount(1, 10000);
    final BankAccount b = new BankAccount(2, 20000);

    Thread t1 = new Thread(() -> {
      while (true) {
        transfer.execute(a, b, rand.nextInt(MAX_AMOUNT));
      }
    });

    Thread t2 = new Thread(() -> {
      while (true) {
        transfer.execute(b, a, rand.nextInt(MAX_AMOUNT));
      }
    });

    ThreadHelper.clog(Transfer.getInfo(a, b));
    System.out.println("------------------------------------");

    t1.start();
    t2.start();
  }
}
