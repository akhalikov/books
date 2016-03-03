package other.arrays;

import com.ahalikov.toolkit.utils.ArrayUtils;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link MissedNumbers}
 */
public class MissedNumbersTest {

  static final int N1 = 20;
  static final int N2 = 10;
  static final Random random = new Random();

  @Test
  public void testFind1() throws Exception {
    System.out.println("testFind1");
    int[] a = ArrayUtils.intRange(1, N1);
    int k = random.nextInt(N1);
    int x = a[k];
    a[k] = 0;

    ArrayUtils.print(a);
    System.out.println("missed number is: " + x);
    assertEquals(x, MissedNumbers.find1(a, N1));
  }

  @Test
  public void testFind2() throws Exception {
    System.out.println("testFind2");
    int[] a = ArrayUtils.intRange(1, N2);

    int k1 = random.nextInt(N2);
    int x = a[k1];
    a[k1] = 0;

    int k2 = random.nextInt(N2);
    int y = a[k2];
    a[k2] = 0;

    ArrayUtils.print(a);
    System.out.println("missed numbers: " + x + ", " + y);

    int[] res = MissedNumbers.find2(a, N2);
    assertTrue(res[0] == x || res[0] == y);
    assertTrue(res[1] == x || res[1] == y);
    System.out.println("Found: " + res[0] + ", " + res[1]);
  }
}