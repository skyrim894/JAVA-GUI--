package cn.zz.frame;

import java.awt.Color;

import javax.swing.JFrame;

import cn.zz.util.Constant;

public class MyFrame extends JFrame{
	public MyFrame(MyPanel myPanel){
		this.setUndecorated(true);//不需要装饰
		this.setSize(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
		this.setLocation(Constant.FRAME_X, Constant.FRAME_Y);
		this.setBackground(new Color(0,0,0,1));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(myPanel);
	}
}
