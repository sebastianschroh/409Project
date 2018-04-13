package frontend.components.BoxItems;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import backend.Listeners.SubmissionItemListener;
import frontend.components.PageNavigatorTest;
import shareddata.Submission;

@SuppressWarnings("serial")
public class SubmissionItem extends BoxItem{
	private SubmissionItemListener listener;
	private JButton grade;
	private Submission submission;
	
	private JLabel lblGrade;
	private JTextField txtGrade;
	
	public SubmissionItem(Submission s, PageNavigatorTest p, AssignmentItem a){
		
		super(s.getTitle());
		submission = s;
		listener = new SubmissionItemListener(this,a,p);
				
		grade = new JButton("Grade Submission");
		grade.setBackground(Color.black);
		grade.setForeground(Color.white);
		grade.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		grade.addActionListener(listener);
		
		txtGrade = new JTextField(3);
		
		
		lblGrade = new JLabel("");
		lblGrade.setText(Integer.toString(s.getGrade()) +"%");
		lblGrade.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		if(s.getGrade() >= 50)
			lblGrade.setForeground(Color.GREEN);
		else
			lblGrade.setForeground(Color.RED);
		
		add(txtGrade);
		add(grade);
		add(lblGrade);
	}
	
	public Submission getSubmission(){
		return submission;
	}
	
	public void setSubmission(Submission s){
		submission = s;
	}
	
	public JButton getGradeButton()
	{
		return grade;
	}
	
	public String getGrade()
	{
		return txtGrade.getText();
	}
	
	public void setGrade(String s)
	{
		lblGrade.setText(s +"%");
	}
}
