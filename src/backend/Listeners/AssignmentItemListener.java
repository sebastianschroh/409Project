package backend.Listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import frontend.components.*;
import frontend.components.BoxItems.*;
import shareddata.Assignment;
import shareddata.Grade;

public class AssignmentItemListener implements ActionListener{
	
	private PageNavigatorTest p;
	
	@SuppressWarnings("unused")
	private CourseItem c;
	
	private AssignmentItem a;
	
	public AssignmentItemListener(AssignmentItem a, CourseItem c, PageNavigatorTest p)
	{
		this.a = a;
		this.c = c;
		this.p = p;
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == a.getSetActive())
		{
			setActivity();
		}
		if(e.getSource() == a.getViewSubmissions())
		{
			viewSubmissions();
		}
		if(e.getSource() == a.getSubmit())
		{
			submit();
		}
		if(e.getSource() == a.getViewGrade())
		{
			viewGrade();
		}
	}
	
	public void setActivity()
	{
		p.sendObject(a.getAssignment());
		p.sendObject("setactive");
		Assignment assign = null;
		assign = (Assignment) p.readObject();
		a.getAssignment().setActive(assign.getStatus());
		if(assign.getStatus() == true)
		{
			a.getSetActive().setForeground(Color.white);
		}
		else
		{
			a.getSetActive().setForeground(Color.red);
		}
	}
	
	public void viewSubmissions()
	{
		p.setHoldPanel(p.getHoldPanel());
		p.getHoldPanel().removeAll();
		for(int i = 0; i < a.getSubmissions().size(); i++)
		{
			SubmissionItem temp = new SubmissionItem(a.getSubmissions().get(i),this.p,this.a);
			p.getHoldPanel().add(temp);
		}
		
		p.getHoldPanel().revalidate();
		p.getHoldPanel().repaint();
	}
	
	public void submit()
	{
		SubmissionCreator c = new SubmissionCreator();
		c.getButton().addActionListener(new SubmissionListener(c,a,p));
	}
	
	public void viewGrade()
	{
		p.sendObject(p.getUser());
		p.sendObject(a.getAssignment().getID() +"");
		
		Grade g = (Grade) p.readObject();
		
		int grade = g.getGrade();
		a.setStudentGrade(grade +"");
		if(grade >= 50)
		{
			a.getStudentGrade().setForeground(Color.GREEN);
		}
		else
		{
			a.getStudentGrade().setForeground(Color.RED);
		}
	}
}
