package com.zz.entity;

import java.awt.Graphics;

import com.zz.control.SoftControl;
import com.zz.frame.Constant;

public class Sleep {
	private int x,y;
	private int frame = 0;
	private int cycle = 0;
	
	public Sleep(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		
		g.drawImage(Icons.SLEEP_IMG[frame], x, y, null);
		
		frame++;
		
		if(frame==4&&cycle<2){
			frame=1;
			cycle++;
		}
		
		if(frame>=Icons.SEELP_IMG_SIZE){
			frame = 0;
			cycle = 0;
			SoftControl.ACTION_ID = Constant.WAIT;
		}
	}
}
