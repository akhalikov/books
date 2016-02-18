package careercup.chapter07.carddeck;

import java.util.List;

/**
 * Design the data structures for a generic deck of cards.
 * Explain how you would subclass the data structures to implement blackjack.
 */
public class Deck<T extends Card> {
  private List<T> cards;

  // first undealt card
  private int dealtIndex = 0;

  public void shuffle() {
    // ...
  }

  public int remainingCards() {
    return cards.size() - dealtIndex;
  }

  public T[] dealtHand(int number) {
    // ...
    return null;
  }

  public T dealCard() {
    // ...
    return null;
  }
}
