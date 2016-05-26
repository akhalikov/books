package basics.bankaccount;

/**
 * Money transfer interface
 *
 * @author ahalikov
 */
interface Transfer {

  void execute(BankAccount from, BankAccount to, double amount);

  static String getInfo(BankAccount a, BankAccount b) {
    return a.toString() + ", " + b.toString();
  }
}
