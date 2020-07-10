package org.happyhome.myorchard.tasks.application;

import org.happyhome.myorchard.tasks.domain.Description;
import org.happyhome.myorchard.tasks.domain.Name;
import org.happyhome.myorchard.tasks.domain.Task;
import org.happyhome.myorchard.tasks.domain.TaskCalendar;
import org.happyhome.myorchard.tasks.domain.TaskRepository;

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
    return new Task(new Name(createTaskCommand.getName()),
        new Description(createTaskCommand.getDescription()),
        new TaskCalendar(createTaskCommand.getDate().getTime()));
  }

}
