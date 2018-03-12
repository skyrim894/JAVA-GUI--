package com.zz.entity;

import java.awt.Graphics;

import com.zz.control.SoftControl;
import com.zz.frame.Constant;

public class Summon {
	private int x,y;
	private int frame = 0;
	
	public Summon(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		g.drawImage(Icons.SUMMON_IMG[frame], x, y, null);
		
		frame++;
		
		if(frame>=Icons.SUMMON_IMG_SIZE){
			frame = 0;
			SoftControl.ACTION_ID = Constant.WAIT;
		}
	}
}
