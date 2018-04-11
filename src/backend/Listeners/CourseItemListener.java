package backend.Listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import frontend.components.BoxItems.CourseItem;
import frontend.components.PageNavigatorTest;
import shareddata.Course;

public class CourseItemListener implements ActionListener{

	private CourseItem c;
	private PageNavigatorTest p;
	
	public CourseItemListener(CourseItem c, PageNavigatorTest p)
	{
		this.c = c;
		this.p = p;
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == c.getActive())
		{
			activate();
		}
//		if(e.getSource() == c.getView())
//		{
//			view();
//		}
	}

	
	public void activate()
	{
		p.sendObject(c.getCourse());
		p.sendObject("setCourseActivity");
		Course course = null;
		course = (Course) p.readObject();
		c.getCourse().setActive(course.getStatus());
		if(course.getStatus() == true)
		{
			c.getActive().setForeground(Color.white);
		}
		else
		{
			c.getActive().setForeground(Color.red);
		}
	}

}
