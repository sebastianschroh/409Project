package backend;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import shareddata.Assignment;
import shareddata.Student;
import shareddata.StudentEnrollment;

public class Server {
	
	private DatabaseHelper database;
	private ServerSocket serverSock;
	private ExecutorService pool;
	
	public Server(int portNumber)
	{
		try
		{
			serverSock = new ServerSocket(portNumber);
			pool = Executors.newCachedThreadPool();
			
		} catch (IOException e)
		{
			System.err.println("Error in server construction");
		}
	}
	
	public Student searchStudentsID(int id){
		
		try {
			database = new DatabaseHelper();
			database.prepareStatement("SELECT * FROM termproject.user WHERE id = ?");
			database.getStatement().setInt(1,  id);
			
			database.getConnection().commit();
			ResultSet rs = database.getStatement().executeQuery();
			
			if(rs.next() && rs.getString(6).charAt(0) == 'S'){
				return new Student(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			else return new Student (0, null, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Student (0, null, null);
	}
	
	public ArrayList<Student> searchStudentsName(String name){
		
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			database = new DatabaseHelper();
			database.prepareStatement("SELECT * FROM termproject.user WHERE lastname = ?");
			database.getStatement().setString(1, name);
			
			database.getConnection().commit();
			ResultSet rs = database.getStatement().executeQuery();
			
			while(rs.next() && rs.getString(6).charAt(0) == 'S'){
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addEnrollment(StudentEnrollment e){
		
		try {
			database = new DatabaseHelper();
			database.prepareStatement("INSERT INTO termproject.studentenrollment VALUES(?, ?)");
			database.getStatement().setInt(1,  e.getStudentID());
			database.getStatement().setInt(2, e.getCourseID());
			
			database.getConnection().commit();
			database.getStatement().executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
	
	public void unenroll(StudentEnrollment e){
		
		try {
			database = new DatabaseHelper();
			database.prepareStatement("DELETE FROM termproject.studentenrollment WHERE id = ?");
			database.getStatement().setInt(1,  e.getId());
			
			database.getConnection().commit();
			database.getStatement().executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
	
	public void uploadAssign(Assignment a){
		
		try {
			database = new DatabaseHelper();
			database.prepareStatement("INSERT INTO termproject.assignment VALUES(?, ?, ?, ?, ?, ?)");
			database.getStatement().setInt(1,  a.getCourseID());
			database.getStatement().setString(2, a.getTitle());
			database.getStatement().setString(3,  a.getPath());
			database.getStatement().setBoolean(4, a.getStatus());
			database.getStatement().setString(5, a.getDueDate());
			
			database.getConnection().commit();
			database.getStatement().executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		
	}
}

