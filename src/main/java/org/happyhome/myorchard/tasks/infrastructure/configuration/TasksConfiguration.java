package org.happyhome.myorchard.tasks.infrastructure.configuration;

import org.happyhome.myorchard.tasks.application.CreateTask;
import org.happyhome.myorchard.tasks.domain.Task;
import org.happyhome.myorchard.tasks.domain.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TasksConfiguration {

  @Bean
  public TaskRepository taskRepository(){
    return new TaskRepository() {
      @Override
      public void save(Task task) {
        throw new UnsupportedOperationException();
      }
    };
  }

  @Bean
  public CreateTask createTask(TaskRepository taskRepository){
    return new CreateTask(taskRepository);
  }

}
