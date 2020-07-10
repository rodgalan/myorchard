package org.happyhome.myorchard.tasks.domain;

public class Task {
  private final Name name;
  private final Description description;
  private final TaskCalendar calendar;

  public Task(Name name, Description description, TaskCalendar calendar) {
    this.name = name;
    this.description = description;
    this.calendar = calendar;
  }
}
