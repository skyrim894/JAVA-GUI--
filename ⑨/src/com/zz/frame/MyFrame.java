package com.zz.frame;
import java.awt.Color;
import javax.swing.JFrame;

 
public class MyFrame extends JFrame implements Constant{  
	private static final long serialVersionUID = 1L;

	public MyFrame(MyPanel myPanel) {  
    	this.setUndecorated(true);//不需要边框
    	this.setSize(FRAME_WIDTH, FRAME_HEIGHT);  
        this.setBackground(new Color(0,0,0,0));//设置窗口背景为透明
        this.setLocation(FRAME_X, FRAME_Y);
        this.setAlwaysOnTop(true);//窗口置顶
        this.setContentPane(myPanel);
    }
}