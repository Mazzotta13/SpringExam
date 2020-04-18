package com.alessio.dataManagement;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {
	@Bean
	public DataSource dataSource() {
		final BasicDataSource theDataSource = new BasicDataSource();
		theDataSource.setDriverClassName("org.h2.Driver");
		theDataSource.setUrl("jdbc:h2:mem:testdb");
		theDataSource.setUsername("sa");
		theDataSource.setPassword("password");
		return theDataSource;
	}
}
