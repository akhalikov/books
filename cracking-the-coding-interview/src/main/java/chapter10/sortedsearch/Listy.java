package chapter10.sortedsearch;

/**
 * You are given an array-like data structure Listy which lacks a size method.
 * It does, however, have an elementAt(i) method that returns the element at index i in O(1) time.
 * If it is beyond the bounds of the data structure, it returns -1.
 * (For this reason, the data structure only supports positive integers).
 *
 * Created by akhalikov on 25/02/16
 */
class Listy {
  private int[] data;

  public Listy(int...data) {
    this.data = data;
  }

  public int elementAt(int index) {
    if (index < 0 || index >= data.length)
      return -1;
    return data[index];
  }
}
