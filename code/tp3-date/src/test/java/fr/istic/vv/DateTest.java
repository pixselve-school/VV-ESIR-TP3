package fr.istic.vv;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

  @Nested
  @DisplayName("Test for the method isValidDate")
  class IsValidDate {
    @Test
    void isValidDate_february_leap() {
      assertTrue(Date.isValidDate(29, 2, 2020));
      assertFalse(Date.isValidDate(30, 2, 2020));
      assertFalse(Date.isValidDate(29, 2, 2019));

    }

    @Test
    void isValidDate_february_not_leap() {
      assertTrue(Date.isValidDate(28, 2, 2019));
      assertFalse(Date.isValidDate(29, 2, 2019));
    }

    @Test
    void isValidDate_days_in_30_months() {
      assertTrue(Date.isValidDate(30, 4, 2019));
      assertTrue(Date.isValidDate(30, 6, 2019));
      assertTrue(Date.isValidDate(30, 9, 2019));
      assertTrue(Date.isValidDate(30, 11, 2019));

      assertFalse(Date.isValidDate(31, 4, 2019));
      assertFalse(Date.isValidDate(31, 6, 2019));
      assertFalse(Date.isValidDate(31, 9, 2019));
      assertFalse(Date.isValidDate(31, 11, 2019));

      assertFalse(Date.isValidDate(0, 4, 2019));
      assertFalse(Date.isValidDate(0, 6, 2019));
      assertFalse(Date.isValidDate(0, 9, 2019));
      assertFalse(Date.isValidDate(0, 11, 2019));

    }

    @Test
    void isValidDate_days_in_31_months() {
      assertTrue(Date.isValidDate(31, 1, 2019));
      assertTrue(Date.isValidDate(31, 3, 2019));
      assertTrue(Date.isValidDate(31, 5, 2019));
      assertTrue(Date.isValidDate(31, 7, 2019));
      assertTrue(Date.isValidDate(31, 8, 2019));
      assertTrue(Date.isValidDate(31, 10, 2019));
      assertTrue(Date.isValidDate(31, 12, 2019));

      assertFalse(Date.isValidDate(32, 1, 2019));
      assertFalse(Date.isValidDate(32, 3, 2019));
      assertFalse(Date.isValidDate(32, 5, 2019));
      assertFalse(Date.isValidDate(32, 7, 2019));
      assertFalse(Date.isValidDate(32, 8, 2019));
      assertFalse(Date.isValidDate(32, 10, 2019));
      assertFalse(Date.isValidDate(32, 12, 2019));

      assertFalse(Date.isValidDate(0, 1, 2019));
      assertFalse(Date.isValidDate(0, 3, 2019));
      assertFalse(Date.isValidDate(0, 5, 2019));
      assertFalse(Date.isValidDate(0, 7, 2019));
      assertFalse(Date.isValidDate(0, 8, 2019));
      assertFalse(Date.isValidDate(0, 10, 2019));
      assertFalse(Date.isValidDate(0, 12, 2019));
    }

    @Test
    void isValidDate_month() {
      assertTrue(Date.isValidDate(1, 1, 2019));
      assertTrue(Date.isValidDate(1, 12, 2019));

      assertFalse(Date.isValidDate(1, 0, 2019));
      assertFalse(Date.isValidDate(1, 13, 2019));
    }

    @Test
    void isValidDate_year() {
      assertTrue(Date.isValidDate(1, 1, 2019));
      assertTrue(Date.isValidDate(1, 1, 2020));

      assertFalse(Date.isValidDate(1, 1, 0));
      assertFalse(Date.isValidDate(1, 1, -1));
    }


  }


  @Nested
  @DisplayName("Test for the method isLeapYear")
  class IsLeapYear {
    @Test
    void isLeapYear() {
      assertTrue(Date.isLeapYear(2020));
      assertFalse(Date.isLeapYear(2019));
    }

    @Test
    void invalidYear() {
      assertFalse(Date.isLeapYear(0));
      assertFalse(Date.isLeapYear(-1));
    }
  }

  @Nested
  @DisplayName("Test for the method nextDay")
  class NextDate {
    @Test
    void february_leap() {
      Date date = new Date(28, 2, 2020);
      Date nextDay = date.nextDate();
      assertEquals(29, nextDay.getDay());
      assertEquals(2, nextDay.getMonth());
      assertEquals(2020, nextDay.getYear());
    }

    @Test
    void february_leap_jump() {
      Date date = new Date(29, 2, 2020);
      Date nextDay = date.nextDate();
      assertEquals(1, nextDay.getDay());
      assertEquals(3, nextDay.getMonth());
      assertEquals(2020, nextDay.getYear());
    }

    @Test
    void february_not_leap() {
      Date date = new Date(27, 2, 2019);
      Date nextDay = date.nextDate();
      assertEquals(28, nextDay.getDay());
      assertEquals(2, nextDay.getMonth());
      assertEquals(2019, nextDay.getYear());
    }

    @Test
    void february_not_leap_jump() {
      Date date = new Date(28, 2, 2019);
      Date nextDay = date.nextDate();
      assertEquals(1, nextDay.getDay());
      assertEquals(3, nextDay.getMonth());
      assertEquals(2019, nextDay.getYear());
    }

    @Test
    void day_in_30_months() {
      Date date = new Date(29, 4, 2019);
      Date nextDay = date.nextDate();
      assertEquals(30, nextDay.getDay());
      assertEquals(4, nextDay.getMonth());
      assertEquals(2019, nextDay.getYear());
    }

    @Test
    void day_in_30_months_jump() {
      Date date = new Date(30, 4, 2019);
      Date nextDay = date.nextDate();
      assertEquals(1, nextDay.getDay());
      assertEquals(5, nextDay.getMonth());
      assertEquals(2019, nextDay.getYear());
    }

    @Test
    void day_in_31_months() {
      Date date = new Date(30, 1, 2019);
      Date nextDay = date.nextDate();
      assertEquals(31, nextDay.getDay());
      assertEquals(1, nextDay.getMonth());
      assertEquals(2019, nextDay.getYear());
    }

    @Test
    void day_in_31_months_jump() {
      Date date = new Date(31, 1, 2019);
      Date nextDay = date.nextDate();
      assertEquals(1, nextDay.getDay());
      assertEquals(2, nextDay.getMonth());
      assertEquals(2019, nextDay.getYear());
    }

    @Test
    void month_jump() {
      Date date = new Date(30, 11, 2019);
      Date nextDay = date.nextDate();
      assertEquals(1, nextDay.getDay());
      assertEquals(12, nextDay.getMonth());
      assertEquals(2019, nextDay.getYear());
    }

    @Test
    void year() {
      Date date = new Date(31, 12, 2019);
      Date nextDay = date.nextDate();
      assertEquals(1, nextDay.getDay());
      assertEquals(1, nextDay.getMonth());
      assertEquals(2020, nextDay.getYear());
    }
  }

  @Nested
  @DisplayName("Test for the method previousDay")
  class PreviousDay {

    @Test
    void february_leap() {
      Date date = new Date(29, 2, 2020);
      Date previousDay = date.previousDate();
      assertEquals(28, previousDay.getDay());
      assertEquals(2, previousDay.getMonth());
      assertEquals(2020, previousDay.getYear());
    }

    @Test
    void february_leap_jump() {
      Date date = new Date(1, 3, 2020);
      Date previousDay = date.previousDate();
      assertEquals(29, previousDay.getDay());
      assertEquals(2, previousDay.getMonth());
      assertEquals(2020, previousDay.getYear());
    }

    @Test
    void february_not_leap() {
      Date date = new Date(28, 2, 2019);
      Date previousDay = date.previousDate();
      assertEquals(27, previousDay.getDay());
      assertEquals(2, previousDay.getMonth());
      assertEquals(2019, previousDay.getYear());
    }

    @Test
    void february_not_leap_jump() {
      Date date = new Date(1, 3, 2019);
      Date previousDay = date.previousDate();
      assertEquals(28, previousDay.getDay());
      assertEquals(2, previousDay.getMonth());
      assertEquals(2019, previousDay.getYear());
    }

    @Test
    void day_in_30_months() {
      Date date = new Date(30, 4, 2019);
      Date previousDay = date.previousDate();
      assertEquals(29, previousDay.getDay());
      assertEquals(4, previousDay.getMonth());
      assertEquals(2019, previousDay.getYear());
    }

    @Test
    void day_in_30_months_jump() {
      Date date = new Date(1, 5, 2019);
      Date previousDay = date.previousDate();
      assertEquals(30, previousDay.getDay());
      assertEquals(4, previousDay.getMonth());
      assertEquals(2019, previousDay.getYear());
    }

    @Test
    void day_in_31_months() {
      Date date = new Date(31, 1, 2019);
      Date previousDay = date.previousDate();
      assertEquals(30, previousDay.getDay());
      assertEquals(1, previousDay.getMonth());
      assertEquals(2019, previousDay.getYear());
    }

    @Test
    void day_in_31_months_jump() {
      Date date = new Date(1, 2, 2019);
      Date previousDay = date.previousDate();
      assertEquals(31, previousDay.getDay());
      assertEquals(1, previousDay.getMonth());
      assertEquals(2019, previousDay.getYear());
    }

    @Test
    void month_jump() {
      Date date = new Date(1, 12, 2019);
      Date previousDay = date.previousDate();
      assertEquals(30, previousDay.getDay());
      assertEquals(11, previousDay.getMonth());
      assertEquals(2019, previousDay.getYear());
    }

    @Test
    void year() {
      Date date = new Date(1, 1, 2020);
      Date previousDay = date.previousDate();
      assertEquals(31, previousDay.getDay());
      assertEquals(12, previousDay.getMonth());
      assertEquals(2019, previousDay.getYear());
    }
  }

  @Nested
  @DisplayName("Test for the method getDaysInMonth")
  class GetDaysInMonth {
    @Test
    void leap_february() {
      assertEquals(29, Date.getDaysInMonth(2, 2020));
    }

    @Test
    void not_leap_february() {
      assertEquals(28, Date.getDaysInMonth(2, 2019));
    }

    @Test
    void month_30_days() {
      assertEquals(30, Date.getDaysInMonth(4, 2019));
    }

    @Test
    void month_31_days() {
      assertEquals(31, Date.getDaysInMonth(1, 2019));
    }

  }

  @Nested
  @DisplayName("Test for the method compareTo")
  class CompareTo {
    @Test
    void same_date() {
      Date date = new Date(1, 1, 2020);
      Date date2 = new Date(1, 1, 2020);
      assertEquals(0, date.compareTo(date2));
    }

    @Test
    void greater() {
      Date date = new Date(1, 1, 2020);
      Date otherDate = new Date(2, 1, 2020);
      assertEquals(-1, date.compareTo(otherDate));
    }

    @Test
    void smaller() {
      Date date = new Date(1, 1, 2020);
      Date otherDate = new Date(2, 1, 2020);
      assertEquals(1, otherDate.compareTo(date));
    }
  }
}