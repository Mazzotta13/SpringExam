package com.alessio.dataManagement;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcWithTemplate {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcWithTemplate(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate();
		this.jdbcTemplate.setDataSource(datasource);
	}
	
	public void crateTable() {
		String sql = "CREATE TABLE employees (id varchar(64), lastname varchar(64), email varchar(64))";
		jdbcTemplate.execute(sql);
	}
	
	public void insertEmployees() {
		String sql = "INSERT INTO employees (id, lastname, email) values (5,'maz5','maz4@foo')";
		jdbcTemplate.execute(sql);
		// oppure
		String sql2 = "INSERT INTO employees (id, lastname, email) VALUES (?, ?, ?)";
		Object[] obj = {6, "maz6", "maz6@test"}; // parametri per l'inserimento
		jdbcTemplate.update(sql2, obj);
	}
	
	public void read() {
        RowMapper<String[]> rowMapper = new RowMapper<String[]>() {
			@Override
			public String[] mapRow(ResultSet rs, int rowNum) throws SQLException {
				String[] result = new String[3];
				result[0] = rs.getString("id");
				result[1] = rs.getString("lastname");
				result[2] = rs.getString("email");
				return result;
			}
		};
		String sql = "SELECT * FROM employees WHERE id = ?";
		String[] res = jdbcTemplate.queryForObject(sql, new Object[]{4}, rowMapper );
		System.out.println("res: id "+res[0] + " - lastname: "+res[1]);
	}
	
	public void rollBackMethod() {
	}
}
