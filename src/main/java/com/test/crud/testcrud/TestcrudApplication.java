package com.test.crud.testcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.test.crud","com.test.crud.controllers"})
@EntityScan(basePackages={"com.test.crud.models"})
@EnableJpaRepositories({"com.test.crud.repositories"})
public class TestcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestcrudApplication.class, args);
	}

}

