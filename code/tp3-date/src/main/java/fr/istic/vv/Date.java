package fr.istic.vv;

class Date implements Comparable<Date> {
  private final int year;
  private final int month;
  private final int day;

  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public static boolean isValidDate(int day, int month, int year) {
    if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31) {
      return false;
    }
    if (month == 2) {
      if (day > 29) {
        return false;
      }
      if (day == 29 && !isLeapYear(year)) {
        return false;
      }
    }
    if (month == 4 || month == 6 || month == 9 || month == 11) {
      return day != 31;
    }
    return true;
  }

  public static boolean isLeapYear(int year) {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
  }

  public Date nextDate() {
    int nextDay = day + 1;
    int nextMonth = month;
    int nextYear = year;
    if (!isValidDate(nextDay, nextMonth, nextYear)) {
      nextDay = 1;
      nextMonth = month + 1;
      if (!isValidDate(nextDay, nextMonth, nextYear)) {
        nextMonth = 1;
        nextYear = year + 1;
      }
    }
    return new Date(nextDay, nextMonth, nextYear);
  }

  public Date previousDate() {
    int previousDay = day - 1;
    int previousMonth = month;
    int previousYear = year;
    if (!isValidDate(previousDay, previousMonth, previousYear)) {
      previousMonth = month - 1;
      if (!isValidDate(previousDay, previousMonth, previousYear)) {
        previousMonth = 12;
        previousYear = year - 1;
      }
      previousDay = 31;
    }
    return new Date(previousDay, previousMonth, previousYear);
  }

  public int compareTo(Date other) {
    if (year != other.year) {
      return year - other.year;
    }
    if (month != other.month) {
      return month - other.month;
    }
    return day - other.day;
  }

}