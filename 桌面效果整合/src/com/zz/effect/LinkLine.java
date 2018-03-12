package com.zz.effect;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.zz.control.MainControl;
import com.zz.util.Constant;

/**
 *	桌面出现自定义随机小球混乱移动，两小球到一定距离时会连线
 *	在桌面不为全透明时，鼠标位置也算作小球
 */
public class LinkLine {
	public List<Ball> list = new ArrayList<>();
	Point mouse = null;
	
	public LinkLine(){
		for (int i = 0; i < 100; i++) {
			initBall();
		}
	}
	
	public void draw(Graphics g){
		mouse = MainControl.mouse;
		for (int i = 0; i < list.size(); i++) {
			Ball ball = list.get(i);
			ball.setB_x(ball.getB_x()+ball.getB_speed_x());
			ball.setB_y(ball.getB_y()+ball.getB_speed_y());
			
			int x = ball.getB_x();
			int y = ball.getB_y();
			g.setColor(ball.getB_c());
			g.fillOval(x,y,ball.getB_r(),ball.getB_r());
			
			if(((Math.abs(list.get(i).getB_x()-mouse.getX()))<80&&
					(Math.abs(list.get(i).getB_y()-mouse.getY()))<80)){
				g.setColor(Color.WHITE);
				g.drawLine(list.get(i).getB_x()+list.get(i).getB_r()/2,list.get(i).getB_y()+list.get(i).getB_r()/2,mouse.x, mouse.y);
			}
		}
		
		line(g);
	}
	
	public void line(Graphics g){
		g.setColor(Color.WHITE);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(((Math.abs(list.get(i).getB_x()-list.get(j).getB_x()))<80&&
						(Math.abs(list.get(i).getB_y()-list.get(j).getB_y()))<80)){
					g.drawLine(list.get(i).getB_x()+list.get(i).getB_r()/2,list.get(i).getB_y()+list.get(i).getB_r()/2,
							list.get(j).getB_x()+list.get(j).getB_r()/2, list.get(j).getB_y()+list.get(j).getB_r()/2);
				}
			}
		}
	}
	
	public void initBall(){
		Random rand = new Random();
		int init_r = randomNum(5, 10);
		int init_x = rand.nextInt(Constant.SCREEN_WIDTH-init_r);
		int init_y = rand.nextInt(Constant.SCREEN_HEIGHT-init_r);
		int init_s_x = randomNum(-3, 3);
		int init_s_y = randomNum(-3, 3);
		Color init_c = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
		list.add(new Ball(init_x, init_y, init_s_x, init_s_y, init_r, init_c));
	}
	
	public int randomNum(int min,int max){
		return (int)(Math.random()*(max-min)+min);
	}
}
