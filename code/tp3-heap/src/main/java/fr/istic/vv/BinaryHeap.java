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

  protected ArrayList<T> heap;
  private final Comparator<T> comparator;

  public BinaryHeap(Comparator<T> comparator) {
    this.comparator = comparator;
    this.heap = new ArrayList<T>();
  }

  /**
   * returns and removes the minimum object in the heap. If the heap is empty it throws a NotSuchElementException
   *
   * @return the minimum object in the heap
   */
  public T pop() {
    if (this.count() == 0) {
      throw new java.util.NoSuchElementException();
    }
    // Replace the root of the heap with the last element on the last level.
    T min = this.heap.get(0);
    this.heap.set(0, this.heap.get(this.count() - 1));
    this.heap.remove(this.count() - 1);
    // Compare the new root with its children; if they are in the correct order, stop.
    // Otherwise, swap the root with the smallest child and repeat the process.
    int i = 0;
    while (i < this.count()) {
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      int smallest = i;
      if (left < this.count() && this.comparator.compare(this.heap.get(left), this.heap.get(smallest)) < 0) {
        smallest = left;
      }
      if (right < this.count() && this.comparator.compare(this.heap.get(right), this.heap.get(smallest)) < 0) {
        smallest = right;
      }
      if (smallest != i) {
        T tmp = this.heap.get(i);
        this.heap.set(i, this.heap.get(smallest));
        this.heap.set(smallest, tmp);
        i = smallest;
      } else {
        break;
      }
    }
    return min;
  }

  /**
   * peek similar to pop, returns the minimum object but it does not remove it from the BinaryHeap
   *
   * @return the minimum object
   */
  public T peek() {
    if (this.count() == 0) {
      throw new java.util.NoSuchElementException();
    }
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
   * returns the number of elements in the BinaryHeap
   *
   * @return the number of elements in the BinaryHeap
   */
  public int count() {
    return heap.size();
  }

}