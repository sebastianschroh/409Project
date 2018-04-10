package frontend.pages;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Page extends JFrame {
	
	public Page(String s){
		this.setLayout(new BorderLayout());
		this.add(new JLabel(s), BorderLayout.CENTER);
		this.setSize(400, 400);
		this.setVisible(true);
	}
}
