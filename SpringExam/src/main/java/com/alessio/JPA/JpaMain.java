package com.alessio.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.alessio.JPA")
@Configuration
//@SpringBootApplication
public class JpaMain implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeService employeeService;
	
	public static void main(String[] args) {
		System.out.println("JpaMain started...");
		SpringApplication.run(JpaMain.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		employeeRepository.save(new Employee("Alessio", "alessio@a"));
		employeeRepository.findAll().forEach(employee -> System.out.println(employee.toString()));
		// test transaction
		try {
			//employeeService.testTransaction();
			employeeService.testTransaction2();
		} catch (Exception e) {
			System.out.println("Exception");
		}
		
		employeeRepository.findAll().forEach(employee -> System.out.println(employee.toString()));
	}

}
