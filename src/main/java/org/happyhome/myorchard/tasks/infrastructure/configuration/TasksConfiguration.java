package org.happyhome.myorchard.tasks.infrastructure.configuration;

import org.happyhome.myorchard.tasks.application.CreateTask;
import org.happyhome.myorchard.tasks.domain.Task;
import org.happyhome.myorchard.tasks.domain.TaskRepository;
import org.happyhome.myorchard.tasks.infrastructure.repository.InMemoryTaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.UUID;

@Configuration
public class TasksConfiguration {

  @Bean
  public TaskRepository taskRepository(){
    return new InMemoryTaskRepository(new HashMap<UUID, Task>());
  }

  @Bean
  public CreateTask createTask(TaskRepository taskRepository){
    return new CreateTask(taskRepository);
  }

}
