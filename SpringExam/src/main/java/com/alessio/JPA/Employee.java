package com.alessio.JPA;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private String id;
	private String lastname;
	private String email;
	
	public Employee() {}
	
	public Employee(String id, String lastname, String email) {
		this.id = id;
		this.lastname = lastname;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastname=" + lastname + ", email=" + email + "]";
	}
}
