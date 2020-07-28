package org.happyhome.myorchard.calendar.application;

import org.happyhome.myorchard.calendar.domain.CalendarRepository;
import org.happyhome.myorchard.calendar.domain.Description;
import org.happyhome.myorchard.calendar.domain.CalendarItem;
import org.happyhome.myorchard.calendar.domain.Schedule;
import org.happyhome.myorchard.calendar.domain.Tittle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ScheduleCalendarItemShould {

  @Mock
  private CalendarRepository calendarRepository;

  @Test
  void add_notification_to_calendar() {
    ScheduleCalendarItemCommand scheduleCalendarItemCommand = new ScheduleCalendarItemCommand("name", "description", 1597881600);

    ScheduleCalendarItem createNotification = new ScheduleCalendarItem(calendarRepository);

    createNotification.execute(scheduleCalendarItemCommand);

    CalendarItem calendarItem = new CalendarItem(new Tittle("name"), new Description("description"), new Schedule(1597881600) );
    verify(calendarRepository, times(1)).save(refEq(calendarItem));
  }
}
