package com.persou.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(
//	basePackages = "com.persou.journey.employer.datasources.postgres",
//	entityManagerFactoryRef = "entityManagerFactory"
//)
//@EntityScan(basePackages = "com.persou.journey.employer.datasources.model")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
