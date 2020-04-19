package com.alessio.MVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.alessio.MVC")
@SpringBootApplication
public class MainMVC extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("MainMVC started...");
		SpringApplication.run(MainMVC.class, args);
	}
}
