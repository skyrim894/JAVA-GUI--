package com.zz.entity;

import java.awt.Graphics;

import com.zz.control.SoftControl;

/**
 *	执行下坠动作
 */
public class Fall {
	private int x,y;
	private int frame = 0;
	
	public Fall(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		while(SoftControl.CAN_CHANGE_ACTION)
		frame = (int)(Math.random()*3);
		g.drawImage(Icons.FALL_IMG[frame], x, y, null);

	}
}
