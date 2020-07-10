package org.happyhome.myorchard.tasks.application;

import org.happyhome.myorchard.tasks.domain.Task;
import org.happyhome.myorchard.tasks.domain.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class CreateTaskShould {

  @Mock
  private TaskRepository taskRepository;

  @Test
  void create_a_task() throws ParseException {
    long date_timestamp = 1597881600;
    String name = "name";
    String description = "description";
    CreateTaskCommand createTaskCommand = new CreateTaskCommand(name, description, new Date(date_timestamp));

    CreateTask createTask = new CreateTask(taskRepository);
    createTask.execute(createTaskCommand);

    Task expectedSavedTask = taskBy(date_timestamp, name, description);
    Mockito.verify(taskRepository, times(1)).save(refEq(expectedSavedTask));
  }

  private Task taskBy(long date_timestamp, String name, String description) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(date_timestamp);
    return new Task(name, description, calendar);
  }
}
