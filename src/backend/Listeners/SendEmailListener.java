package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frontend.components.*;
import frontend.components.BoxItems.CourseItem;

public class SendEmailListener implements ActionListener {

	private PageNavigatorTest p;
	private CourseItem c;
	
	public SendEmailListener(PageNavigatorTest p, CourseItem c)
	{
		this.p = p;
		this.c = c;
	}
	
	public void actionPerformed(ActionEvent arg1)
	{
		StudentEmailCreator emailCreator = new StudentEmailCreator();
		emailCreator.getButton().addActionListener(new CreateEmailListener(p,c, emailCreator));
	}
}
