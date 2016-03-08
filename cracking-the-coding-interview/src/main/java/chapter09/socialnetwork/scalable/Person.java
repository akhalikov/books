package chapter09.socialnetwork.scalable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhalikov on 03/03/16
 */
public class Person {
  private List<Integer> friends = new ArrayList<>();
  private int personId;
  private String info;

  public Person(int personId) {
    this.personId = personId;
  }

  public List<Integer> getFriends() {
    return friends;
  }

  public void addFriend(int id) {
    this.friends.add(id);
  }

  public int getId() {
    return personId;
  }

  public void setId(int personId) {
    this.personId = personId;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}
