package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frontend.components.EmailCreator;
import frontend.components.PageNavigatorTest;
import shareddata.Course;

public class CreateEmailListener implements ActionListener {
	
	private PageNavigatorTest p;
	private EmailCreator e;
	
	public CreateEmailListener(PageNavigatorTest p, EmailCreator e)
	{
		this.p = p;
		this.e = e;
	}

	public void actionPerformed(ActionEvent arg0) {
		String subject = e.getSubject();
		String message = e.getMessage();
		Course co = new Course(0, p.getUser().getId(), temp,false);
		p.sendObject(co);
		p.sendObject("createcourse");
		Course t = (Course) p.readObject();
		p.getCourseList().add(t);
		
		c.getFrame().dispose();
	}

}
