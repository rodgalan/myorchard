package org.happyhome.myorchard.tasks.domain;

import java.util.Calendar;
import java.util.Objects;

public class TaskCalendar{
  private final Calendar taskCalendar;

  public TaskCalendar(long date_timestamp) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(date_timestamp);
    this.taskCalendar = calendar;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TaskCalendar that = (TaskCalendar) o;
    return Objects.equals(taskCalendar, that.taskCalendar);
  }

}
