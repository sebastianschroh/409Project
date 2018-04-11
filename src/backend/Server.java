package backend;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

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
	}
}

