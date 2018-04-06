package backend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import shareddata.Assignment;
import shareddata.Course;

import shareddata.LoginInfo;
import shareddata.Professor;
import shareddata.Student;
import shareddata.StudentEnrollment;
import shareddata.User;

public class Server {
	
	private DatabaseHelper database;

	private ServerSocket serverSock;
	private ExecutorService pool;
	
	
	
	public Server(int portNumber)
	{
		try
		{
			serverSock = new ServerSocket(portNumber);
			pool = Executors.newCachedThreadPool();
			
		} catch (IOException e)
		{
			System.err.println("Error in server construction");
		}
	}
	
	public void communicate()
	{
		while(true)
		{
			
				try {
					Worker w = new Worker(serverSock.accept());
					pool.execute(w);
				} catch (IOException e) {
					pool.shutdown();
				}
		}
	}
	
	public static void main (String [] args){
		
		Server server = new Server(6969);
		server.communicate();
		//Assignment as = new Assignment(0, 420, "SMOKE W33D Pt2. The weedening", "NO PATH NIBBA", "UR MOMS BIRTHDAY");
		//server.uploadAssign(as);
		//System.out.println(as.getID());
	}
}

