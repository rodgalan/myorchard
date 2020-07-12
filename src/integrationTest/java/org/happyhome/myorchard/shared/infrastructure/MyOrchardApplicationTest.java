package org.happyhome.myorchard.shared.infrastructure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MyOrchardApplicationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void applicationIsUp() {
		ResponseEntity<String> response = testRestTemplate.getForEntity("/actuator/health", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
