package org.happyhome.myorchard.tasks.application;

import org.happyhome.myorchard.shared.domain.EventBus;
import org.happyhome.myorchard.shared.domain.EventType;
import org.happyhome.myorchard.shared.infrastructure.SyncEventBus;
import org.happyhome.myorchard.tasks.domain.Description;
import org.happyhome.myorchard.tasks.domain.Name;
import org.happyhome.myorchard.tasks.domain.Task;
import org.happyhome.myorchard.tasks.domain.TaskCalendar;
import org.happyhome.myorchard.tasks.domain.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Date;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CreateTaskShould {

  @Mock
  private TaskRepository taskRepository;
  private EventType tasksEventType = EventType.TaskCreated;
  private EventConsumerForTest eventConsumerForTest;
  private EventBus eventBus = new SyncEventBus();

  @BeforeEach
  void setUp() {
    eventConsumerForTest = new EventConsumerForTest();
    eventBus.subscribe(EventType.TaskCreated, eventConsumerForTest);
  }

  @Test
  void store_a_task_when_the_task_is_created() throws ParseException {
    long date_timestamp = 1597881600;
    String name = "name";
    String description = "description";
    CreateTaskCommand createTaskCommand = new CreateTaskCommand(name, description, new Date(date_timestamp));

    CreateTask createTask = new CreateTask(taskRepository, eventBus);
    createTask.execute(createTaskCommand);

    Task expectedSavedTask = new Task(new Name(name), new Description(description), new TaskCalendar(date_timestamp));
    verify(taskRepository, times(1)).save(refEq(expectedSavedTask, "uuid", "domainEvents"));
  }

  @Test
  void produce_domain_event_when_the_task_is_created() {
    long date_timestamp = 1595155578037L;
    String expected_date = "2020-07-19";

    String name = "myTaskName";
    String description = "this is my task description";
    CreateTaskCommand createTaskCommand = new CreateTaskCommand(name, description, new Date(date_timestamp));

    CreateTask createTask = new CreateTask(taskRepository, eventBus);
    createTask.execute(createTaskCommand);

    String expectedEvent = String.format("{ 'name' : '%s', 'date':'%s', 'description': '%s'}",
        name, expected_date, description);

    assertThatEventIsProduced(tasksEventType, eventConsumerForTest, expectedEvent);
  }

  private void assertThatEventIsProduced(EventType tasksEventType, EventConsumerForTest eventConsumerForTest, String expectedEvent) {
    assertThat(eventConsumerForTest.domainEvents).isNotNull();
    assertThat(eventConsumerForTest.domainEvents).size().isEqualTo(1);

    eventConsumerForTest.domainEvents.forEach(
        domainEvent -> {
          assertThat(domainEvent.getEventType()).isEqualTo(tasksEventType);
          assertThatJson(domainEvent.getMessage())
              .whenIgnoringPaths("uuid")
              .isEqualTo(expectedEvent);
        });
  }
}
