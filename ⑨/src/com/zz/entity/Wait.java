package com.zz.entity;

import java.awt.Graphics;

public class Wait {
	private int x,y;
	private int frame = 0;
	
	
	public Wait(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		g.drawImage(Icons.WAIT_IMG[frame], x, y, null);
		
	}
}
