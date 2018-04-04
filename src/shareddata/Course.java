package shareddata;

import java.io.Serializable;

public class Course implements Serializable{
	private int id;
	private int prof_id;
	private String name;
	private boolean active;
	
	public Course(int id, int prof_id, String name){
		this.id = id;
		this.prof_id = prof_id;
		this.name = name;
		active = true;
	}
	
	public void setID(int i){
		id = i;
	}
	
	public void setProfID(int i){
		prof_id = i;
	}
	
	public void setName(String s){
		name = s;
	}
	
	public void setActive(boolean b){
		active = b;
	}
	
	public int getID(){
		return id;
	}
	
	public int getProfID(){
		return prof_id;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean getStatus(){
		return active;
	}
}

