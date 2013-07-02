package com.zohar.herop.editor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class BiontPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public BiontPanel(){
		this.setLayout(new BorderLayout(5,5));
		
		// item list
		TitledBorder itemTitle =new TitledBorder("Biont List");
		String[] itemArr = {"Slime", "Bat", "Fiary"};
		JList itemList = new JList(itemArr);
		JPanel itemListPan = new JPanel();
		itemListPan.setBorder(itemTitle);
		itemListPan.add(itemList);
		itemList.setMinimumSize(new Dimension(300, 300));
		
		this.add(itemListPan, BorderLayout.WEST);
		
		// info table
		JPanel infoPan = new JPanel();
		
		this.add(infoPan, BorderLayout.CENTER);
	}
}
