package shareddata;

import java.io.Serializable;

public class Grade implements Serializable{
	
	private int student_id;
	private int grade;
	private String student_name;
	private String assign_name;
	
	public Grade(int id, int grade, String name, String assign){
		student_id = id;
		this.grade = grade;
		student_name = name;
		assign_name = assign;
	}
	
	public void setStudentID(int i){
		student_id = i;
	}
	
	public void setGrade(int i){
		grade = i;
	}
	
	public void setStudentName(String s){
		student_name = s;
	}
	
	public void setAssignmentName(String s){
		assign_name = s;
	}
	
	public int getStudentID(){
		return student_id;
	}
	
	public int getGrade(){
		return grade;
	}
	
	public String getStudentName(){
		return student_name;
	}
	
	public String getAssignmentName(){
		return assign_name;
	}
	
}
