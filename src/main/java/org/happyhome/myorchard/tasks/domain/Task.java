package org.happyhome.myorchard.tasks.domain;

import java.util.Calendar;

public class Task {
  private final String name;
  private final String description;
  private final Calendar calendar;

  public Task(String name, String description, Calendar calendar) {
    this.name = name;
    this.description = description;
    this.calendar = calendar;
  }
}
