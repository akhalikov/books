package other.design.chessgame;

import java.util.Collection;

/**
 * A Player is a collection of pieces
 *
 * When making a move a Player chooses a Piece
 *  Depending on type of piece, the Player checks valid moves.
 *  Which means that validity of move is:
 *    - tightly coupled to type of piece
 *    - is a property of piece
 *
 * When thinking about valid moves, the player is aware of
 * the board location of all the pieces on the board.
 *
 * Created by akhalikov on 07/03/16
 */
public class Player {
  public enum Color {
    White,
    Black
  }

  private Color color;
  private Collection<Piece> pieces;

  public Player(Color color) {
    this.color = color;
  }

  public Move playTurn() {
    return null;
  }
}
