package com.zohar.herop.editor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.zohar.herop.common.Constant;
import com.zohar.herop.common.EditorUtil;
import com.zohar.herop.common.RegUtil;
import com.zohar.herop.common.ToolUtil;

public class CharaPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final String FILE_PATH = "F:/program/krkrœ‡πÿ/KCRS/Data/scenario/charaData.ks";
	
	private Map<String, Component> compMap = new HashMap<String, Component>(); 
	private List<String> allName = new ArrayList<String>();
	private Map<String, String> allNameFull = new HashMap<String, String>();
	private Map<Integer, List<String>> charInfoMap = new HashMap<Integer, List<String>>();
	
	@SuppressWarnings("rawtypes")
	JList itemList = null;
	@SuppressWarnings("rawtypes")
	JList infoList = null;
	JTextField nameTf = null;
	JTextArea infoTa = null;

	private int curItemIndex = 0;
	private int curInfoIndex = 0;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CharaPanel(){
		try{
			this.setLayout(new BorderLayout(5,5));
			
			prepareData();
			
			// item list
			String[] itemArr = allName.toArray(new String[allName.size()]);
			for (int i=0;i<itemArr.length;i++){
				String fullName = allNameFull.get(itemArr[i]);
				itemArr[i] = i + ". " + fullName;
			}
			itemList = new JList(itemArr);
			itemList.setSelectedIndex(0);
			curItemIndex = 0;
			itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			itemList.addListSelectionListener(new ListSelectionListener(){
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						saveTempData("itemList");
						updateRightData();
					}
				}
			});
			
			JPanel itemListPan = new JPanel();
			TitledBorder itemTitle =new TitledBorder("Characters");
			itemListPan.setBorder(itemTitle);
			JScrollPane js = new JScrollPane(itemList);
			itemListPan.add(js);
			EditorUtil.fixSize(js, null, 500);
			EditorUtil.fixSize(itemList, 80, null);
			
			this.add(itemListPan, BorderLayout.WEST);
			
			// info table
			JPanel infoPan = new JPanel();
			
			JPanel inputPanel = new JPanel();
			inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			// right part upper input area.
			inputPanel.add(new JLabel("Name"));
			nameTf = new JTextField(20);
			inputPanel.add(nameTf);
			inputPanel.add(new JLabel("  Info"));
			infoTa = new JTextArea(4, 30);
			inputPanel.add(infoTa);
			
			// right part down info List
			infoList = new JList();
			JScrollPane infoJs = new JScrollPane(infoList);
			TitledBorder infoListBorder = new TitledBorder("Information List");
			infoList.setBorder(infoListBorder);
			EditorUtil.fixSize(infoJs, null, 400);
			EditorUtil.fixSize(infoList, 400, null);
			
			// compose right info Panel.
			TitledBorder dataTitle =new TitledBorder("Data Edit");
			infoPan.setBorder(dataTitle);
			infoPan.setLayout(new BorderLayout(5,5));
			infoPan.add(inputPanel, BorderLayout.NORTH);
			infoPan.add(infoList,BorderLayout.CENTER);
			
			this.add(infoPan, BorderLayout.CENTER);
			
			
			updateRightData();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// update the data in right panel
	@SuppressWarnings("unchecked")
	protected void updateRightData() {
		int index = itemList.getSelectedIndex();
		curItemIndex = index;
		curInfoIndex = 0;
		String name = allName.get(index);
		String fullName = allNameFull.get(name);
		nameTf.setText(fullName);
		
		List<String> infoDataList = charInfoMap.get(index);
		String[] infoArr;
		if (infoDataList!=null && infoDataList.size()>0){
			infoArr = infoDataList.toArray(new String[infoDataList.size()]);
			for (int i=0;i<infoArr.length;i++){
				infoArr[i] = i + ". " + infoArr[i];
			}
		} else {
			infoArr = new String[1];
			infoArr[0] = "";
		}
		ListSelectionListener[] listeners = infoList.getListSelectionListeners();
		for (ListSelectionListener listener: listeners){
			infoList.removeListSelectionListener(listener);
		}
		infoList.setListData(infoArr);
		infoList.setSelectedIndex(0);
		infoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		infoList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					saveTempData("infoList");
					updateDescriptData();
				}
			}
		});
		
		updateDescriptData();
	}

	// save data to program instance.
	protected void saveTempData(String text) {
		System.out.println(text+" curItemIndex: "+curItemIndex+" curInfoIndex: "+curInfoIndex);
		List<String> curInfoList = charInfoMap.get(curItemIndex);
		String desc = infoTa.getText();
		if (!ToolUtil.isNullOrEmpty(curInfoList)){
			curInfoList.set(curInfoIndex, desc);
		}
	}

	// update description text area.
	protected void updateDescriptData() {
		int index = infoList.getSelectedIndex();
		int itemIndex = curItemIndex;
		List<String> descList = charInfoMap.get(itemIndex);
		if (index<0){
			index=0;
			infoList.setSelectedIndex(index);
		}
		curInfoIndex = index;
		if (!ToolUtil.isNullOrEmpty(descList)){
			String desc = descList.get(index);
			infoTa.setText(desc);
		} else{
			infoTa.setText("");
		}
	}

	// read data from file
	@SuppressWarnings("resource")
	private void prepareData() throws Exception {
		File file = new File(FILE_PATH);
		if (file.isFile() && file.exists()){
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "GBK");
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

	@SuppressWarnings("unused")
	private void addTextField(Container contr, String name, int len){
		contr.add(new JLabel(name));
		contr.add(Box.createHorizontalStrut(Constant.BOX_WIDTH));
		JTextField f = new JTextField(len);
		contr.add(f);
		contr.add(Box.createHorizontalStrut(Constant.BOX_WIDTH));
		
		compMap.put(name, f);
	}
}
