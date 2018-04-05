package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shareddata.Assignment;
import shareddata.Student;
import shareddata.StudentEnrollment;

public class Server {
	private DatabaseHelper database;

	public Student searchStudentsID(int id){
		
		try {
			database = new DatabaseHelper();
			database.prepareStatement("SELECT * FROM termproject.user WHERE id = ?");
			database.getStatement().setInt(1,  id);
			
			ResultSet rs = database.getStatement().executeQuery();
			database.getConnection().commit();
			
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
			database.getConnection().commit();
			
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
			database.prepareStatement("INSERT INTO termproject.studentenrollment (student_id, course_id) VALUES(?, ?)");
			database.getStatement().setInt(1,  e.getStudentID());
			database.getStatement().setInt(2, e.getCourseID());
			
			database.getStatement().executeUpdate();
			database.getConnection().commit();
			
			database.prepareStatement("SELECT id FROM termproject.studentenrollment WHERE student_id = ? AND course_id = ?");
			database.getStatement().setInt(1,  e.getStudentID());
			database.getStatement().setInt(2,  e.getCourseID());
			
			ResultSet rs = database.getStatement().executeQuery();
			database.getConnection().commit();
			
			if(rs.next())
			e.setId(rs.getInt(1));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
	
	public void unenroll(StudentEnrollment e){
		
		try {
			database = new DatabaseHelper();
			database.prepareStatement("DELETE FROM termproject.studentenrollment WHERE id = ?");
			database.getStatement().setInt(1,  e.getId());
			
			database.getStatement().executeUpdate();
			database.getConnection().commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
	
	public void uploadAssign(Assignment a){
		
		try {
			database = new DatabaseHelper();
			database.prepareStatement("INSERT INTO termproject.assignment (course_id, title, path, active, due_date) VALUES(?, ?, ?, ?, ?)");
			database.getStatement().setInt(1,  a.getCourseID());
			database.getStatement().setString(2, a.getTitle());
			database.getStatement().setString(3,  a.getPath());
			database.getStatement().setBoolean(4, a.getStatus());
			database.getStatement().setString(5, a.getDueDate());
			
			database.getStatement().executeUpdate();
			database.getConnection().commit();
			
			database.prepareStatement("SELECT id FROM termproject.assignment WHERE course_id = ? AND title = ?");
			database.getStatement().setInt(1,  a.getCourseID());
			database.getStatement().setString(2,  a.getTitle());
			
			ResultSet rs = database.getStatement().executeQuery();
			database.getConnection().commit();
			
			if(rs.next())
			a.setID(rs.getInt(1));;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void setActive(Assignment a, boolean b){
/*		
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
		return new Student (0, null, null);*/
	}
	
	public static void main (String [] args){
		
		Server server = new Server();
		Assignment as = new Assignment(0, 420, "SMOKE W33D Pt2. The weedening", "NO PATH NIBBA", "UR MOMS BIRTHDAY");
		server.uploadAssign(as);
		System.out.println(as.getID());
	}
}

