package com.alessio.dataManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcTest {
	private DataSource dataSource;
	
	public JdbcTest(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void crateTable() {
		try (Connection conn = dataSource.getConnection()) {
			Statement stmt = conn.createStatement();
			String sql = "CREATE TABLE employees (id varchar(64), lastname varchar(64), email varchar(64))";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertEmployees() {
		try (Connection conn = dataSource.getConnection()) {
			Statement stmt = conn.createStatement();
			String sql = "insert into employees (id, lastname, email) values (4,'maz4','maz4@foo')";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void read() {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			    System.out.println("lastname : " + rs.getString("lastname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
