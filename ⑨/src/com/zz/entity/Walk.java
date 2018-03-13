package com.zz.entity;

import java.awt.Graphics;

/**
 *	行走动作
 */
public class Walk {
	private int x,y;
	private int frame = 0;
	
	public Walk(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		g.drawImage(Icons.WALK_IMG[frame], x, y, null);
		
		frame++;
		
		if(frame>=Icons.WALK_IMG_SIZE){
			frame = 0;
		}
	}
}
