package com.zz.util;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;

import javax.imageio.ImageIO;

public class CutScreen
{
	 private String fileName;
	 private String defaultName = "GuiCamera";
	 static int serialNum=0;
	 private String imageFormat;
	 private String defaultImageFormat="png";
	 Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	 public CutScreen() {
		 fileName = defaultName;
		 imageFormat=defaultImageFormat;
	 }

	 public CutScreen(String s,String format) {
		 fileName = s;
		 imageFormat=format;
	 }
	
	 public void snapShot(int start_x,int start_y,int end_x,int end_y) {
	
		 try {
			BufferedImage screenshot = createBufferedImage(start_x,start_y,end_x,end_y);
			 
			 String name=fileName+getDate()+"."+imageFormat;
			 File f = new File(name);
			 ImageIO.write(screenshot, imageFormat, f);
		 }
		 catch (Exception ex) {
			 System.out.println(ex);
		 }
	 }
	 
	 public Image getImage(int start_x,int start_y,int end_x,int end_y) throws Exception{
		 BufferedImage screenshot = createBufferedImage(start_x,start_y,end_x,end_y);
		 return screenshot;
	 }
	 
	 private BufferedImage createBufferedImage(int start_x,int start_y,int end_x,int end_y) throws Exception{
		 BufferedImage screenshot = (new Robot()).createScreenCapture(new
				 Rectangle(start_x,start_y,end_x-start_x,end_y-start_y));
		 return screenshot;
	 }
	 
	 public String getDate(){
		 Calendar cal = Calendar.getInstance();
		 String str = cal.get(Calendar.DAY_OF_MONTH)+"-"+
				 cal.get(Calendar.HOUR_OF_DAY)+"-"+
				 cal.get(Calendar.MINUTE)+"-"+
				 cal.get(Calendar.SECOND);
		 
		 return str;
	 }
}