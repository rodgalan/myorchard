package org.happyhome.myorchard.tasks.infrastructure.repository;

import org.happyhome.myorchard.tasks.domain.Task;

import java.util.HashMap;
import java.util.UUID;

public class InMemoryTasksDatabase extends HashMap<UUID, Task> {
}
