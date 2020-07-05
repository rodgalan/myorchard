package org.happyhome.myorchard.tasks.infrastructure.controller;

import org.happyhome.myorchard.tasks.application.CreateTask;
import org.happyhome.myorchard.tasks.application.CreateTaskCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE)
public class CreateTaskUserController {

  private final CreateTask createTask;

  public CreateTaskUserController(CreateTask createTask) {
    this.createTask = createTask;
  }

  @PostMapping
  public ResponseEntity<Void> execute(CreateTaskUserRequest createTaskUserRequest) {

    CreateTaskCommand createTaskCommand = new CreateTaskCommand(createTaskUserRequest.getName(), createTaskUserRequest.getDescription(), createTaskUserRequest.getDate());
    createTask.execute(createTaskCommand);

    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }
}
