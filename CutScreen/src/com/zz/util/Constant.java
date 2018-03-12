package com.zz.util;

import java.awt.Toolkit;

public interface Constant {
	//屏幕宽高
	int SCREEN_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int SCREEN_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	//初始位置
	int FRAME_X = 0;
	int FRAME_Y = 0 ;
//	int FRAME_Y=(SCREEN_HEIGHT-FRAME_HEIGHT)/2;
	
	
	int ANI_NO = 0;//无动画
	int ANI_START = 1;//（程序打开）开始动画
	int ANI_END = 2;//结束动画
	
	//默认保存地址
	String SAVE_PATH = "C:\\Users\\Administrator\\Desktop\\";
}
