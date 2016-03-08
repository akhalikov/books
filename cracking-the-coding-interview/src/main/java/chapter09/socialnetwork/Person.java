package chapter09.socialnetwork;

import java.util.List;

/**
 * Person class
 */
public class Person {
  private int id;
  private String name;
  private List<Integer> friends;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public List<Integer> getFriends() {
    return friends;
  }
}
