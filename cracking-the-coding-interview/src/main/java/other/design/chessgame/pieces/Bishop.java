package other.design.chessgame.pieces;

import other.design.chessgame.Move;
import other.design.chessgame.Piece;
import other.design.chessgame.Spot;

/**
 * Created by akhalikov on 07/03/16
 */
public class Bishop extends Piece {
  public Bishop() {
    type = Type.Bishop;
  }

  @Override
  public boolean isMoveValid(Move move, Spot[][] board) {
    return false;
  }
}
