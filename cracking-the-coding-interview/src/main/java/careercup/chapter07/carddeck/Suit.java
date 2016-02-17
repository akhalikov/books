package careercup.chapter07.carddeck;

public enum Suit {
  Club(0), Diamind(1), Heart(2), Spade(3);

  private int value;

  Suit(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
