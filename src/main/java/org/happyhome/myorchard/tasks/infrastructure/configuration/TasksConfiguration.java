package org.happyhome.myorchard.tasks.infrastructure.configuration;

import org.happyhome.myorchard.shared.domain.EventBus;
import org.happyhome.myorchard.tasks.application.CreateTask;
import org.happyhome.myorchard.tasks.domain.TaskRepository;
import org.happyhome.myorchard.tasks.infrastructure.repository.InMemoryTaskRepository;
import org.happyhome.myorchard.tasks.infrastructure.repository.InMemoryTasksDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TasksConfiguration {

  @Bean
  public InMemoryTasksDatabase tasksDatabase(){
    return new InMemoryTasksDatabase();
  }

  @Bean
  public TaskRepository taskRepository(InMemoryTasksDatabase inMemoryTasksDatabase){
    return new InMemoryTaskRepository(inMemoryTasksDatabase);
  }

  @Bean
  public CreateTask createTask(TaskRepository taskRepository, EventBus eventBus){
    return new CreateTask(taskRepository, eventBus);
  }

}
