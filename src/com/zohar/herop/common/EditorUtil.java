/*
 * @(#)EditorUtil.java	1.0 2013-7-3
 *
 */
package com.zohar.herop.common;

import java.awt.Dimension;

import javax.swing.JComponent;

/**
 * 
 * 
 * @author zohar
 * @version 1.0, 2013-7-3
 */
public class EditorUtil {
	
	/**
	 * Fix size of component.
	 * @param comp
	 * @param width, if null, no apply any change.
	 * @param height, if null, no apply any change.
	 */
	public static void fixSize(JComponent comp, Integer width, Integer height){
		Dimension dimen = comp.getPreferredSize();
		if (width!=null){
			dimen.width = width;
		}
		if (height!=null){
			dimen.height = height;
		}
		comp.setPreferredSize(dimen);
	}
}
