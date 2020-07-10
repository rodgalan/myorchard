package org.happyhome.myorchard.tasks.infrastructure.repository;

import org.happyhome.myorchard.tasks.domain.Task;
import org.happyhome.myorchard.tasks.domain.TaskRepository;

import java.util.Map;
import java.util.UUID;

public class InMemoryTaskRepository implements TaskRepository {
  private final Map<UUID, Task> inMemoryDatabase;

  public InMemoryTaskRepository(Map<UUID, Task> inMemoryDatabase) {
    this.inMemoryDatabase = inMemoryDatabase;
  }

  @Override
  public void save(Task task) {
    inMemoryDatabase.put(task.getUid(), task);
  }
}
