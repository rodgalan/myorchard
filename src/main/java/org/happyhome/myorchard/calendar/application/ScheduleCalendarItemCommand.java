package org.happyhome.myorchard.calendar.application;

public class ScheduleCalendarItemCommand {
  private final String name;
  private final String description;
  private final long when;

  public ScheduleCalendarItemCommand(String name, String description, long when) {
    this.name = name;
    this.description = description;
    this.when = when;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public long getWhen() {
    return when;
  }
}
