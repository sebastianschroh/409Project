package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frontend.components.*;
import frontend.components.BoxItems.CourseItem;

public class ProfSendEmailListener implements ActionListener {

	private PageNavigatorTest p;
	private CourseItem c;
	
	public ProfSendEmailListener(PageNavigatorTest p, CourseItem c)
	{
		this.p = p;
		this.c = c;
	}
	
	public void actionPerformed(ActionEvent arg1)
	{
		ProfEmailCreator emailCreator = new ProfEmailCreator(p, c);
		emailCreator.getButton().addActionListener(new CreateProfEmailListener(p, c, emailCreator));
	}
}
