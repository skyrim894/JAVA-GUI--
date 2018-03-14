package com.zz.frame;

import java.awt.Color;

import javax.swing.JFrame;

import com.zz.util.Constant;

public class MyFrame extends JFrame implements Constant{
	private static final long serialVersionUID = 1L;

	public MyFrame(MyPanel myPanel){
		this.setUndecorated(true);
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setLocation(FRAME_X,FRAME_Y);
		this.setBackground(new Color(0,0,0,0));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setContentPane(myPanel);
		
	}
}
