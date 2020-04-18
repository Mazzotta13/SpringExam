package com.alessio.container;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@ComponentScan(basePackages = "com.alessio.container")
@Configuration
public class MainContainer {

	public static void main(String[] args) {
		System.out.println("Main container start...");
		ConfigurableApplicationContext context = SpringApplication.run(MainContainer.class, args);
	}
	
	public class BeanTest {
		public BeanTest() {System.out.println("BeanTest: instantiated");}
	}
	
	@Bean
	@Lazy // in questo modo non vediamo il bean instanziato perchè non è mai utilizzato
	public BeanTest beanTest() {
		return new BeanTest();
	}

}
