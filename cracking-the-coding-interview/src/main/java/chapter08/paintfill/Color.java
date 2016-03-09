package chapter08.paintfill;

/**
 * Color enum
 *
 * Created by akhalikov on 08/03/16
 */
public enum Color {
  White(0),
  Yellow(1),
  Red(2),
  Brown(3),
  Green(4),
  Blue(5),
  Purple(6),
  Gray(7),
  Black(8);

  public final int id;

  Color(int id) {
    this.id = id;
  }

  public static Color getColorByNum(int num) {
    for (Color c: Color.values())
      if (c.id == num)
        return c;
    throw new IllegalArgumentException("No color for num=" + num);
  }
}
