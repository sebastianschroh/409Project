package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import backend.EmailHelper;
import frontend.components.PageNavigatorTest;
import frontend.components.StudentEmailCreator;
import frontend.components.BoxItems.CourseItem;
import shareddata.Course;
import shareddata.Student;

public class CreateEmailListener implements ActionListener {
	
	private CourseItem c;
	private StudentEmailCreator e;
	
	public CreateEmailListener(CourseItem c, StudentEmailCreator e)
	{
		this.c = c;
		this.e = e;
	}

	public void actionPerformed(ActionEvent arg0) {
		String subject = e.getSubject();
		String message = e.getMessage();
		ArrayList<String> list = c.getEmails();
		for(int i = 1; i < list.size(); i ++){
			EmailHelper helper = new EmailHelper(list.get(i).get)
		}
		p.sendObject(co);
		p.sendObject("createcourse");
		Course t = (Course) p.readObject();
		p.getCourseList().add(t);
		
		c.getFrame().dispose();
	}

}
