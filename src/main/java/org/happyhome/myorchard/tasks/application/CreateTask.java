package org.happyhome.myorchard.tasks.application;

import org.happyhome.myorchard.shared.domain.EventBus;
import org.happyhome.myorchard.tasks.domain.Description;
import org.happyhome.myorchard.tasks.domain.Name;
import org.happyhome.myorchard.tasks.domain.Task;
import org.happyhome.myorchard.tasks.domain.TaskCalendar;
import org.happyhome.myorchard.tasks.domain.TaskRepository;

public class CreateTask {
  private final TaskRepository taskRepository;
  private final EventBus eventBus;

  public CreateTask(TaskRepository taskRepository, EventBus eventBus) {
    this.taskRepository = taskRepository;
    this.eventBus = eventBus;
  }

  public void execute(CreateTaskCommand createTaskCommand) {
    Task task = taskBy(createTaskCommand);
    taskRepository.save(task);
    task.getDomainEvents().forEach(domainEvent -> eventBus.publish(domainEvent));
  }

  private Task taskBy(CreateTaskCommand createTaskCommand) {
    return new Task(new Name(createTaskCommand.getName()),
        new Description(createTaskCommand.getDescription()),
        new TaskCalendar(createTaskCommand.getDate().getTime()));
  }

}
