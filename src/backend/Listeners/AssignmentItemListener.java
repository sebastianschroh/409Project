package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import frontend.components.*;
import frontend.components.BoxItems.*;

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
		
		if(a.getSource() == a.get)
	}
}
