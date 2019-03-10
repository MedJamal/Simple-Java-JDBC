package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    private String url = "jdbc:mysql://localhost:3306/javatest";    
    private String driverName = "com.mysql.jdbc.Driver";
    private String username = "root";   
    private String password = "129430jamal";
    private Connection conn;

    public Connection getConnection() {
    	
        try {
            Class.forName(driverName);
            try {
            	conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return conn;
    }
    
}