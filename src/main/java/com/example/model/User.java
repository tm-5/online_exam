package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="id", nullable=false)
    private String id;
    
	@Column(name="user_name", nullable=false)
	private String name;
	   
	@Column(name="user_email", nullable=false)
	private String email;
	    
	@Column(name="user_password", nullable=false)
	private String password;

	public String getId() {
		return id;
	}

	public User() {
		super();
	}

	public void setId(String id) {
		this.id = id;
	}

	public User(String id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
