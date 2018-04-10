package backend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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

public class Worker implements Runnable {
	
	private Socket accessSock;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private DatabaseHelper database;
	
	public Worker(Socket socket)
	{
		accessSock = socket;
		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run()
	{
		while(true)
		{
			try {
				Object input = in.readObject();
				
				if(input instanceof Course) {
					Course course = (Course)input;
					String s = (String)in.readObject();
					if(s.contains("setCourseActivity"))
					{
						sendObject(setActive(course));
					}
					else if(s.contains("createcourse"))
					{
						sendObject(addCourse(course));
					}
				}
				if(input instanceof LoginInfo)
				{
				LoginInfo info = (LoginInfo) input;
				checkPassword(info);
				sendObject(info);
				}
				if(input instanceof String)
				{
					String s = (String) input;
					if(s.contains("getuser"))
					{
						String [] instruction = s.split(" ");
						sendObject(searchUserID(Integer.parseInt(instruction[1])));
					}
				}
				if(input instanceof Professor)
				{
					Professor prof = (Professor) input;
					String s = (String) in.readObject();
					if(s.contains("getcourses"))
					{
						sendObject(browseCourses(prof.getId()));
					}
				}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				closeConnection();
				break;
			}
		}
	}
	
	public void sendObject(Object s)
	{
		try {
		out.writeObject(s);
		out.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public User searchUserID(int id){
		
		User user = new User(0, null, null);
		try {
			database = new DatabaseHelper();
			database.prepareStatement("SELECT * FROM termproject.user WHERE id = ?");
			database.getStatement().setInt(1,  id);
			
			ResultSet rs = database.getStatement().executeQuery();
			database.getConnection().commit();
			
			if(rs.next() && rs.getString(6).charAt(0) == 'S')
				 user = new Student(rs.getInt(1), rs.getString(4), rs.getString(5));
			else if (rs.getString(6).charAt(0) == 'p')
				user = new Professor(rs.getInt(1), rs.getString(4), rs.getString(5));	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public Student searchStudentsID(Student s){
		
		try {
			database = new DatabaseHelper();
			database.prepareStatement("SELECT * FROM termproject.user WHERE id = ?");
			database.getStatement().setInt(1,  s.getId());
			
			ResultSet rs = database.getStatement().executeQuery();
			database.getConnection().commit();
			
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
			database = new DatabaseHelper();
			database.prepareStatement("SELECT * FROM termproject.user WHERE lastname = ?");
			database.getStatement().setString(1, name);
			
			ResultSet rs = database.getStatement().executeQuery();
			database.getConnection().commit();
			
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
			database = new DatabaseHelper();
			database.prepareStatement("SELECT * FROM termproject.course WHERE prof_id = ?");
			database.getStatement().setInt(1, profId);
			
			ResultSet rs = database.getStatement().executeQuery();
			database.getConnection().commit();
			
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
			database = new DatabaseHelper();
			database.prepareStatement("INSERT INTO termproject.course (prof_id, name, active) VALUES(?, ?, ?)");
			database.getStatement().setInt(1, c.getProfID());
			database.getStatement().setString(2, c.getName());
			database.getStatement().setBoolean(3, c.getStatus());
			
			database.getStatement().executeUpdate();
			database.getConnection().commit();
			
			database.prepareStatement("SELECT id FROM termproject.course WHERE prof_id = ? AND name = ?");
			database.getStatement().setInt(1, c.getProfID());
			database.getStatement().setString(2, c.getName());
			
			ResultSet rs = database.getStatement().executeQuery();
			database.getConnection().commit();
			
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
			database = new DatabaseHelper();
			database.prepareStatement("SELECT active FROM termproject.course WHERE id = ?");
			database.getStatement().setInt(1, c.getID());
			
			ResultSet rs = database.getStatement().executeQuery();
			database.getConnection().commit();
			
			if(rs.next())
				b = rs.getBoolean(1);
			course = new Course(c.getID(), c.getProfID(), c.getName(),b);
			course.setActive(!b);
			database.prepareStatement("UPDATE termproject.course SET active = ? WHERE id = ?" );
			if(b) 
				database.getStatement().setBoolean(1, false);
			else
				database.getStatement().setBoolean(1, true);
			database.getStatement().setInt(2, c.getID());
			
			database.getStatement().executeUpdate();
			database.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
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
			a.setID(rs.getInt(1));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void setActive(Assignment a, boolean b){		
		try {
			database = new DatabaseHelper();
			database.prepareStatement("UPDATE termproject.assignment SET active = ? WHERE id = ?");
			database.getStatement().setBoolean(1,  b);
			database.getStatement().setInt(2, a.getID());
			
			database.getStatement().executeUpdate();
			database.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void checkPassword(LoginInfo l){
		
		try {
			database = new DatabaseHelper();
			database.prepareStatement("SELECT * FROM termproject.user WHERE id = ?");
			database.getStatement().setInt(1,  l.getUsername());
			
			ResultSet rs = database.getStatement().executeQuery();
			database.getConnection().commit();
			
			if(rs.next() && (rs.getString(2).equals(l.getPassword())))
				l.authenticate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void closeConnection()
	{
		try {
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
