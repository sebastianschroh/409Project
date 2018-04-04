package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shareddata.Student;

public class Server {
	private DatabaseHelper database;
	
	public Student searchStudentsID(int id){
		
		try {
			database = new DatabaseHelper();
			database.prepareStatement("SELECT * FROM termproject.user WHERE id = ?");
			database.getStatement().setInt(1,  id);
			
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
			
			ResultSet rs = database.getStatement().executeQuery();
			
			while(rs.next() && rs.getString(6).charAt(0) == 'S'){
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
