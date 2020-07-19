package org.happyhome.myorchard.shared.infrastructure;

import org.happyhome.myorchard.shared.domain.DomainEvent;

public interface EventConsumer {
  void consume(DomainEvent domainEvent);
}
