package com.alessio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication
public class SpringExamApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringExamApplication.class, args);
		System.out.println("Hello");
		context.getId();
//		context.registerShutdownHook();
	}

}
