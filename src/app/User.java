package app;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private Date createdAt;
	
	public User() {
		// Empty constructor
	}
	
	public User(String username) {
		this.username = username;
	}

	public User(int id, String username, Date createdAt) {
		this.id = id;
		this.username = username;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
