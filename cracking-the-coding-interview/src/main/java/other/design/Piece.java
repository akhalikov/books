package other.design;

/**
 * Chess piece is one of the following:
 *  King, Queen, Knight, Bishop, Rook, Pawn
 *
 * Created by akhalikov on 06/03/16
 */
public abstract class Piece {
  enum Type {
    King,
    Queen,
    Knight,
    Bishop,
    Rook,
    Pawn
  }

  public abstract boolean isMoveValid(Move move, Spot[][] board);
}
