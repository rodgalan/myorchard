package org.happyhome.myorchard.tasks.infrastructure.repository;

import org.assertj.core.api.Assertions;
import org.happyhome.myorchard.tasks.domain.Description;
import org.happyhome.myorchard.tasks.domain.Name;
import org.happyhome.myorchard.tasks.domain.Task;
import org.happyhome.myorchard.tasks.domain.TaskCalendar;
import org.junit.jupiter.api.Test;

public class InMemoryTaskRepositoryShould {
  private final InMemoryTasksDatabase inMemoryTasksDatabase = new InMemoryTasksDatabase();


  @Test
  void save_a_task() {
    Task task = new Task(new Name("name"), new Description("description"), new TaskCalendar(5446633));

    InMemoryTaskRepository repository= new InMemoryTaskRepository(inMemoryTasksDatabase);
    repository.save(task);

    Assertions.assertThat(task).isEqualTo(inMemoryTasksDatabase.get(task.getUid()));
  }
}
