package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import database.DbConnect;

public class UserModel {
	
//	User user = new User();
	
	private DbConnect connect;
	private Connection conn;
	private Statement stmt;
	PreparedStatement preparedStmt;
	
	public UserModel() throws SQLException{
		this.connect = new DbConnect();
		
		this.conn = connect.getConnection();
	}
	
	// Return all users from DB
	public ArrayList<User> getAll() throws SQLException{
		
		try {
			this.stmt = this.conn.createStatement();
		} catch (SQLException e) {
			System.out.println("err");
		}
		
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM users");
		
		ArrayList<User> users = new ArrayList<User>();
		while(resultSet.next()) {
			
			users.add( new User(resultSet.getInt(1), resultSet.getString(2), (Date) resultSet.getObject(3)) );
   
		}
		
		return users;
		
	}
	
	public User get(int id) throws SQLException {

		try {
			this.stmt = this.conn.createStatement();
		} catch (SQLException e) {
			System.out.println("err");
		}
		
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM users WHERE id = " + id);
		User user = new User();
		if(resultSet.next()) {
			 user.setId(resultSet.getInt(1));
			 user.setUsername(resultSet.getString(2));
			 user.setCreatedAt((Date) resultSet.getObject(3));
		}
		
		return user;
	}
	
	public boolean insert(String username) throws SQLException {
		
		try {
			
			this.preparedStmt = conn.prepareStatement("INSERT INTO users (username) VALUES (?)");
			preparedStmt.setString(1, username);
			preparedStmt.execute();
			
		} catch (SQLException e) {
			System.out.println("err");
		}
		
		return true;
		
	}
	
	public void delete(int id) throws SQLException {
		
		try {
			this.stmt = this.conn.createStatement();
		} catch (SQLException e) {
			System.out.println("err");
		}
		
		stmt.executeUpdate("DELETE FROM users WHERE id = " + id);
				
	}


	
}
