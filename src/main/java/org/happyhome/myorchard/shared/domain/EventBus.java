package org.happyhome.myorchard.shared.domain;

import org.happyhome.myorchard.shared.infrastructure.EventConsumer;

public interface EventBus {
  void publish(DomainEvent domainEvent);
  void subscribe(EventType eventType, EventConsumer eventConsumer);
}
