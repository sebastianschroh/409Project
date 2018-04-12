package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shareddata.Assignment;
import shareddata.Course;
import shareddata.LoginInfo;
import shareddata.Professor;
import shareddata.Student;
import shareddata.StudentEnrollment;
import shareddata.User;

public class DatabaseHelper {
	
	private PreparedStatement statement;
	private Connection connection;

	
	public DatabaseHelper() throws SQLException{
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject?autoReconnect=true&useSSL=false", "root", "password");
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
	
	public User searchUserID(int id){
		
		User user = new User(0, null, null);
		try {
			prepareStatement("SELECT * FROM termproject.user WHERE id = ?");
			getStatement().setInt(1,  id);
			
			ResultSet rs = getStatement().executeQuery();
			getConnection().commit();
			
			if(rs.next() && rs.getString(6).charAt(0) == 'S')
				 user = new Student(rs.getInt(1), rs.getString(4), rs.getString(5));
			else if (rs.getString(6).charAt(0) == 'P')
				user = new Professor(rs.getInt(1), rs.getString(4), rs.getString(5));	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public Student searchStudentsID(Student s){
		
		try {
			prepareStatement("SELECT * FROM termproject.user WHERE id = ?");
			getStatement().setInt(1,  s.getId());
			
			ResultSet rs = getStatement().executeQuery();
			getConnection().commit();
			
			if(rs.next() && rs.getString(6).charAt(0) == 'S'){
				return new Student(rs.getInt(1), rs.getString(4), rs.getString(5));
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
			prepareStatement("SELECT * FROM termproject.user WHERE lastname = ?");
			getStatement().setString(1, name);
			
			ResultSet rs = getStatement().executeQuery();
			getConnection().commit();
			
			while(rs.next() && rs.getString(6).charAt(0) == 'S'){
				list.add(new Student(rs.getInt(1), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Course> browseCourses(int profId){
		
		ArrayList<Course> list = new ArrayList<Course>();
		try {
			prepareStatement("SELECT * FROM termproject.course WHERE prof_id = ?");
			getStatement().setInt(1, profId);
			
			ResultSet rs = getStatement().executeQuery();
			getConnection().commit();
			
			while(rs.next()){
				list.add(new Course(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getBoolean(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Course addCourse(Course c){
		Course r = null;
		try {
			
			prepareStatement("INSERT INTO termproject.course (prof_id, name, active) VALUES(?, ?, ?)");
			getStatement().setInt(1, c.getProfID());
			getStatement().setString(2, c.getName());
			getStatement().setBoolean(3, c.getStatus());
			
			getStatement().executeUpdate();
			getConnection().commit();
			
			prepareStatement("SELECT id FROM termproject.course WHERE prof_id = ? AND name = ?");
			getStatement().setInt(1, c.getProfID());
			getStatement().setString(2, c.getName());
			
			ResultSet rs = getStatement().executeQuery();
			getConnection().commit();
			
			if(rs.next())
			c.setID(rs.getInt(1));
			
			r = c;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return r;
	}
	
	public Course setActive(Course c){
		Course course = new Course(0,0,null,false);
		try {
			boolean b = false;
			prepareStatement("SELECT active FROM termproject.course WHERE id = ?");
			getStatement().setInt(1, c.getID());
			
			ResultSet rs = getStatement().executeQuery();
			getConnection().commit();
			
			if(rs.next())
				b = rs.getBoolean(1);
			course = new Course(c.getID(), c.getProfID(), c.getName(),b);
			course.setActive(!b);
			prepareStatement("UPDATE termproject.course SET active = ? WHERE id = ?" );
			if(b) 
				getStatement().setBoolean(1, false);
			else
				getStatement().setBoolean(1, true);
			getStatement().setInt(2, c.getID());
			
			getStatement().executeUpdate();
			getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}
	
	public void addEnrollment(StudentEnrollment e){
		
		try {
			prepareStatement("INSERT INTO termproject.studentenrollment (student_id, course_id) VALUES(?, ?)");
			getStatement().setInt(1,  e.getStudentID());
			getStatement().setInt(2, e.getCourseID());
			
			getStatement().executeUpdate();
			getConnection().commit();
			
			prepareStatement("SELECT id FROM termproject.studentenrollment WHERE student_id = ? AND course_id = ?");
			getStatement().setInt(1,  e.getStudentID());
			getStatement().setInt(2,  e.getCourseID());
			
			ResultSet rs = getStatement().executeQuery();
			getConnection().commit();
			
			if(rs.next())
			e.setId(rs.getInt(1));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
	
	public void unenroll(StudentEnrollment e){
		
		try {
			prepareStatement("DELETE FROM termproject.studentenrollment WHERE id = ?");
			getStatement().setInt(1,  e.getId());
			
			getStatement().executeUpdate();
			getConnection().commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
	
	public void uploadAssign(Assignment a){
		
		try {
			prepareStatement("INSERT INTO termproject.assignment (course_id, title, path, active, due_date) VALUES(?, ?, ?, ?, ?)");
			getStatement().setInt(1,  a.getCourseID());
			getStatement().setString(2, a.getTitle());
			getStatement().setString(3,  a.getPath());
			getStatement().setBoolean(4, a.getStatus());
			getStatement().setString(5, a.getDueDate());
			
			getStatement().executeUpdate();
			getConnection().commit();
			
			prepareStatement("SELECT id FROM termproject.assignment WHERE course_id = ? AND title = ?");
			getStatement().setInt(1,  a.getCourseID());
			getStatement().setString(2,  a.getTitle());
			
			ResultSet rs = getStatement().executeQuery();
			getConnection().commit();
			
			if(rs.next())
			a.setID(rs.getInt(1));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public Assignment setActive(Assignment a, boolean b){		
		try {
			prepareStatement("UPDATE termproject.assignment SET active = ? WHERE id = ?");
			getStatement().setBoolean(1,  b);
			getStatement().setInt(2, a.getID());
			
			getStatement().executeUpdate();
			getConnection().commit();
			a.setActive(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public void checkPassword(LoginInfo l){
		
		try {
			prepareStatement("SELECT * FROM termproject.user WHERE id = ?");
			getStatement().setInt(1,  l.getUsername());
			
			ResultSet rs = getStatement().executeQuery();
			getConnection().commit();
			
			if(rs.next() && (rs.getString(2).equals(l.getPassword())))
				l.authenticate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Student> getStudentsEnrolled(Course c){
		ArrayList<Student> list = new ArrayList<Student>();
		
		try{
			prepareStatement("SELECT * FROM termproject.studentenrollment WHERE course_id = ?");
			getStatement().setInt(1,  c.getID());
			
			ResultSet rs = getStatement().executeQuery();
			getConnection().commit();
			
			while(rs.next()){
				list.add((Student) searchUserID(rs.getInt(2)));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Assignment> getAssignments(Course c){
		ArrayList<Assignment> list = new ArrayList<Assignment>();
		
		try{
			prepareStatement("SELECT * FROM termproject.assignment WHERE course_id = ?");
			getStatement().setInt(1,  c.getID());
			
			ResultSet rs = getStatement().executeQuery();
			getConnection().commit();
			
			while(rs.next()){
				list.add(new Assignment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6)));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> getStudentEmails(Course c){
		ArrayList<String> list = new ArrayList<String>();
		
		try{
			prepareStatement("SELECT * FROM termproject.studentenrollment WHERE course_id = ?");
			getStatement().setInt(1,  c.getID());
			
			ResultSet rs = getStatement().executeQuery();
			getConnection().commit();
			
			while(rs.next()){
				prepareStatement("SELECT * FROM termproject.user WHERE id = ?");
				getStatement().setInt(1,  rs.getInt(1));
				
				ResultSet rs2 = getStatement().executeQuery();
				getConnection().commit();
				if(rs2.next())
					list.add(rs2.getString(3));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
