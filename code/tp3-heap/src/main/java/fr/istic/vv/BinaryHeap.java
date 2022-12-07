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
    T min = this.heap.get(0);
    this.heap.set(0, this.heap.get(this.count() - 1));
    this.heap.remove(this.count() - 1);
    this.minHeapify(0);
    return min;
  }

  /**
   * Perform a down-heap or heapify-down operation for a max-heap
   *
   * @param index the index of the element to heapify
   */
  void minHeapify(int index) {
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    int smallest = index;

    if (left < this.count() && this.comparator.compare(this.heap.get(left), this.heap.get(smallest)) < 0) {
      smallest = left;
    }
    if (right < this.count() && this.comparator.compare(this.heap.get(right), this.heap.get(smallest)) < 0) {
      smallest = right;
    }
    if (smallest != index) {
      swap(index, smallest);
      minHeapify(smallest);
    }
  }

  /**
   * Swap two elements in the heap
   * @param i the index of the first element
   * @param j the index of the second element
   */
  void swap(int i, int j) {
    T tmp = this.heap.get(i);
    this.heap.set(i, this.heap.get(j));
    this.heap.set(j, tmp);
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
    int index = this.count() - 1;
    while (index > 0 && this.comparator.compare(this.heap.get(parent(index)), this.heap.get(index)) > 0) {
      swap(index, parent(index));
      index = parent(index);
    }


  }

  protected static int parent(int index) {
    return (index - 1) / 2;
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
