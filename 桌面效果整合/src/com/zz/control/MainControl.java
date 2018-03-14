package com.zz.control;

import java.awt.Point;

import com.zz.effect.Snow;
import com.zz.frame.MyFrame;
import com.zz.frame.MyPanel;

public class MainControl {
	private KeyControl keyControl;
	public MouseControl mouseControl;
	private TimeControl timeControl;
	MyPanel myPanel;
	MyFrame myFrame;
	public Snow sEffect;
	
	//以下全局变量
	//鼠标位置
	public static Point mouse = null;
	//雪花效果
	public static boolean Snow = false;
	//烟花效果
	public static boolean Boom = false;
	//星空连线效果
	public static boolean Line = false;
	//弹球效果
	public static boolean PopBall = false;
	//暂停画面
	public static boolean stop = false;
	
	//控制刷新速率
	public static int speed = 100;
	
	public MainControl(){
		keyControl = new KeyControl(this);
		mouseControl = new MouseControl(this);
		mouse = mouseControl.getOrigin();
		
		myPanel = new MyPanel(this);
		sEffect = new Snow(this);
		
		myFrame = new MyFrame(myPanel);
		myFrame.setVisible(true);

		myFrame.addMouseListener(mouseControl);
		myFrame.addMouseMotionListener(mouseControl);
		myFrame.addKeyListener(keyControl);
		
		timeControl = new TimeControl(this);
		timeControl.start();
	}
}
