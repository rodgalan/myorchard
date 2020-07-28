package org.happyhome.myorchard.calendar.domain;

public class CalendarItem {
  private final Tittle tittle;
  private final Description description;
  private final Schedule schedule;

  public CalendarItem(Tittle tittle, Description description, Schedule schedule) {
    this.tittle = tittle;
    this.description = description;
    this.schedule = schedule;
  }

}
