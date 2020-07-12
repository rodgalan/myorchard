package org.happyhome.myorchard.shared.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"org.happyhome.myorchard.shared.infrastructure",
		"org.happyhome.myorchard.tasks.infrastructure"
})
public class MyOrchardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyOrchardApplication.class, args);
	}
}
