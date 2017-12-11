package examples;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeIterator {

  public static void main(String[] args) {
    ConcurrentHashMap<String, Integer> numbers = new ConcurrentHashMap<>();
    numbers.put("one", 1);
    numbers.put("two", 2);

    Iterator<String> keys = numbers.keySet().iterator();
    while (keys.hasNext()) {
      System.out.println("key=" + keys.next());
      numbers.put("three", 3);
    }
  }
}
