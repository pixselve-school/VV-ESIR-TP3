package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilsTest {
  @Test
  void testBalanced() {
    assertTrue(StringUtils.isBalanced("()"));
  }

  @Test
  void testNotBalanced() {
    assertFalse(StringUtils.isBalanced(")("));
  }

  @Test
  void testBalanced2() {
    assertTrue(StringUtils.isBalanced("({[]})"));
  }

  @Test
  void testLength1() {
    assertFalse(StringUtils.isBalanced("("));
  }
}