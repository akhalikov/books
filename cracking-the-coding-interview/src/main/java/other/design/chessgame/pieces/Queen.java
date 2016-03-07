package other.design.chessgame.pieces;

import other.design.chessgame.Move;
import other.design.chessgame.Piece;
import other.design.chessgame.Spot;

/**
 * Created by akhalikov on 07/03/16
 */
public class Queen extends Piece {
  public Queen() {
    type = Type.Queen;
  }

  @Override
  public boolean isMoveValid(Move move, Spot[][] board) {
    return false;
  }
}
