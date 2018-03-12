package com.zz.effect;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.zz.control.MainControl;
import com.zz.util.Constant;

public class LinkStart {
	int x = Constant.SCREEN_WIDTH/2;
	int y = Constant.SCREEN_HEIGHT/2;
	int i = 0;

	public void draw(Graphics2D g){
		
		g.setColor(Color.WHITE);
		
		g.fillArc(x-500-i, y-500-i, 1000+2*i, 1000+2*i, 0, i);
		i++;
		
	}
}
