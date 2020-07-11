package org.happyhome.myorchard.tasks.infrastructure.repository;

import org.happyhome.myorchard.tasks.domain.Task;
import org.happyhome.myorchard.tasks.domain.TaskRepository;

public class InMemoryTaskRepository implements TaskRepository {
  private final InMemoryTasksDatabase inMemoryTasksDatabase;

  public InMemoryTaskRepository(InMemoryTasksDatabase inMemoryTasksDatabase) {
    this.inMemoryTasksDatabase = inMemoryTasksDatabase;
  }

  @Override
  public void save(Task task) {
    inMemoryTasksDatabase.put(task.getUid(), task);
  }
}
