package org.happyhome.myorchard.shared.infrastructure;

import org.happyhome.myorchard.tasks.application.CreateTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TasksConfiguration {

  @Bean
  public CreateTask createTask(){
    return new CreateTask();
  }

}
