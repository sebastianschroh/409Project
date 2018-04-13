package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frontend.components.*;
import frontend.components.BoxItems.CourseItem;
import shareddata.Assignment;

public class CreateAssignmentListener implements ActionListener {

	private PageNavigatorTest p;
	private AssignmentCreator a;
	private CourseItem c;
	
	public CreateAssignmentListener(AssignmentCreator a, PageNavigatorTest p, CourseItem c)
	{
		this.a = a;
		this.p = p;
		this.c = c;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == a.getButton())
		{
			String title = a.getTitle();
			String path = a.getPath();
			String duedate = a.getDueDate();
			Assignment assign = new Assignment(0, c.getCourse().getID(),title,path,false,duedate);
			c.getAssignmentList().add(assign);
			p.sendObject(assign);
			p.sendObject("addAssign");
			
			a.getFrame().dispose();
			
		}
	}

}
