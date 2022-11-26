package fr.istic.vv;

class Date implements Comparable<Date> {
  protected int getYear() {
    return year;
  }

  protected int getMonth() {
    return month;
  }

  protected int getDay() {
    return day;
  }

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
    if (year < 1) {
      return false;
    }
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
    if (previousDay < 1) {
      previousMonth = month - 1;
      if (previousMonth < 1) {
        previousMonth = 12;
        previousYear = year - 1;
      }
      previousDay = getDaysInMonth(previousMonth, previousYear);
    }
    return new Date(previousDay, previousMonth, previousYear);
  }

  /**
   * Get the number of days in a month
   *
   * @param month the month
   * @param year  the year
   * @return the number of days in the month
   */
  protected static int getDaysInMonth(int month, int year) {
    if (month == 2) {
      return isLeapYear(year) ? 29 : 28;
    }
    if (month == 4 || month == 6 || month == 9 || month == 11) {
      return 30;
    }
    return 31;
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