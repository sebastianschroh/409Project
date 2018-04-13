package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import backend.EmailHelper;
import frontend.components.PageNavigatorTest;
import frontend.components.ProfEmailCreator;
import frontend.components.StudentEmailCreator;
import frontend.components.BoxItems.CourseItem;
import shareddata.Course;
import shareddata.Email;
import shareddata.Student;

public class CreateProfEmailListener implements ActionListener {
	
	private CourseItem c;
	private ProfEmailCreator e;
	private PageNavigatorTest p;
	public CreateProfEmailListener(PageNavigatorTest p, CourseItem c, ProfEmailCreator e)
	{
		this.c = c;
		this.e = e;
		this.p = p;
	}

	public void actionPerformed(ActionEvent arg0) {
		String subject = e.getSubject();
		String message = e.getMessage();
		String profEmail = c.getProfEmail();
		ArrayList<String> list = new ArrayList<String>();
		list.add(profEmail);
		Email email = new Email(null, list, subject, message);
		p.sendObject(email);
		p.sendObject("emailprof");
		
		e.getFrame().dispose();
	}

}
