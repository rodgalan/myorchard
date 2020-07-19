package org.happyhome.myorchard.shared.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.happyhome.myorchard.shared.domain.DomainEvent;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

class EventSerializer {

  private final ObjectMapper objectMapper;
  private static EventSerializer eventSerializer;

  private EventSerializer() {
    objectMapper = new ObjectMapper();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
    objectMapper.setDateFormat(simpleDateFormat);
  }

  public synchronized static EventSerializer getInstance(){
    if (eventSerializer == null){
      eventSerializer = new EventSerializer();
    }
    return eventSerializer;
  }

  public SerializedDomainEvent execute(DomainEvent domainEvent) throws JsonProcessingException {
    return new SerializedDomainEvent(domainEvent.getEventType(), objectMapper.writeValueAsString(domainEvent.getMessage()));
  }
}
