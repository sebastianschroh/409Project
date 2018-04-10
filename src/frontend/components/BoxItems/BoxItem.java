package frontend.components.BoxItems;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoxItem extends JPanel{
	private JLabel label;
	
	public BoxItem(String s){
		setLayout(new FlowLayout());
		label = new JLabel(s);
		add(label);
	}
}
