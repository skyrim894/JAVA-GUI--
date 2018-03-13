package com.zz.entity;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import com.zz.frame.Constant;

/**
 *	所有图片的路径
 */
public class Icons {
	
	static int SEELP_IMG_SIZE = getFilesLenth(Constant.SLEEP_IMG);
	static int WAIT_IMG_SIZE= getFilesLenth(Constant.WAIT_IMG);
	static int WALK_IMG_SIZE = getFilesLenth(Constant.WALK_IMG);
	static int FALL_IMG_SIZE = getFilesLenth(Constant.FALL_IMG);
	static int SIT_IMG_SIZE = getFilesLenth(Constant.SIT_IMG);
	static int GRAP_IMG_SIZE = getFilesLenth(Constant.GRAP_IMG);
	static int SUMMON_IMG_SIZE = getFilesLenth(Constant.SUMMON_IMG);
	
	public static Image[] SLEEP_IMG = new Image[SEELP_IMG_SIZE];
	
	public static Image[] WAIT_IMG = new Image[WAIT_IMG_SIZE];
	
//	public Image[] SPEAK_IMG = new Image[getFilesLenth(Constant.SPEAK_IMG)];
	
	public static Image[] WALK_IMG = new Image[WALK_IMG_SIZE];	
	
	public static Image[] FALL_IMG = new Image[FALL_IMG_SIZE];
	
	public static Image[] SIT_IMG = new Image[SIT_IMG_SIZE];
	
	public static Image[] GRAP_IMG = new Image[GRAP_IMG_SIZE];
	
	public static Image[] SUMMON_IMG = new Image[SUMMON_IMG_SIZE];
	
	public static final Image DIALOG_IMG = new ImageIcon(Constant.DIALOG_IMG).getImage();		
	
	public static final Image ICON_IMG = new ImageIcon(Constant.ICON_IMG).getImage();
	
	public Icons(){
		for(int i=0;i<SEELP_IMG_SIZE;i++){
			SLEEP_IMG[i] = new ImageIcon("image/sleep/sleep-"+i+".png").getImage();
		}
		
		for(int i=0;i<WAIT_IMG_SIZE;i++){
			System.out.println("runing");
			WAIT_IMG[i] = new ImageIcon("image/wait/wait-"+i+".png").getImage();
		}
		
		for(int i=0;i<WALK_IMG_SIZE;i++){
			WALK_IMG[i] = new ImageIcon("image/walk/walk-"+i+".png").getImage();
		}
		
		for(int i=0;i<FALL_IMG_SIZE;i++){
			FALL_IMG[i] = new ImageIcon("image/fall/fall-"+i+".png").getImage();
		}
		
		for(int i=0;i<GRAP_IMG_SIZE;i++){
			GRAP_IMG[i] = new ImageIcon("image/grap/grap-"+i+".png").getImage();
		}
		
		for(int i=0;i<SIT_IMG_SIZE;i++){
			SIT_IMG[i] = new ImageIcon("image/sit/sit-"+i+".png").getImage();
		}
		
		for(int i=0;i<SUMMON_IMG_SIZE;i++){
			SUMMON_IMG[i] = new ImageIcon("image/summon/summon-"+i+".png").getImage();
		}
		
	}
	
	
	
	public static int getFilesLenth(String filepath) {
		String format = ".png";
		int size = 0;
		if(filepath!=null){
			File filedir = new File(filepath);  
		    File[] filelist = filedir.listFiles();  
		    for (File file : filelist) {  
		     String filename = file.getName().toLowerCase();
		     if (filename.endsWith(format)) {  
		        size++;
		     }  
		    }  
		}
		return size;
	}
}
