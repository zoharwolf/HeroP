package com.zohar.herop.editor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.zohar.herop.common.EditorUtil;

public class BiontPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public BiontPanel(){
		this.setLayout(new BorderLayout(5,5));
		
		// item list
		String[] itemArr = {"Slime", "Bat", "Fiary"};
		JList itemList = new JList(itemArr);
		
		JPanel itemListPan = new JPanel();
		TitledBorder itemTitle =new TitledBorder("Biont List");
		itemListPan.setBorder(itemTitle);
		itemListPan.add(itemList);
		EditorUtil.fixSize(itemList, 80, null);
		
		this.add(itemListPan, BorderLayout.WEST);
		
		// info table
		JPanel infoPan = new JPanel();

		JPanel row1Panel = new JPanel();
		JPanel row2Panel = new JPanel();
		row1Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
		row2Panel.setLayout(new GridLayout(0,1));
		
		row1Panel.add(new JLabel("Name"));
		row1Panel.add(Box.createHorizontalStrut(3000));
		row1Panel.add(new JTextField(10));
		row1Panel.add(Box.createHorizontalStrut(3000));
		row1Panel.add(new JLabel("Description"));
		row1Panel.add(Box.createHorizontalStrut(3000));
		row1Panel.add(new JTextField(20));
		
		TitledBorder dataTitle =new TitledBorder("Data Edit");
		infoPan.setBorder(dataTitle);
		infoPan.setLayout(new GridLayout(1,2));
		infoPan.add(row1Panel);
		infoPan.add(row2Panel);
		
		this.add(infoPan, BorderLayout.CENTER);
	}
}
