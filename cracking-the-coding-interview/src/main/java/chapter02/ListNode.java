package chapter02;

/**
 * ListNode
 *
 * Created by akhalikov on 09/03/16
 */
public class ListNode {
  int data;
  ListNode next;

  public ListNode() {
  }

  public ListNode(int data) {
    this.data = data;
  }

  public ListNode(int data, ListNode next) {
    this.data = data;
    this.next = next;
  }

  @Override
  public String toString() {
    return String.valueOf(data);
  }
}
