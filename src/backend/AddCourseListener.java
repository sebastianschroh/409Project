package backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frontend.components.*;

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
