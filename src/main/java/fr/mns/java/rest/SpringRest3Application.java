package fr.mns.java.rest;

import fr.mns.java.rest.controller.ForumController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "fr.mns.java.rest.repository")
@ComponentScan(basePackages = "fr.mns.java.rest")
@ComponentScan(basePackageClasses = ForumController.class)
public class SpringRest3Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringRest3Application.class, args);
	}
}
