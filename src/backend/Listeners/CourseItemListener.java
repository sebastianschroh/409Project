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
		if(e.getSource() == c.getEmailStudents()){
			emailStudents();
		}
		if(e.getSource() == c.getViewAssignments())
		{
			viewAssignments();
		}
		if(e.getSource() == c.getAddStudents())
		{
			addStudents();
		}

		if(e.getSource() == c.getEmailProf()){
			emailProf();
		}
		if(e.getSource() == c.getAddAssignment())
		{
			addAssignment();

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
		c.setEnrolledStudents();
		p.setHoldPanel(p.getHoldPanel());
		p.getHoldPanel().removeAll();
		for(int i = 0; i < c.getStudentList().size(); i++)
		{
			StudentItem temp = new StudentItem(c.getStudentList().get(i),this.p,this.c,'u');
			p.getHoldPanel().add(temp);
		}
		
		p.getHoldPanel().revalidate();
		p.getHoldPanel().repaint();
	}
	
	public void viewAssignments()
	{
		
			p.setHoldPanel(p.getHoldPanel());
			p.getHoldPanel().removeAll();
			for(int i = 0; i < c.getAssignmentList().size(); i++)
			{
				AssignmentItem temp = new AssignmentItem(c.getAssignmentList().get(i),this.p, this.c);
				p.getHoldPanel().add(temp);
			}
		
			p.getHoldPanel().revalidate();
			p.getHoldPanel().repaint();
		
	}
	
	public void emailStudents(){
		@SuppressWarnings("unused")
		StudentEmailCreator emailWindow = new StudentEmailCreator(this.p, this.c);
	}
	public void emailProf(){
		ProfEmailCreator emailWindow = new ProfEmailCreator(this.p, this.c);
	}
	public void addStudents()
	{
		c.setUnenrolledStudents();
		p.setHoldPanel(p.getHoldPanel());
		p.getHoldPanel().removeAll();
		for(int i = 0; i < c.getStudentList().size(); i++)
		{
			StudentItem temp = new StudentItem(c.getStudentList().get(i),this.p,this.c,'e');
			p.getHoldPanel().add(temp);
		}
		
		p.getHoldPanel().revalidate();
		p.getHoldPanel().repaint();
	}
	
	public void addAssignment()
	{
		AssignmentCreator assigncreator = new AssignmentCreator(c,p);
		assigncreator.getButton().addActionListener(new CreateAssignmentListener(assigncreator, this.p, this.c));
	}

}
