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

/*******************************************************************
 * 该JavaBean可以直接在其他Java应用程序中调用，实现屏幕的"拍照"
 * This JavaBean is used to snapshot the GUI in a
 * Java application! You can embeded
 * it in to your java application source code, and us
 * it to snapshot the right GUI of the application
 * @see javax.ImageIO
 * @author liluqun
 * @version 1.0
 *****************************************************/

public class CutScreen
{
	 private String fileName; //文件的前缀
	 private String defaultName = "GuiCamera";
	 static int serialNum=0;
	 private String imageFormat; //图像文件的格式
	 private String defaultImageFormat="png";
	 Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	 /****************************************************************
	 * 默认的文件前缀为GuiCamera，文件格式为PNG格式
	 * The default construct will use the default
	 * Image file surname "GuiCamera",
	 * and default image format "png"
	 ****************************************************************/
	 public CutScreen() {
		 fileName = defaultName;
		 imageFormat=defaultImageFormat;
	
	 }

	 /****************************************************************
	 * @param s the surname of the snapshot file
	 * @param format the format of the image file,
	 * it can be "jpg" or "png"
	 * 本构造支持JPG和PNG文件的存储
	 ****************************************************************/
	 public CutScreen(String s,String format) {
		
		 fileName = s;
		 imageFormat=format;
	 }
	
	 /****************************************************************
	 * 对屏幕进行拍照
	 * snapShot the Gui once
	 ****************************************************************/
	 public void snapShot(int start_x,int start_y,int end_x,int end_y) {
	
		 try {
			 //拷贝屏幕到一个BufferedImage对象screenshot
			BufferedImage screenshot = createBufferedImage(start_x,start_y,end_x,end_y);
			 //根据文件时间和文件格式变量，自动生成文件名
			 
			 
			 String name=fileName+getDate()+"."+imageFormat;
			 File f = new File(name);
//			 System.out.print("Save File "+name);
			 //将screenshot对象写入图像文件
			 ImageIO.write(screenshot, imageFormat, f);
//			 System.out.print("..Finished!\n");
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
/*	
	 public static void main(String[] args)
	 {
		 CutScreen cam= new CutScreen("d:\\截图", "png");//
	
		 cam.snapShot();
	 }*/
}