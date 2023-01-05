package com.bhavuk.SpringBatchTut;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
@EnableBatchProcessing
public class SpringBatchTutApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchTutApplication.class, args);
	}

}
