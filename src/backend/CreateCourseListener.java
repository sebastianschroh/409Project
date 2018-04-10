package backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frontend.components.CourseCreator;
import frontend.components.PageNavigatorTest;
import shareddata.Course;

public class CreateCourseListener implements ActionListener {
	
	private PageNavigatorTest p;
	private CourseCreator c;
	
	public CreateCourseListener(PageNavigatorTest p, CourseCreator c)
	{
		this.p = p;
		this.c = c;
	}

	public void actionPerformed(ActionEvent arg0) {
		String temp = c.getTextfieldText();
		Course co = new Course(0, p.getProfessor().getId(), temp,false);
		p.sendObject(co);
		p.sendObject("createcourse");
		Course t = (Course) p.readObject();
		p.getCourseList().add(t);
		
		c.getFrame().dispose();
	}

}
