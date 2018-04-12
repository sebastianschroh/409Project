package backend.Listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import frontend.components.*;
import frontend.components.BoxItems.*;
import shareddata.Assignment;

public class AssignmentItemListener implements ActionListener{
	
	private PageNavigatorTest p;
	
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
}
