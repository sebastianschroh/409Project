package backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frontend.components.CourseItem;
import frontend.components.PageNavigatorTest;

public class ViewCourseListener implements ActionListener {

	PageNavigatorTest p;
	
	public ViewCourseListener(PageNavigatorTest p)
	{
		this.p = p;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		p.getHoldPanel().removeAll();

		for(int i = 0; i < p.getCourseList().size(); i++)
		{
			CourseItem temp = new CourseItem(p.getCourseList().get(i),p);
			p.getHoldPanel().add(temp);
		}
		
		p.getHoldPanel().revalidate();
		p.getHoldPanel().repaint();
	}

}
