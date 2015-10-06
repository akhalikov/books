package basics.bankaccount;

import utils.ThreadHelper;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Safe transfer using try-lock idiom
 *
 * @author ahalikov
 */
public class TryLockTransfer implements Transfer {
    static final Random RANDOM = new Random();
    static final int LOCK_TIME = 100;
    static final int DELAY_MILLIS = 200;

    private final Lock fromLock = new ReentrantLock();
    private final Lock toLock = new ReentrantLock();

    @Override
    public void execute(BankAccount from, BankAccount to, double amount) {
        try {
            if (fromLock.tryLock(lockTime(), TimeUnit.MILLISECONDS)) {
                try {
                    if (toLock.tryLock(lockTime(), TimeUnit.MILLISECONDS)) {
                        try {
                            from.withdraw(amount);
                            to.deposit(amount);

                            ThreadHelper.clog(Transfer.getInfo(from, to));
                            ThreadHelper.sleepMillis(DELAY_MILLIS);
                        } finally {
                            toLock.unlock();
                        }
                    }
                } finally {
                    fromLock.unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static int lockTime() {
        return RANDOM.nextInt(LOCK_TIME) + LOCK_TIME;
    }
}
