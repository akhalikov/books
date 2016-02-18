package careercup.chapter07.carddeck;

public abstract class Card {
  private boolean available = true;

  /**
   * Number or face that's on card
   * It is a number 2 through 10,
   *  or 11 for Jack,
   *     12 for Queen,
   *     13 for King,
   *     15 for Ace.
   */
  protected int faceValue;

  protected Suit suit;

  public Card(int faceValue, Suit suit) {
    this.faceValue = faceValue;
    this.suit = suit;
  }

  public abstract int value();
  public Suit suit() { return suit; }

  /**
   * Checks if the card is available to be given out to someone
   */
  public boolean isAvailable() {
    return available;
  }

  public void markUnavailable() {
    available = false;
  }

  public void markAvailable() {
    available = true;
  }
}
