package shareddata;

import java.io.Serializable;

public class User implements Serializable{
	
	private int id;
	private String firstName;
	private String lastName;
	
	public User(int id, String firstName, String lastName){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setId(int i){
		id = i;
	}
	
	public void setFirstName(String s){
		firstName = s;
	}
	
	public void setLastName(String s){
		lastName = s;
	}
	
	public int getId(){
		return id;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
}
