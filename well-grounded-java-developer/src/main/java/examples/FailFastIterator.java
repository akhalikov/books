package examples;

import java.util.ArrayList;

public class FailFastIterator {

  public static void main(String[] args) {

    ArrayList<Integer> integers = new ArrayList<>();
    integers.add(1);
    integers.add(2);

    for (Integer integer : integers) {
      System.out.println(integer);

      integers.add(100);
    }
  }
}
