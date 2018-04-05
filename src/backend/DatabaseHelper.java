package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHelper {
	private PreparedStatement statement;
	private Connection connection;
	private String sql;
	
	public DatabaseHelper() throws SQLException{
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb", "root", "password");
		connection.setAutoCommit(false);
	}
	
	public PreparedStatement getStatement(){
		return statement;
	}
	
	public void prepareStatement(String s) throws SQLException{
		statement = connection.prepareStatement(s);
	}
	
	public Connection getConnection(){
		return connection;
	}
}
