package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {


  @Nested
  class Push {
    @Test
    void empty() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      heap.push(1);
      assertEquals(List.of(1), heap.heap);
    }

    @Test
    void oneElement() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      heap.heap = new ArrayList<>(List.of(1));
      heap.push(2);
      assertEquals(List.of(1, 2), heap.heap);
    }

    @Test
    void twoElements() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      heap.heap = new ArrayList<>(List.of(1, 2));
      heap.push(3);
      assertEquals(List.of(1, 2, 3), heap.heap);
    }

    @Nested
    class ComparaisonElements {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      @BeforeEach
      void setUp() {
        heap.heap = new ArrayList<>(List.of(5, 12));
      }

      @Test
      void superior_max() {
        this.heap.push(50);
        assertEquals(List.of(5, 12, 50), this.heap.heap);
      }

      @Test
      void minimum_min() {
        this.heap.push(1);
        assertEquals(List.of(1, 12, 5), this.heap.heap);
      }

      @Test
      void between_min_max() {
        this.heap.push(10);
        assertEquals(List.of(5, 12, 10), this.heap.heap);
      }
    }

  }

  @Nested
  class Pop {
    @Test
    void empty() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      assertThrows(NoSuchElementException.class, heap::pop);
    }

    @Test
    void oneElement() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      heap.heap = new ArrayList<>(List.of(1));
      assertEquals(1, heap.pop());
    }

    @Test
    void twoElements() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      heap.heap = new ArrayList<>(List.of(1, 2));
      assertEquals(1, heap.pop());
      assertEquals(List.of(2), heap.heap);
    }

  }

  @Nested
  class Peek {
    @Test
    void empty() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      assertThrows(NoSuchElementException.class, heap::peek);
    }

    @Test
    void oneElement() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      heap.push(1);
      assertEquals(1, heap.peek());
      assertEquals(List.of(1), heap.heap);
    }

  }

  @Nested
  class Count {
    @Test
    void empty() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      assertEquals(0, heap.count());
    }

    @Test
    void moreThanOneElement() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      heap.push(1);
      heap.push(1);
      heap.push(1);
      heap.push(1);
      heap.push(1);
      heap.push(1);
      assertEquals(6, heap.count());
    }
  }

  @Nested
  class Swap {
    @Test
    void empty() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      assertThrows(IndexOutOfBoundsException.class, () -> {
        heap.swap(50, 50);
      });
    }

    @Test
    void twoElements() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      heap.heap = new ArrayList<>(List.of(1, 2));
      heap.swap(0, 1);
      assertEquals(List.of(2, 1), heap.heap);
    }
  }

  @Nested
  class MinHeapify {

    @Test
    void alreadyGood() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      heap.heap = new ArrayList<>(List.of(1, 3, 6));
      heap.minHeapify(0);
      assertEquals(List.of(1, 3, 6), heap.heap);
    }

    @Test
    void leftSmaller() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      heap.heap = new ArrayList<>(List.of(3, 6, 1));
      heap.minHeapify(0);
      assertEquals(List.of(1, 6, 3), heap.heap);
    }

    @Test
    void rightSmaller() {
      BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
      heap.heap = new ArrayList<>(List.of(6, 1, 3));
      heap.minHeapify(0);
      assertEquals(List.of(1, 6, 3), heap.heap);
    }
  }
}