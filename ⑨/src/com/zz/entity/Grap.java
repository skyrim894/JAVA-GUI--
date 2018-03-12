package com.zz.entity;

import java.awt.Graphics;

import com.zz.control.SoftControl;

public class Grap {
	private int x,y;
	private int frame = 0;
	
	public Grap(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		if(SoftControl.CAN_CHANGE_ACTION)
			frame = (int)(Math.random()*6);
		g.drawImage(Icons.GRAP_IMG[frame], x, y, null);
	}
}
