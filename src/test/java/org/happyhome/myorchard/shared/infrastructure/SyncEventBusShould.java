package org.happyhome.myorchard.shared.infrastructure;

import org.happyhome.myorchard.shared.domain.DomainEvent;
import org.happyhome.myorchard.shared.domain.EventBus;
import org.happyhome.myorchard.shared.domain.EventType;
import org.happyhome.myorchard.tasks.application.EventConsumerForTest;
import org.junit.jupiter.api.Test;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.refEq;

public class SyncEventBusShould {

  private final EventBus eventBus = new SyncEventBus();

  @Test
  void publish_to_all_subscribed_event_consumers() {
    EventConsumerForTest aConsumer = new EventConsumerForTest();
    eventBus.subscribe(EventType.TaskCreated, aConsumer);

    EventConsumerForTest otherConsumer = new EventConsumerForTest();
    eventBus.subscribe(EventType.TaskCreated, otherConsumer);

    DomainEvent domainEvent = new DomainEvent(EventType.TaskCreated, "hola");
    eventBus.publish(domainEvent);

    assertThat(refEq(aConsumer.domainEvents))
        .isEqualTo(refEq(otherConsumer.domainEvents))
        .isEqualTo(refEq(domainEvent));
  }

  @Test
  void publish_serialized_event_to_consumer() {
    EventConsumerForTest aConsumer = new EventConsumerForTest();

    eventBus.subscribe(EventType.TaskCreated, aConsumer);

    MessageForTest messageForTest = new MessageForTest();
    DomainEvent domainEvent = new DomainEvent(EventType.TaskCreated, messageForTest);
    eventBus.publish(domainEvent);

    String expected_message = String.format("{'field_1' : '%s', 'field_2' : '%s'}",
        messageForTest.getField_1(),
        messageForTest.getField_2());

    aConsumer.domainEvents.forEach(event ->
        assertThatJson(event.getMessage()).isEqualTo(expected_message)
    );
  }

  @Test
  void not_fail_when_no_event_subscribers() {
    EventBus eventBus = new SyncEventBus();

    Throwable thrown = catchThrowable(() -> eventBus.publish(new DomainEvent(EventType.TaskCreated,
        "I dont have subscribers")));

    assertThat(thrown).doesNotThrowAnyException();
  }

  public class MessageForTest{
    private String field_1 = "hello";
    private String field_2 = "goodby";

    public String getField_1() {
      return field_1;
    }

    public String getField_2() {
      return field_2;
    }
  }
}
