package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import frontend.components.*;
import shareddata.Course;

public class AddCourseListener implements ActionListener {

	private PageNavigatorTest p;
	
	public AddCourseListener(PageNavigatorTest p)
	{
		this.p = p;
	}
	
	public void actionPerformed(ActionEvent arg1)
	{
		CourseCreator coursecreator = new CourseCreator();
		coursecreator.getButton().addActionListener(new CreateCourseListener(p,coursecreator));
	}
}
