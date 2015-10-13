package basics.bankaccount;

import com.ahalikov.toolkit.threads.ThreadHelper;

/**
 * Transfer class that exposes dead lock
 *
 * @author ahalikov
 */
class DeadlockTransfer implements Transfer {

    @Override
    public void execute(BankAccount from, BankAccount to, double amount) {
        synchronized (from) {
            synchronized (to) {
                from.withdraw(amount);
                to.deposit(amount);

                ThreadHelper.clog(Transfer.getInfo(from, to));
                ThreadHelper.sleepSeconds(1);
            }
        }
    }
}