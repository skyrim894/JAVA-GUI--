package com.zz.frame;

import java.awt.Color;

import javax.swing.JFrame;

import com.zz.util.Constant;

public class MyFrame extends JFrame implements Constant{

	public MyFrame(MyPanel myPanel){
		this.setUndecorated(true);
		this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		this.setLocation(FRAME_X, FRAME_Y);
		this.setBackground(new Color(0,0,0,0));
		this.setContentPane(myPanel);
//		this.setAlwaysOnTop(true);//窗口置顶
	}
}
