package backend.Listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import frontend.components.PageNavigatorTest;
import frontend.components.*;
import frontend.components.BoxItems.*;
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
		if(e.getSource() == c.getViewStudents())
		{
			viewStudents();
		}
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
	
	public void viewStudents()
	{
		p.setHoldPanel(p.getHoldPanel());
		p.getHoldPanel().removeAll();
		for(int i = 0; i < p.getCourseList().size(); i++)
		{
			StudentItem temp = new StudentItem(c.getStudentList().get(i),this.p,'u');
			p.getHoldPanel().add(temp);
		}
		
		p.getHoldPanel().revalidate();
		p.getHoldPanel().repaint();
	}

}
