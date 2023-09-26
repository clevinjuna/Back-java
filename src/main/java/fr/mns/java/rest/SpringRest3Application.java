package fr.mns.java.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "fr.mns.java.rest.model")
@ComponentScan(basePackages = "fr.mns.java.rest.client")
public class SpringRest3Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringRest3Application.class, args);
	}
}
