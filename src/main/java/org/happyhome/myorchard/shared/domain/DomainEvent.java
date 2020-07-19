package org.happyhome.myorchard.shared.domain;

public class DomainEvent<T> {
  //TODO: This can be abstract and then have TaskCreatedEvent, ...
  //TODO: pending event UUID... assigned by ?
  protected final EventType eventType;
  protected final T message;

  public DomainEvent(EventType eventType, T message) {
    this.eventType = eventType;
    this.message = message;
  }

  public EventType getEventType() {
    return eventType;
  }

  public T getMessage() {
    return message;
  }
}
