package frontend;
	
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import frontend.components.PageNavigatorTest;
import shareddata.Professor;
import shareddata.Student;
import shareddata.User;

public class Client {

	private Socket accessSock;
	
	private ObjectInputStream in;
	
	private ObjectOutputStream out;
	
	public Client(String serverName, int portNumber)
	{
		try {
			accessSock = new Socket(serverName, portNumber);
			out = new ObjectOutputStream(accessSock.getOutputStream());
			in = new ObjectInputStream(accessSock.getInputStream());
		} catch(IOException e) {
			
		}
	}
	
	public void communicate()
	{
		login();
	}
	
	public static void main(String args[])
	{
		Client client = new Client("localhost", 6969);
		client.communicate();
	}
	
	public void login()
	{
		LoginWindow login = new LoginWindow(in, out);
		while(!login.correctInfo())
		{
		}
		String id= "" + login.login().getUsername();
		login.getFrame().dispose();
		String s = "getuser " + id;
		sendObject(s);
		try {
			Object user = in.readObject();
			if(user instanceof Student)
			{
				Student student = (Student) user;
				//PageNavigatorTest p = new PageNavigatorTest(in, out, student);
				//p.setName(student.getFirstName() + " " + student.getLastName());
			}
			else if(user instanceof Professor)
			{
				Professor professor = new Professor(((Professor) user).getId(), ((Professor) user).getFirstName(), ((Professor) user).getLastName());
				PageNavigatorTest p = new PageNavigatorTest(in,out, professor);
				p.setName(professor.getFirstName() + " " + professor.getLastName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
}
