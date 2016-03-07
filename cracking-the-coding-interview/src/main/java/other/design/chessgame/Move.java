package other.design.chessgame;

/**
 * Created by akhalikov on 07/03/16
 */
public class Move {

  private Spot from;
  private Spot to;
  private Piece piece;

  public Move(Spot from, Spot to, Piece piece) {
    this.from = from;
    this.to = to;
    this.piece = piece;
  }
}
