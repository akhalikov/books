package basics.bankaccount;

import com.ahalikov.toolkit.threads.ThreadHelper;

/**
 * OrderedTransfer prevents dead lock by using ordering of accounts
 *
 * @author ahalikov
 */
public class OrderedTransfer implements Transfer {

    @Override
    public void execute(BankAccount from, BankAccount to, double amount) {
        BankAccount first = from;
        BankAccount second = to;
        if (first.compareTo(second) < 0) {
            first = to;
            second = from;
        }
        synchronized (first) {
            synchronized (second) {
                from.withdraw(amount);
                to.deposit(amount);
                ThreadHelper.clog(Transfer.getInfo(from, to));
            }
        }
    }
}
