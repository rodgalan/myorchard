package org.happyhome.myorchard.tasks.application;

import org.happyhome.myorchard.shared.domain.DomainEvent;
import org.happyhome.myorchard.shared.infrastructure.EventConsumer;

import java.util.ArrayList;
import java.util.List;

public class EventConsumerForTest implements EventConsumer {

  public List<DomainEvent> domainEvents = new ArrayList<>();

  @Override
  public void consume(DomainEvent domainEvent) {
    this.domainEvents.add(domainEvent);
  }
}
