package chapter01.strings;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class PermutationsTest {
  @Test
  public void testFind() throws Exception {
    Set<String> res = Permutations.find("abba");
    res.forEach(System.out::println);
  }
}