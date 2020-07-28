package org.happyhome.myorchard.calendar.domain;

import java.util.Calendar;
import java.util.Objects;

public class Schedule {
  private final Calendar when;

  public Schedule(long when) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(when);
    this.when = calendar;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Schedule schedule = (Schedule) o;
    return Objects.equals(when, schedule.when);
  }

}
