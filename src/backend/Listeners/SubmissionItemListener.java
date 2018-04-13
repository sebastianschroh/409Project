package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frontend.components.*;
import frontend.components.BoxItems.*;
import shareddata.Grade;

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
		String string = s.getGrade();
		if(string.matches("[0-9]+") && string.length() > 0 && string.length() < 4)
		{
			
			Grade grade = new Grade(0,a.getAssignment().getID(),s.getSubmission().getStudentID(),a.getAssignment().getCourseID(),Integer.parseInt(string));
			s.getSubmission().setGrade(Integer.parseInt(string));
			p.sendObject(grade);
			p.sendObject("grade");
			
			s.setGrade(string);
		}
	}

}
