package chapter10;

import static chapter10.FindDuplicates.printDuplicates;
import static chapter10.FindDuplicates.printDuplicates2;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindDuplicatesTest {
  @Test
  public void testPrintDuplicates() throws Exception {
    System.out.println("testPrintDuplicates");
    int[] arr = {1, 1, 23, 1, 5, 31999, 34, 10, 10, 11, 1, 54, 2, 6, 88, 7};
    printDuplicates(arr);
  }

  @Test
  public void testPrintDuplicates2() throws Exception {
    System.out.println("testPrintDuplicates2");
    int[] arr = {1, 1, 23, 1, 5, 31999, 34, 10, 10, 11, 1, 54, 2, 6, 88, 7};
    printDuplicates2(arr);
  }
}