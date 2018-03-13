package com.zz.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.zz.control.SoftControl;
import com.zz.frame.Constant;

/**
 *	执行说话动作
 */
public class Say {

	public int x ;
	
	public int y ;
	
	public Say(int x,int y){
		
		this.x=x;
		this.y=y;
	}

	
	public void draw(Graphics g){
//		g.drawImage(Icons.DIALOG_IMG, x, y,null);
		
		String str = Constant.WORD[SoftControl.NOW_WORD];
				
		g.setColor(Color.WHITE);
		g.drawString(str,x+0,y+1);
		g.drawString(str,x+1,y+0);
		g.drawString(str,x+1,y+2);
		g.drawString(str,x+2,y+1);
		if(str.length()>10)
			g.setColor(Color.BLACK);
		else
			g.setColor(Color.RED);
		g.drawString(str,x+1,y+1);
	}
}
