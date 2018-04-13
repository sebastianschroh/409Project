package frontend.components;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import frontend.components.BoxItems.CourseItem;

import javax.swing.JButton;

public class AssignmentCreator {

	private JFrame frame;
	private JButton btnCreate;
	
	private JTextField title;
	private JTextField path;
	private JTextField duedate;

	/**
	 * Create the application.
	 */
	public AssignmentCreator(CourseItem c, PageNavigatorTest p) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateAssignment = new JLabel("Create Assignment");
		lblCreateAssignment.setForeground(Color.WHITE);
		lblCreateAssignment.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblCreateAssignment.setBounds(133, 36, 145, 23);
		frame.getContentPane().add(lblCreateAssignment);
		
		JLabel lblAssignmentTitle = new JLabel("Assignment Title:");
		lblAssignmentTitle.setForeground(Color.WHITE);
		lblAssignmentTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblAssignmentTitle.setBounds(55, 104, 119, 14);
		frame.getContentPane().add(lblAssignmentTitle);
		
		JLabel lblPath = new JLabel("Path: ");
		lblPath.setForeground(Color.WHITE);
		lblPath.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPath.setBounds(137, 130, 37, 14);
		frame.getContentPane().add(lblPath);
		
		JLabel lblDuedate = new JLabel("Due-Date:");
		lblDuedate.setForeground(Color.WHITE);
		lblDuedate.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDuedate.setBounds(108, 156, 66, 14);
		frame.getContentPane().add(lblDuedate);
		
		title = new JTextField();
		title.setBounds(184, 103, 145, 20);
		frame.getContentPane().add(title);
		title.setColumns(10);
		
		path = new JTextField();
		path.setBounds(184, 129, 145, 20);
		frame.getContentPane().add(path);
		path.setColumns(10);
		
		duedate = new JTextField();
		duedate.setBounds(184, 155, 145, 20);
		frame.getContentPane().add(duedate);
		duedate.setColumns(10);
		
		btnCreate = new JButton("Create");
		btnCreate.setBackground(Color.BLACK);
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnCreate.setBounds(240, 210, 89, 23);
		frame.getContentPane().add(btnCreate);
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.setVisible(true);
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	public JButton getButton()
	{
		return btnCreate;
	}
	
	public String getTitle()
	{
		return title.getText();
	}
	
	public String getPath()
	{
		return path.getText();
	}
	
	public String getDueDate()
	{
		return path.getText();
	}
}
