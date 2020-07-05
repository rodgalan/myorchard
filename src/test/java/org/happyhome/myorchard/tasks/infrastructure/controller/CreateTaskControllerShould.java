package org.happyhome.myorchard.tasks.infrastructure.controller;

import org.happyhome.myorchard.tasks.application.CreateTask;
import org.happyhome.myorchard.tasks.application.CreateTaskCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class CreateTaskControllerShould {

  @Mock
  private CreateTask createTask;

  @Test
  void notify_success_when_a_task_is_created() throws ParseException {
    String taskName = "MyTaskName";
    String taskDescription = "My task description";
    Date taskSchedule = new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-20");
    CreateTaskUserRequest createTaskUserRequest = new CreateTaskUserRequest(taskName, taskDescription, taskSchedule);

    CreateTaskCommand createTaskUserCommand = new CreateTaskCommand(taskName, taskDescription, taskSchedule);
    doNothing().when(createTask).execute(refEq(createTaskUserCommand));

    CreateTaskUserController createTaskUserController = new CreateTaskUserController(createTask);
    ResponseEntity<Void> createTaskUserResponse = createTaskUserController.execute(createTaskUserRequest);

    ResponseEntity<Void> expectedCreateTaskUserResponse  = new ResponseEntity<Void>(HttpStatus.CREATED);
    assertThat(createTaskUserResponse).isEqualTo(expectedCreateTaskUserResponse);
  }
}
