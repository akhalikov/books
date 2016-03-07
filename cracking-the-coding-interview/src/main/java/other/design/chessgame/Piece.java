package other.design.chessgame;

/**
 * Chess piece is one of the following:
 *  King, Queen, Knight, Bishop, Rook, Pawn
 *
 * Created by akhalikov on 06/03/16
 */
public abstract class Piece {
  public enum Type {
    King,
    Queen,
    Knight,
    Bishop,
    Rook,
    Pawn
  }

  protected Type type;

  public abstract boolean isMoveValid(Move move, Spot[][] board);

  public Type getType() {
    return type;
  }
}
