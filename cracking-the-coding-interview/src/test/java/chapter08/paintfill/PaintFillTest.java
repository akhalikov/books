package chapter08.paintfill;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test for {@link PaintFill}
 */
public class PaintFillTest {
  @Test
  public void testPaintFill() {
    Screen screen = Screen.createRandomScreen(10, 10);
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

    boolean filled = PaintFill.paintFill(screen, 1, 1, Color.Green);
    assertTrue(filled);

    System.out.println("After fill: ");
    screen.print();
  }
}