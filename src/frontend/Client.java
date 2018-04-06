package frontend;
	
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import frontend.components.PageNavigatorTest;
import shareddata.LoginInfo;

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
		LoginWindow login = new LoginWindow(in, out);
		while(!login.correctInfo())
		{
			int i = 0;
		}
		login.getFrame().dispose();
		System.out.println("hello");
		PageNavigatorTest p = new PageNavigatorTest(in, out);
	}
	
	public static void main(String args[])
	{
		Client client = new Client("localhost", 6969);
		client.communicate();
	}
}
