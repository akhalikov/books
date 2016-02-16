package careercup.other.sorting;

import java.util.Arrays;

/**
 * Given an array of n elements, where each element is at most k away from its target position,
 * devise an algorithm that sorts in O(n log k) time.
 *
 * For example, let us consider k is 2, an element at index 7 in the sorted array,
 * can be at indexes 5, 6, 7, 8, 9 in the given array.
 *
 * 1) Create a Min Heap of size k+1 with first k+1 elements. This will take O(k) time.
 * 2) One by one remove min element from heap, put it in result array,
 * and add a new element to heap from remaining elements.
 *
 * http://www.geeksforgeeks.org/nearly-sorted-algorithm/
 *
 * Created by akhalikov on 24/01/16
 */
public class NearlySorted {

  static void sortK(int[] a, int k) {
    if (a == null)
      throw new NullPointerException("arr is null");

    int n = a.length;
    if (n == 0)
      return;

    MinHeap minHeap = new MinHeap(a, k + 1);
    for (int i = k + 1, ti = 0; ti < n; i++, ti++) {
      if (i < n)
        a[ti] = minHeap.replaceMin(a[i]);
      else
        a[ti] = minHeap.extractMin();
    }
  }

  static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  static class MinHeap {
    int[] data;
    int size;

    MinHeap(int[] data, int size) {
      this.size = size;
      this.data = new int[size];
      for (int i = 0; i < size && i < data.length; i++)
        this.data[i] = data[i];
      buildMinHeap();
    }

    int extractMin() {
      int root = data[0];
      if (size > 1) {
        data = Arrays.copyOfRange(data, 1, size);
        size--;
        minHeapify(0);
      }
      return root;
    }

    int replaceMin(int newMin) {
      int root = data[0];
      data[0] = newMin;
      if (root < newMin)
        minHeapify(0);
      return root;
    }

    void minHeapify(int index) {
      int min = index,
        left = getLeft(index),
        right = getRight(index);

      if (left < size && data[left] < data[index])
        index = left;
      if (right < size && data[right] < data[index])
        index = right;

      if (index != min) {
        swap(data, min, index);
        minHeapify(min);
      }
    }

    private void buildMinHeap() {
      for (int i = size/2 - 1; i >= 0; i--)
        minHeapify(i);
    }

    private int getLeft(int index) {
      return index * 2 + 1;
    }

    private int getRight(int index) {
      return index * 2 + 2;
    }
  }
}