package org.happyhome.myorchard.acceptance;

import org.happyhome.myorchard.infrastructure.MyOrchardApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(classes = {MyOrchardApplication.class}, webEnvironment = RANDOM_PORT)
public class CreateTaskFeature {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  void should_create_a_task() throws Exception {

    String create_a_task_request ="{"
        + "name : \"myTaskName\","
        + "schedule:{date: \"2020-08-20\",time: \"14:00\"},"
        + "description : \"this is my task description\"}";

    ResponseEntity<Void> result = this.testRestTemplate.postForEntity("/task", create_a_task_request, Void.class);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
  }
}
