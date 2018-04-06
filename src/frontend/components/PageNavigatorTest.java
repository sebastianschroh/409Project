package frontend.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.CardLayout;
import javax.swing.SwingConstants;

import frontend.Client;
import frontend.LoginWindow;
import shareddata.Course;
import shareddata.LoginInfo;
import shareddata.Professor;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class PageNavigatorTest {

	private JFrame frame;
	private JLabel lblWelcome;
	private Professor professor;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String name;
	private JButton btnYeet;
	/**
	 * Create the application.
	 */
	public PageNavigatorTest(ObjectInputStream in, ObjectOutputStream out, Professor p) {
		this.in = in;
		this.out = out;
		professor = p;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 665);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{19, 737, 0};
		gridBagLayout.rowHeights = new int[]{51, 71, 472, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDesirelearn = new JLabel("Desire3Learn");
		lblDesirelearn.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDesirelearn.setForeground(Color.ORANGE);
		lblDesirelearn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(lblDesirelearn, BorderLayout.WEST);
		
		lblWelcome = new JLabel("Welcome:");
		lblWelcome.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(lblWelcome, BorderLayout.EAST);
		
		btnYeet = new JButton("Yeet");
		panel_1.add(btnYeet, BorderLayout.CENTER);
		btnYeet.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg1)
			{
				System.out.println("yeet");
			}
			
		});
				
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		sendObject((Object)professor);
		sendObject("getcourses");
		ArrayList<Course> course = null;
		try {
			course = (ArrayList<Course>) in.readObject();
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (IOException e) {
					e.printStackTrace();
		}
		JPanel p = new JPanel(new FlowLayout());
		JButton courses = new JButton("set active");
		p.add(courses);
		p.add(new JLabel(course.get(0).getName()));
		panel_2.add(p);
		
		frame.setVisible(true);
		
	}
	
	public void sendObject(Object s)
	{
		try {
		out.writeObject(s);
		out.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void setName(String s)
	{
		lblWelcome.setText("Welcome: " + s);
	}
	
	public void setVisible(boolean b)
	{
		frame.setVisible(b);
	}

	


}
