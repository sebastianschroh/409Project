package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.io.*;


public class LoginWindow extends JFrame{
	
	public LoginWindow()
	{
		this.setTitle("Login");
		this.setLayout(new BorderLayout());
		this.setSize(800,500);
		this.setResizable(false);
		JPanel center = new JPanel();
		center.setBorder(new EmptyBorder(20,20,20,20));
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		JLabel d3l = new JLabel(new ImageIcon("C:/School/softeng_yr2/ENSF409/TermProject/409Project/Desire3Learn.png"));
		center.add(d3l, Component.CENTER_ALIGNMENT);
		this.add(center, BorderLayout.CENTER);
		//center.add(Box.createVeritcalGlue());
		JPanel pane1 = new JPanel();
		pane1.setLayout(new FlowLayout());
		pane1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pane1.add(new JLabel("Username: "), Component.LEFT_ALIGNMENT);
		pane1.add(new JTextField(20));
		center.add(pane1, Component.BOTTOM_ALIGNMENT);
		center.add(Box.createHorizontalGlue());
		this.add(center, BorderLayout.CENTER);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//JFrame frame = (JFrame) e.getSource();
				int result = JOptionPane.showConfirmDialog((JFrame) e.getSource(), "Are you sure you want to exit the application?",
						"Exit Application", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION)
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
	}
	
	public static void main(String [] args)
	{
		LoginWindow yeet = new LoginWindow();
		yeet.setVisible(true);
		
	}
}