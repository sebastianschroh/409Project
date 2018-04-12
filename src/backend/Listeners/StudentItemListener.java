package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import frontend.components.BoxItems.*;
import frontend.components.*;
import shareddata.*;

public class StudentItemListener implements ActionListener{
	
	private StudentItem s;
	private CourseItem c;
	private PageNavigatorTest p;
	
	public StudentItemListener(StudentItem s, CourseItem c, PageNavigatorTest p)
	{
		this.s = s;
		this.c = c;
		this.p = p;
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == s.getUnenroll())
		{
			unenroll();
		}
	}
	
	public void unenroll()
	{
		StudentEnrollment s = new StudentEnrollment(this.s.getStudent().getId(), c.getCourse().getID());
		p.sendObject(s);
		p.sendObject("unenroll");
		p.sendObject(c.getCourse());
		p.sendObject("getstudents");
		c.setStudentList((ArrayList<Student>) p.readObject());
	}
	
	public void enroll()
	{
		p.sendObject(c.getCourse());
		p.sendObject("getstudents");
		c.setStudentList((ArrayList<Student>) p.readObject());
	}

}
