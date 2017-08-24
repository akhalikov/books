package chapter07.carddeck;

public class BlackJackCard extends Card {
  public BlackJackCard(int faceValue, Suit suit) {
    super(faceValue, suit);
  }

  @Override
  public int value() {
    if (isAce())
      return 1;
    else if (isFaceCard())
      return 10;
    else
      return faceValue;
  }

  public int minValue() {
    return isAce() ? 1: value();
  }

  public int maxValue() {
    return isAce() ? 11: value();
  }

  private boolean isAce() {
    return faceValue == 1;
  }

  private boolean isFaceCard() {
    return faceValue >= 11 && faceValue <= 13;
  }
}
