package com.zohar.herop.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class ToolUtil {
	public static <T> boolean isNullOrEmpty(Collection<T> col){
		if (col==null || col.size()==0){
			return true;
		} else{
			return false;
		}
	}
	
	public static String genTimeSuffix(){
		SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
		String result = df.format(new Date());
		return result;
	}
	
	public static void backUpFile(String filePath, String fileBak) {
		File source = new File(filePath);
		File target = new File(fileBak);
		FileChannel in = null;  
	    FileChannel out = null;  
	    FileInputStream inStream = null;  
	    FileOutputStream outStream = null;  
	    try {  
	        inStream = new FileInputStream(source);  
	        outStream = new FileOutputStream(target);  
	        in = inStream.getChannel();  
	        out = outStream.getChannel();  
	        in.transferTo(0, in.size(), out);  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	        try {
	        	inStream.close();
				in.close();
				outStream.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }  
	}
}
