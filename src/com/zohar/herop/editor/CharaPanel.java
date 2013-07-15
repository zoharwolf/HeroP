package com.zohar.herop.editor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.zohar.herop.common.Constant;
import com.zohar.herop.common.EditorUtil;
import com.zohar.herop.common.RegUtil;

public class CharaPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final String FILE_PATH = "D:/Program Files/KAGeXpress/KCRS/Data/scenario/charaData.ks";
	
	private Map<String, Component> compMap = new HashMap<String, Component>(); 
	private List<String> allName = new ArrayList<String>();
	private Map<String, String> allNameFull = new HashMap<String, String>();
	private Map<Integer, List<String>> charInfoMap = new HashMap<Integer, List<String>>();
	
	JList itemList = null;

	public CharaPanel(){
		try{
			this.setLayout(new BorderLayout(5,5));
			
			prepareDate();
			
			// item list
			String[] itemArr = allName.toArray(new String[allName.size()]);
			for (int i=0;i<itemArr.length;i++){
				String fullName = allNameFull.get(itemArr[i]);
				itemArr[i] = i + ". " + fullName;
			}
			itemList = new JList(itemArr);
			itemList.setSelectedIndex(0);
			itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			itemList.addListSelectionListener(new ListSelectionListener(){
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					updateData();
				}
			});
			
			JPanel itemListPan = new JPanel();
			TitledBorder itemTitle =new TitledBorder("Characters");
			itemListPan.setBorder(itemTitle);
			itemListPan.add(new JScrollPane(itemList));
			EditorUtil.fixSize(itemList, 80, null);
			
			this.add(itemListPan, BorderLayout.WEST);
			
			// info table
			JPanel infoPan = new JPanel();
			
			JPanel row1Panel = new JPanel();
			JPanel row2Panel = new JPanel();
			row1Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
			row2Panel.setLayout(new GridLayout(0,1));
			
			
			addTextField(row1Panel, "Name", 10);
			addTextField(row1Panel, "Description", 20);
			
			TitledBorder dataTitle =new TitledBorder("Data Edit");
			infoPan.setBorder(dataTitle);
			infoPan.setLayout(new GridLayout(1,2));
			infoPan.add(row1Panel);
			infoPan.add(row2Panel);
			
			this.add(infoPan, BorderLayout.CENTER);
			
			
			updateData();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// update the data in panel
	protected void updateData() {
		JTextField nameTf = (JTextField) compMap.get("Name");
		int index = itemList.getSelectedIndex();
		String name = allName.get(index);
		String fullName = allNameFull.get(name);
		nameTf.setText(fullName);
	}

	// read data from file
	private void prepareDate() throws Exception {
		File file = new File(FILE_PATH);
		if (file.isFile() && file.exists()){
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();
			while(line!=null){
				System.out.println(line);
				// sf.allName init line
				String sfAllName = RegUtil.regFindByGroup("sf\\.allName=\\[(.*)\\];$", line, 1);
				if (sfAllName!=null){
					String[] nameArr = sfAllName.split("\\s*,\\s*");
					for (String n: nameArr){
						allName.add(n.substring(1, n.length()-1));
					}
				}
				
				// sf.allNameFull dictionary init
				String sfAllNameFull = RegUtil.regFindByGroup("sf\\.allNameFull=%\\[(.*)\\];$", line, 1);
				if (sfAllNameFull!=null){
					String[] nameArr = sfAllNameFull.split("\\s*,\\s*");
					for (String n: nameArr){
						String[] dicArr = n.split("\\s*=>\\s*");
						allNameFull.put(dicArr[0].substring(1, dicArr[0].length()-1), dicArr[1].substring(1, dicArr[1].length()-1));
					}
				}
				
				// f.charInfo data to charInfoMap
				String[] charInfoLine = RegUtil.regFindByGroup("f\\.charInfo\\[(\\d+)\\]=\\[(.*)\\];$", line);
				if (charInfoLine!=null){
					int index = Integer.valueOf(charInfoLine[1]);
					String info = charInfoLine[2];
					String[] infoArr = info.split("\\s*,\\s*");
					
					List<String> infoList = new ArrayList<String>();
					for (String n: infoArr){
						infoList.add(n.substring(1, n.length()-1));
					}
					charInfoMap.put(index, infoList);
				}
				
				line = br.readLine();
			}
		}
	}

	private void addTextField(Container contr, String name, int len){
		contr.add(new JLabel(name));
		contr.add(Box.createHorizontalStrut(Constant.BOX_WIDTH));
		JTextField f = new JTextField(len);
		contr.add(f);
		contr.add(Box.createHorizontalStrut(Constant.BOX_WIDTH));
		
		compMap.put(name, f);
	}
}
