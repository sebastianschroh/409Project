package frontend.components.BoxItems;

import javax.swing.JButton;

import backend.Listeners.SubmissionItemListener;
import shareddata.Submission;

public class SubmissionItem extends BoxItem{
	private SubmissionItemListener listener;
	private JButton grade;
	private Submission submission;
	public SubmissionItem(Submission s){
		
		super(s.getTitle());
		submission = s;
		listener = new SubmissionItemListener();
		grade = new JButton("Grade Submission");
		grade.addActionListener(listener);
		add(grade);
	}
	
	public Submission getSubmission(){
		return submission;
	}
	
	public void setSubmission(Submission s){
		submission = s;
	}
}
