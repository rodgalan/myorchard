package org.happyhome.myorchard.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskShould {

  @Test
  void generate_unique_id_when_it_is_created() {
    assertThat(aTask().getUid())
        .isNotNull().isNotEqualTo(aTask().getUid());
  }

  private Task aTask() {
    return new Task(new Name("name"), new Description("description"), new TaskCalendar(2354566));
  }
}