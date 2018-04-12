package shareddata;

import java.io.Serializable;

public class StudentEnrollment implements Serializable{
	
	private static final long serialVersionUID = 4477;
	private int id;
	private int student_id;
	private int course_id;
	
	public StudentEnrollment(int sid, int cid){
		student_id = sid;
		course_id = cid;
	}
	
	public void setId(int i){
		id = i;
	}
	
	public void setStudentID(int i){
		student_id = i;
	}
	
	public void setCourseID(int i){
		course_id = i;
	}
	
	public int getId(){
		return id;
	}
	
	public int getStudentID(){
		return student_id;
	}
	
	public int getCourseID(){
		return course_id;
	}
	
}
