package shareddata;

import java.io.Serializable;

public class StudentEnrollment implements Serializable{
	
	private static final long serialVersionUID = 4477;
	private int id;
	private int student_id;
	private int course_id;
	private boolean enrolling;
	
	public StudentEnrollment(int id, int sid, int cid, boolean enr){
		this.id = id;
		student_id = sid;
		course_id = cid;
		enrolling = enr;
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
	
	public void setEnrollment(boolean b){
		enrolling = b;
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
	
	public boolean getEnrollment(){
		return enrolling;
	}
}
