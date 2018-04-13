package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frontend.components.*;
import frontend.components.BoxItems.*;

public class SubmissionItemListener implements ActionListener{
	
	private SubmissionItem s;
	private AssignmentItem a;
	private PageNavigatorTest p;
	
	public SubmissionItemListener(SubmissionItem s, AssignmentItem a, PageNavigatorTest p)
	{
		this.s = s;
		this.a = a;
		this.p = p;
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == s.getGradeButton())
		{
			grade();
		}
	}
	
	public void grade()
	{
		
	}

}
