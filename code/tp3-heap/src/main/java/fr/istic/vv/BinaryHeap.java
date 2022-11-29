package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * A <a href="https://en.wikipedia.org/wiki/Binary_heap">*binary heap*</a> is a data structure that contains comparable objects and it is able to efficiently return the lowest element.
 * This data structure relies on a binary tree to keep the insertion and deletion operations efficient. It is the base of the <a href="https://en.wikipedia.org/wiki/Heapsort">*Heapsort* algorithm</a>.
 *
 * @param <T>
 */
class BinaryHeap<T> {

  private ArrayList<T> heap;
  private Comparator<T> comparator;

  public BinaryHeap(Comparator<T> comparator) {
    this.comparator = comparator;
    this.heap = new ArrayList<T>();
  }

  /**
   * pop returns and removes the minimum object in the heap. If the heap is empty it throws a NotSuchElementException
   *
   * @return
   */
  public T pop() {
    return null;
  }

  /**
   * peek similar to pop, returns the minimum object but it does not remove it from the BinaryHeap
   *
   * @return
   */
  public T peek() {
    return heap.get(0);
  }

  /**
   * Adds an element to the BinaryHeap
   *
   * @param element the element to add
   */
  public void push(T element) {
    // Add the element to the bottom level of the heap at the leftmost open space.
    heap.add(element);
    // Compare the added element with its parent; if they are in the correct order, stop.
    // If not, swap the element with its parent and return to the previous step.
    int index = heap.size() - 1;
    while (index > 0) {
      int parentIndex = (index - 1) / 2;
      if (comparator.compare(heap.get(index), heap.get(parentIndex)) >= 0) {
        break;
      }
      T tmp = heap.get(index);
      heap.set(index, heap.get(parentIndex));
      heap.set(parentIndex, tmp);
      index = parentIndex;
    }
  }

  /**
   * count returns the number of elements in the BinaryHeap
   *
   * @return
   */
  public int count() {
    return 0;
  }

}