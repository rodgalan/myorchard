package org.happyhome.myorchard.tasks.domain;

import java.util.UUID;

public class Task {
  private final Name name;
  private final Description description;
  private final TaskCalendar calendar;
  private final UUID uuid;

  public Task(Name name, Description description, TaskCalendar calendar) {
    this.name = name;
    this.description = description;
    this.calendar = calendar;
    this.uuid = UUID.randomUUID();
  }

  public UUID getUid() {
    return uuid;
  }
}
