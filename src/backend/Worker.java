package backend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import shareddata.*;

public class Worker implements Runnable {
	
	@SuppressWarnings("unused")
	private Socket accessSock;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private DatabaseHelper database;
	
	public Worker(Socket socket)
	{
		accessSock = socket;
		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run()
	{
		while(true)
		{
			try {
				database = new DatabaseHelper();
				Object input = in.readObject();
				
				if(input instanceof Course) {
					Course course = (Course)input;
					String s = (String)in.readObject();
					if(s.contains("setCourseActivity"))
					{
						sendObject(database.setActive(course));
					}
					else if(s.contains("createcourse"))
					{
						sendObject(database.addCourse(course));
					}

					else if(s.contains("getmails"))
					{
						sendObject(database.getStudentEmails(course));
					}
					else if(s.contains("getstudents"))
					{
						sendObject(database.getStudentsEnrolled(course));
					}
					else if(s.contains("getassignments"))
					{
						sendObject(database.getAssignments(course));
					}
					else if(s.contains("unenrolledStudents"))
					{
						sendObject(database.getStudentsNotEnrolled(course));
					}
				}
				if(input instanceof LoginInfo)
				{
				LoginInfo info = (LoginInfo) input;
				database.checkPassword(info);
				sendObject(info);
				}
				if(input instanceof String)
				{
					String s = (String) input;
					if(s.contains("getuser"))
					{
						String [] instruction = s.split(" ");
						sendObject(database.searchUserID(Integer.parseInt(instruction[1])));
					}
				}
				if(input instanceof Professor)
				{
					Professor prof = (Professor) input;
					String s = (String) in.readObject();
					if(s.contains("getcourses"))
					{
						sendObject(database.browseCourses(prof.getId()));
					}
				}
				if(input instanceof Student)
				{
					Student student = (Student) input;
					String s = (String) in.readObject();
					if(s.contains(("getcourses")))
					{
						sendObject(database.browseCourses(student.getId()));
					}
				}

				if(input instanceof Assignment)
				{
					Assignment assign = (Assignment) input;
					String s = (String) in.readObject();
					if(s.contains("setactive"))
					{
						sendObject(database.setActive(assign));
					}
				}

				if(input instanceof Email){
					Email email = (Email) input;
					String s = (String) in.readObject();
					if(s.contains("sendEmail")
					{
						for(int i = 0; i < email.getRecipients().size(); i ++){
							new EmailHelper(email.getRecipients().get(i), email.getSubject(), email.getContent());
						}
					}
				}
				
				if(input instanceof StudentEnrollment)
				{
					StudentEnrollment studen = (StudentEnrollment) input;
					String s = (String) in.readObject();
					if(s.contains("unenroll"))
					{
						database.unenroll(studen);
					}
					else
					{
						database.addEnrollment(studen);
					}
				}

			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
				e.printStackTrace();
				closeConnection();
				break;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	public void closeConnection()
	{
		try {
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
