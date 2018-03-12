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
 * ��JavaBean����ֱ��������JavaӦ�ó����е��ã�ʵ����Ļ��"����"
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
	 private String fileName; //�ļ���ǰ׺
	 private String defaultName = "GuiCamera";
	 static int serialNum=0;
	 private String imageFormat; //ͼ���ļ��ĸ�ʽ
	 private String defaultImageFormat="png";
	 Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	 /****************************************************************
	 * Ĭ�ϵ��ļ�ǰ׺ΪGuiCamera���ļ���ʽΪPNG��ʽ
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
	 * ������֧��JPG��PNG�ļ��Ĵ洢
	 ****************************************************************/
	 public CutScreen(String s,String format) {
		
		 fileName = s;
		 imageFormat=format;
	 }
	
	 /****************************************************************
	 * ����Ļ��������
	 * snapShot the Gui once
	 ****************************************************************/
	 public void snapShot(int start_x,int start_y,int end_x,int end_y) {
	
		 try {
			 //������Ļ��һ��BufferedImage����screenshot
			BufferedImage screenshot = createBufferedImage(start_x,start_y,end_x,end_y);
			 //�����ļ�ʱ����ļ���ʽ�������Զ������ļ���
			 
			 
			 String name=fileName+getDate()+"."+imageFormat;
			 File f = new File(name);
//			 System.out.print("Save File "+name);
			 //��screenshot����д��ͼ���ļ�
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
		 CutScreen cam= new CutScreen("d:\\��ͼ", "png");//
	
		 cam.snapShot();
	 }*/
}