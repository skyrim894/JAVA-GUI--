package com.zz.frame;

import java.awt.Toolkit;

public interface Constant {
	
	//窗口宽高
	int FRAME_WIDTH=200;
	int FRAME_HEIGHT=200;
	//获得屏幕宽高
	int SCREEN_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int SCREEN_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	//窗口初始位置
	int FRAME_X=SCREEN_WIDTH-FRAME_WIDTH;
	int FRAME_Y=SCREEN_HEIGHT-FRAME_HEIGHT;
	//动作flag 
	int WAIT = 0;
	int WALK = 1;
	int SIT =2;
	int SLEEP = 3;
	int SUMMON = 4;
	int GRAP = 5;
	int FALL = 6;
	
	
	//动作间隔时间
	int INTERVAL_TIME = 5000;
	
	
	
	//动作图片位置
	String SLEEP_IMG = "image/sleep/";
	String WAIT_IMG = "image/wait/";
	String SPEAK_IMG = "image/speak/";
	String WALK_IMG = "image/walk/";
	String FALL_IMG = "image/fall/";
	String GRAP_IMG = "image/grap/";
	String SIT_IMG = "image/sit/";
	String SUMMON_IMG = "image/summon/";
	
	
	//最小化图标位置
	String ICON_IMG = "image/icon/icon.png";
	//托盘图标
	String DIALOG_IMG = "image/win/dialog.png";
	
	String[] WORD = {
			"阿勒",
			"娜娜奇",
			">_<  有水啊",
			"给我",
			"出来",
			"不要抢我的东西",
			"昨天，我到西边去的时候看到了一只好大好大的蛇，就是不好吃",
			"我不敢了"
	};
	
}
