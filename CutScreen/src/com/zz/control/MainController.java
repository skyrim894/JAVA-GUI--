package com.zz.control;

import com.zz.frame.DrawFrame;
import com.zz.frame.MyFrame;
import com.zz.frame.MyPanel;

public class MainController {
	public MyPanel myPanel;
	public MyFrame myFrame;
	public DrawFrame drawFrame;
	public TimerController timerController;
	public MouseController mouseController;
	public KeyControl keyControl;
	
	public static boolean isCutStart = false;
	public static boolean isSave = false;
	public static boolean isHidden = false;
	
	public MainController(){
		this.myPanel = new MyPanel(this);
		drawFrame = new DrawFrame(this);
		
		myFrame = new MyFrame(myPanel);
		myFrame.setVisible(true);
		
		timerController = new TimerController(this);
		timerController.start();
		
		mouseController = new MouseController(this);
		myFrame.addMouseListener(mouseController);
		myFrame.addMouseMotionListener(mouseController);
		
		keyControl = new KeyControl(this);
		myFrame.addKeyListener(keyControl);
		
	}
}
