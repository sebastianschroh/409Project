package frontend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
	
	public static void main(String args[])
	{
		LoginWindow login = new LoginWindow();
	}
}
