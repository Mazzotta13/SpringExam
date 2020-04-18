package com.alessio.dataManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.alessio.dataManagement")
public class MainDataManagement implements CommandLineRunner {
	
	@Autowired
	private JdbcTest jdbcTest;
	
	@Autowired
	private JdbcWithTemplate jdbcWithTemplate;
	
	public static void main(String[] args) {
		System.out.println("MainDataManagement container start...");
		SpringApplication.run(MainDataManagement.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jdbcTest.crateTable();
		jdbcTest.insertEmployees();
		jdbcTest.read();
		// jdbc with template
		jdbcWithTemplate.insertEmployees();
		jdbcWithTemplate.read();
	}
	
	
}
