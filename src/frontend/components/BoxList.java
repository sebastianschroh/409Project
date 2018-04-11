package frontend.components;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import frontend.components.BoxItems.BoxItem;

import javax.swing.JScrollPane;

public class BoxList extends JPanel {
	private JPanel listPanel;
	private JScrollPane scrollPanel;
	private ArrayList<BoxItem> itemList;
	
	public BoxList(){
		itemList = new ArrayList<BoxItem>();
		listPanel = new JPanel();
		BoxLayout layout = new BoxLayout(listPanel, BoxLayout.Y_AXIS);
		listPanel.setLayout(layout);
		scrollPanel = new JScrollPane(listPanel);
	}
	
	public void updateList(){
		listPanel.removeAll();
		for(int i = 0; i < itemList.size(); i ++)
			listPanel.add(itemList.get(i));
		listPanel.revalidate();
	}
	
	public void addItem(BoxItem b){
		itemList.add(b);
	}
	
	public void setItems(ArrayList<BoxItem> list){
		itemList = list;
	}
}