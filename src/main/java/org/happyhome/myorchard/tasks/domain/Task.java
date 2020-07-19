package org.happyhome.myorchard.tasks.domain;

import org.happyhome.myorchard.shared.domain.DomainEvent;
import org.happyhome.myorchard.shared.domain.EventType;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Task {
  private final Name name;
  private final Description description;
  private final TaskCalendar calendar;
  private final UUID uuid;
  private final List<DomainEvent> domainEvents = new ArrayList<>();


  public Task(Name name, Description description, TaskCalendar calendar) {
    this.name = name;
    this.description = description;
    this.calendar = calendar;
    this.uuid = UUID.randomUUID();
    this.domainEvents.add(taskCreatedEvent());
  }

  private DomainEvent taskCreatedEvent() {
    return new DomainEvent(EventType.TaskCreated, TaskEvent.from(this));
  }

  public UUID getUid() {
    return uuid;
  }

  public List<DomainEvent> getDomainEvents() {
    return domainEvents;
  }

  public Name getName() {
    return name;
  }

  public Description getDescription() {
    return description;
  }

  public TaskCalendar getCalendar() {
    return calendar;
  }

  public UUID getUuid() {
    return uuid;
  }

  //Be careful with breaking changes, public contract
  public static class TaskEvent {
    private final String name;
    private final String description;
    private final Calendar date;
    private final String uuid;

    private TaskEvent(Name name, Description description, TaskCalendar calendar, UUID uuid) {
      this.name = name.getName();
      this.description = description.getDescription();
      this.date = calendar.getTaskCalendar();
      this.uuid = uuid.toString();
    }

    static TaskEvent from(Task task) {
      return new TaskEvent(task.getName(), task.getDescription(), task.getCalendar(), task.getUuid());
    }

    public String getName() {
      return name;
    }

    public String getDescription() {
      return description;
    }

    public Calendar getDate() {
      return date;
    }

    public String getUuid() {
      return uuid;
    }
  }

}
