package com.united.gan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GanApplication {

	public static void main(String[] args) {
		SpringApplication.run(GanApplication.class, args);
	}

}
