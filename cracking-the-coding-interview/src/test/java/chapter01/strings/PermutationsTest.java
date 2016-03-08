package chapter01.strings;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Test for {@link Permutations}
 *
 * Created by artur on 22.01.16.
 */
public class PermutationsTest {
  @Test
  public void testFind() throws Exception {
    Set<String> res = Permutations.find("abba");
    res.forEach(System.out::println);
  }
}