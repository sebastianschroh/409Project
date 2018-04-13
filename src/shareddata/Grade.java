package shareddata;

import java.io.Serializable;

public class Grade implements Serializable{
	
	private static final long serialVersionUID = 432;
	private int id;
	private int assign_id;
	private int student_id;
	private int course_id;
	private int grade;
	
	public Grade(int id,int assign_id, int student_id, int course_id, int grade){
		student_id = id;
		this.grade = grade;
		this.assign_id = assign_id;
		this.student_id = student_id;
		this.course_id = course_id;
	}
	
	public void setStudentID(int i){
		student_id = i;
	}
	
	public void setGrade(int i){
		grade = i;
	}

	public int getStudentID(){
		return student_id;
	}
	
	public int getGrade(){
		return grade;
	}
	
	public void setID(int id){
		this.id = id;
	}
	public int getID(){
		return id;
	}
	
	public void setAssignID(int id){
		assign_id = id;
	}
	public int getAssignID(){
		return assign_id;
	}
	public void setCourseID(int id){
		course_id = id;
	}
	public int getCourseID(){
		return course_id;
	}
}
