package org.happyhome.myorchard.tasks.acceptance;

import org.happyhome.myorchard.shared.infrastructure.MyOrchardApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(classes = {MyOrchardApplication.class}, webEnvironment = RANDOM_PORT)
public class CreateTaskFeatureShould {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  void create_a_task() throws Exception {
    String task ="{"
        + "name : \"myTaskName\","
        + "date: \"2020-08-20\","
        + "description : \"this is my task description\"}";

    HttpEntity<String> create_a_task_request = createTaskRequestBy(task);

    ResponseEntity<Void> result = this.testRestTemplate.postForEntity("/task", create_a_task_request, Void.class);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
  }

  private HttpEntity<String> createTaskRequestBy(String jsonTask) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    return new HttpEntity<String>(jsonTask, headers);
  }
}
