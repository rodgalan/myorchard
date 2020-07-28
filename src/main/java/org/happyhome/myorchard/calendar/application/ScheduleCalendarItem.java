package org.happyhome.myorchard.calendar.application;

import org.happyhome.myorchard.calendar.domain.CalendarRepository;
import org.happyhome.myorchard.calendar.domain.Description;
import org.happyhome.myorchard.calendar.domain.CalendarItem;
import org.happyhome.myorchard.calendar.domain.Schedule;
import org.happyhome.myorchard.calendar.domain.Tittle;

public class ScheduleCalendarItem {
  private final CalendarRepository calendarRepository;

  public ScheduleCalendarItem(CalendarRepository calendarRepository) {
    this.calendarRepository = calendarRepository;
  }

  public void execute(ScheduleCalendarItemCommand scheduleCalendarItemCommand) {
    CalendarItem calendarItem = by(scheduleCalendarItemCommand);
    calendarRepository.save(calendarItem);
  }

  private CalendarItem by(ScheduleCalendarItemCommand scheduleCalendarItemCommand) {
    return new CalendarItem(
        new Tittle(scheduleCalendarItemCommand.getName()),
        new Description(scheduleCalendarItemCommand.getDescription()),
        new Schedule(scheduleCalendarItemCommand.getWhen()));
  }
}
