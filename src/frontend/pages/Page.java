package frontend.pages;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import shareddata.Assignment;

public class Page extends JFrame {
	private JLabel courseName;
	private JPanel coursePanel;
	private JScrollPane scrollPane;
	private ArrayList<Assignment> assignments;
	
	public Page(String s){
		this.setLayout(new BorderLayout());
		courseName = new JLabel(s);
		courseName.setHorizontalAlignment(JLabel.CENTER);
		courseName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(courseName, BorderLayout.NORTH);
		
		scrollPane.setViewportView(coursePanel);
		this.add(scrollPane, BorderLayout.CENTER);
		this.setSize(400, 400);
		this.setVisible(true);
	}
}
