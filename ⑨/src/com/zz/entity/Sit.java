package com.zz.entity;

import java.awt.Graphics;

/**
 *	静坐动作
 */
public class Sit {
	private int x,y;
	private int frame = 0;
	
	public Sit(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		g.drawImage(Icons.SIT_IMG[frame], x, y, null);
		
//		if(frame>Icons.SIT_IMG_SIZE){
//			frame = 0;
//		}
	}
}
