package org.happyhome.myorchard.shared.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.happyhome.myorchard.shared.domain.DomainEvent;
import org.happyhome.myorchard.shared.domain.EventType;

public class SerializedDomainEvent extends DomainEvent<String> {

  public SerializedDomainEvent(EventType eventType, String message) {
    super(eventType, message);
  }

  static SerializedDomainEvent serializeFrom(DomainEvent domainEvent) {
    try {
      return EventSerializer.getInstance().execute(domainEvent);
    } catch (JsonProcessingException e) {  //TODO!!!
      e.printStackTrace();
      return null;
    }
  }

}
