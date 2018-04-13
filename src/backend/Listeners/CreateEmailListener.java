package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import backend.EmailHelper;
import frontend.components.PageNavigatorTest;
import frontend.components.StudentEmailCreator;
import frontend.components.BoxItems.CourseItem;
import shareddata.Course;
import shareddata.Email;
import shareddata.Student;

public class CreateEmailListener implements ActionListener {
	
	private CourseItem c;
	private StudentEmailCreator e;
	private PageNavigatorTest p;
	
	public CreateEmailListener(PageNavigatorTest p, CourseItem c, StudentEmailCreator e)
	{
		this.c = c;
		this.e = e;
		this.p = p;
	}

	public void actionPerformed(ActionEvent arg0) {
		String subject = e.getSubject();
		String message = e.getMessage();
		ArrayList<String> list = c.getEmails();
		Email email = new Email(null, list, subject, message);
		p.sendObject(email);
		
		e.getFrame().dispose();
	}

}
