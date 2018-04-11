package frontend.components.BoxItems;

import javax.swing.JButton;

import backend.Listeners.AssignmentItemListener;
import shareddata.Assignment;

public class AssignmentItem extends BoxItem{
	private JButton viewSubmissions, setActive, submit, viewGrade;
	private AssignmentItemListener listener;
	private Assignment assignment;
	
	public AssignmentItem(Assignment a, boolean isProf){
		super(a.getTitle());
		listener = new AssignmentItemListener();
		assignment = a;
		if(isProf){
		viewSubmissions = new JButton("View Submissions");
		viewSubmissions.addActionListener(listener);
		setActive = new JButton("Set Active");
		setActive.addActionListener(listener);
		add(viewSubmissions);
		add(setActive);
		}
		else{
			submit = new JButton("Upload Submission");
			submit.addActionListener(listener);
			viewGrade = new JButton("View Grade");
			viewGrade.addActionListener(listener);
			add(submit);
			add(viewGrade);
		}
	}
	
	public Assignment getAssignment(){
		return assignment;
	}
	
	public void setAssignment(Assignment a){
		assignment = a;
	}
}

