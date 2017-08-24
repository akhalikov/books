package chapter08.paintfill;

import static chapter08.paintfill.PaintFill.paintFill;
import static chapter08.paintfill.Screen.createRandomScreen;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PaintFillTest {
  @Test
  public void testPaintFill() {
    Screen screen = createRandomScreen(10, 10);
    Color c = Color.Red;
    screen.changeColor(1, 1, c);
    screen.changeColor(1, 2, c);
    screen.changeColor(1, 3, c);
    screen.changeColor(1, 4, c);
    screen.changeColor(0, 1, c);
    screen.changeColor(0, 2, c);
    screen.changeColor(0, 3, c);

    System.out.println("Before fill: ");
    screen.print();

    boolean filled = paintFill(screen, 1, 1, Color.Green);
    assertTrue(filled);

    System.out.println("After fill: ");
    screen.print();
  }
}