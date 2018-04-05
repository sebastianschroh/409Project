package shareddata;

import java.io.Serializable;

public class Assignment implements Serializable{

	private static final long serialVersionUID = 69;
	private int id;
	private int course_id;
	private String title;
	private String path;
	private boolean active;
	private String due_date;
	
	public Assignment(int id, int course_id, String title, String path, String due_date){
		this.id = id;
		this.course_id = course_id;
		this.title = title;
		this.path = path;
		active = true;
		this.due_date = due_date;
	}
	
	public void setID(int i){
		id = i;
	}
	
	public void setCourseID(int i){
		course_id = i;
	}
	
	public void setTitle(String s){
		title = s;
	}
	
	public void setPath(String s){
		path = s;
	}
	
	public void setActive(boolean b){
		active = b;
	}
	
	public void setDueDate(String s){
		due_date = s;
	}
	
	public int getID(){
		return id;
	}
	
	public int getCourseID(){
		return course_id;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getPath(){
		return path;
	}
	
	public boolean getStatus(){
		return active;
	}
	
	public String getDueDate(){
		return due_date;
	}
}
