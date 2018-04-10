package frontend.components.BoxItems;

import javax.swing.JButton;

import backend.Listeners.AssignmentItemListener;
import shareddata.Assignment;

public class AssignmentItem extends BoxItem{
	private JButton viewSubmissions;
	private AssignmentItemListener listener;
	private Assignment assignment;
	
	public AssignmentItem(Assignment a){
		super(a.getTitle());
		listener = new AssignmentItemListener();
		assignment = a;
		viewSubmissions = new JButton("View Submissions");
		viewSubmissions.addActionListener(listener);
		add(viewSubmissions);
	}
	
	public Assignment getAssignment(){
		return assignment;
	}
	
	public void setAssignment(Assignment a){
		assignment = a;
	}
}

