package shareddata;

import java.io.Serializable;

public class LoginInfo implements Serializable{
	
	private static final long serialVersionUID = 420;
	private int username;
	private String password;
	
	public LoginInfo(int name, String pass){
		username = name;
		password = pass;
	}
	
	public void setUsername(int i){
		username = i;
	}
	
	public void setPassword(String s){
		password = s;
	}
	
	public int getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
}
