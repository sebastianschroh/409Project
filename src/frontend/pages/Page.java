package frontend.pages;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import shareddata.Assignment;

public class Page extends JPanel {
	private JLabel courseName;
	private JPanel coursePanel;
	private JScrollPane scrollPane;
	private ArrayList<Assignment> assignments;
	
	public Page(String s){
		this.setLayout(new BorderLayout());
		scrollPane = new JScrollPane();
		courseName = new JLabel(s);
		courseName.setHorizontalAlignment(JLabel.CENTER);
		courseName.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		this.add(courseName, BorderLayout.CENTER);
		coursePanel = new JPanel();
		coursePanel.setLayout(new BoxLayout(coursePanel, BoxLayout.Y_AXIS));
		//for(int i = 0; i < assignments.size(); i ++)
//		scrollPane.setViewportView(coursePanel);
//		this.add(scrollPane, BorderLayout.CENTER);
		this.setSize(400, 400);
		this.setVisible(true);
	}
}
