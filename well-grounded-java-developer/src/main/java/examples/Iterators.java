package examples;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Iterators {
  public static void main(String[] args) {
    List<Integer> integers = new ArrayList<>();
    integers.add(101);
    integers.add(102);

    System.out.println("iterator #1");
    ListIterator<Integer> iterator = integers.listIterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      iterator.add(103);
    }

    System.out.println("iterator #2");
    iterator = integers.listIterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
