package other.design.chessgame;

import static other.design.chessgame.Player.*;

/**
 * Chessboard Game class defines:
 *  - one board
 *  - one black player
 *  - one white player
 *
 * Created by akhalikov on 07/03/16
 */
public class Game {
  private Player whitePlayer;
  private Player blackPlayer;

  /**
   * A board is a 8x8 array of Spots
   */
  private Spot[][] board;

  public Game() {
    whitePlayer = new Player(Color.White);
    blackPlayer = new Player(Color.Black);
    board = new Spot[8][8];
    initializeBoard();
  }

  public void play() {

  }

  private boolean validateMove() {
    return false;
  }

  private void updateBoard() {

  }

  private void checkKills() {

  }

  private void isGameOver() {

  }

  private void initializeBoard() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        board[i][j] = new Spot(i+1, j+1);
      }
    }
  }
}
