package frontend.components.BoxItems;

import java.awt.Color;
import java.awt.Font;

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
		viewSubmissions.setBackground(Color.black);
		viewSubmissions.setForeground(Color.white);
		viewSubmissions.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		setActive = new JButton("Set Active");
		setActive.addActionListener(listener);
		setActive.setBackground(Color.black);
		setActive.setForeground(Color.white);
		setActive.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		add(viewSubmissions);
		add(setActive);
		}
		else{
			submit = new JButton("Upload Submission");
			submit.addActionListener(listener);
			submit.setBackground(Color.black);
			submit.setForeground(Color.white);
			submit.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
			
			viewGrade = new JButton("View Grade");
			viewGrade.addActionListener(listener);
			viewGrade.setBackground(Color.black);
			viewGrade.setForeground(Color.white);
			viewGrade.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
			
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
	
	public JButton getSetActive()
	{
		return setActive;
	}
}

