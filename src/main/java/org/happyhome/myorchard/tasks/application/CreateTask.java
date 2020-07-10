package org.happyhome.myorchard.tasks.application;

import org.happyhome.myorchard.tasks.domain.Task;
import org.happyhome.myorchard.tasks.domain.TaskRepository;

import java.util.Calendar;

public class CreateTask {
  private final TaskRepository taskRepository;

  public CreateTask(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public void execute(CreateTaskCommand createTaskCommand) {
    Task task = taskBy(createTaskCommand);
    taskRepository.save(task);
  }

  private Task taskBy(CreateTaskCommand createTaskCommand) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(createTaskCommand.getDate().getTime());
    return new Task(createTaskCommand.getName(),
        createTaskCommand.getDescription(),
        calendar);
  }


}
