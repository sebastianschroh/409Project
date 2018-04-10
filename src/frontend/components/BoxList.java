package frontend.components;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class BoxList extends JPanel {
	private JPanel listPanel;
	private JScrollPane scrollPanel;
	
	public BoxList(){
		listPanel = new JPanel();
		BoxLayout layout = new BoxLayout(listPanel, BoxLayout.Y_AXIS);
		listPanel.setLayout(layout);
		scrollPanel = new JScrollPane(listPanel);
	}
	
	public void addItem(BoxItem b){
		
	}
}