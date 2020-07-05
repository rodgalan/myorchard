package org.happyhome.myorchard.tasks.infrastructure.controller;

import org.happyhome.myorchard.tasks.application.usecase.CreateTask;
import org.happyhome.myorchard.tasks.application.usecase.CreateTaskCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CreateTaskUserController {

  private final CreateTask createTask;

  public CreateTaskUserController(CreateTask createTask) {
    this.createTask = createTask;
  }

  public ResponseEntity<Void> execute(CreateTaskUserRequest createTaskUserRequest) {

    CreateTaskCommand createTaskCommand = new CreateTaskCommand(createTaskUserRequest.getName(), createTaskUserRequest.getDescription(), createTaskUserRequest.getDate());
    createTask.execute(createTaskCommand);

    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }
}
