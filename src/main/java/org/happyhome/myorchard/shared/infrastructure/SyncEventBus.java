package org.happyhome.myorchard.shared.infrastructure;

import org.happyhome.myorchard.shared.domain.DomainEvent;
import org.happyhome.myorchard.shared.domain.EventBus;
import org.happyhome.myorchard.shared.domain.EventType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SyncEventBus implements EventBus {
  private final ConcurrentHashMap<EventType, List<EventConsumer>> consumers;

  public SyncEventBus() {
    this.consumers = new ConcurrentHashMap<>();
  }

  @Override
  public void publish(DomainEvent domainEvent) {
    List<EventConsumer> eventConsumers = consumers.get(domainEvent.getEventType());
    if (eventConsumers != null) {
      eventConsumers.forEach(consumer -> consumer.consume(SerializedDomainEvent.serializeFrom(domainEvent)));
    }
  }

  @Override
  public void subscribe(EventType eventType, EventConsumer eventConsumer) {
    if (!consumers.containsKey(eventType)) {
      ArrayList eventConsumersList = new ArrayList();
      consumers.put(eventType, eventConsumersList);
    }
    consumers.get(eventType).add(eventConsumer);
  }
}
