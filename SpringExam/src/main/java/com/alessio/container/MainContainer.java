package com.alessio.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.alessio.container")
@Configuration
@EnableConfigurationProperties
@SpringBootApplication
public class MainContainer {

	public static void main(String[] args) {
		System.out.println("Main container start...");
		ConfigurableApplicationContext context = SpringApplication.run(MainContainer.class, args);
		// context.registerShutdownHook();
		context.close(); // chiude context immediatamente
	}
}
