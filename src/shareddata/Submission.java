package shareddata;

import java.io.Serializable;

public class Submission implements Serializable{
	
	
	private static final long serialVersionUID = 8978;
	private int id;
	private int assign_id;
	private int student_id;
	private String path;
	private int grade;
	private String comment;
	private String title;
	private String timestamp;
	
	public Submission(int id, int assign_id, int student_id, String path, String title, String timestamp){
		this.id = id;
		this.assign_id = assign_id;
		this.student_id = student_id;
		this.path = path;
		grade = 0;
		comment = new String();
		this.title = title;
		this.timestamp = timestamp;
	}
	
	public void setId(int i){
		id = i;
	}
	
	public void setAssignID(int i){
		assign_id = i;
	}
	
	public void setStudentID(int i){
		student_id = i;
	}
	
	public void setPath(String s){
		path = s;
	}
	
	public void setGrade(int i){
		grade = i;
	}
	
	public void setComment(String s){
		comment = s;
	}
	
	public void setTitle(String s){
		title = s;
	}
	
	public void setTimestamp(String s){
		timestamp = s;
	}
	
	public int getID(){
		return id;
	}
	
	public int getAssignmentID(){
		return assign_id;
	}
	
	public int getStudentID(){
		return student_id;
	}
	
	public String getPath(){
		return path;
	}
	
	public int getGrade(){
		return grade;
	}
	
	public String getComment(){
		return comment;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getTimestamp(){
		return timestamp;
	}
}
