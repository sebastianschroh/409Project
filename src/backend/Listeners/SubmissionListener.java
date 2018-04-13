package backend.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.Date;

import frontend.components.*;
import frontend.components.BoxItems.*;
import shareddata.Submission;

public class SubmissionListener implements ActionListener {

	
	private PageNavigatorTest p;
	private AssignmentItem a;
	private SubmissionCreator s;

	public SubmissionListener(SubmissionCreator s, AssignmentItem a, PageNavigatorTest p)
	{
		this.s = s;
		this.a = a;
		this.p = p;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String title = s.getTitle();
		String path = s.getPath();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		
		Date date = new Date();
		
		String d = df.format(date);
		
		Submission sub = new Submission(0,a.getAssignment().getID(),p.getUser().getId(),path,title,d);
		
		p.sendObject(sub);
		p.sendObject("submitassignment");
		
		s.getFrame().dispose();
	}

}
