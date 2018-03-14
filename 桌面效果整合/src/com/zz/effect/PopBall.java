package com.zz.effect;

import java.awt.Color;
import java.awt.Graphics;

import com.zz.control.MouseControl;
import com.zz.util.Constant;

/**
 *	弹球功能具体实现类
 */
public class PopBall {
	private Ball ball;
	private double t_x = 0;
	private double t_y = 0;
	
	public PopBall(){
		int init_x = Constant.SCREEN_WIDTH>>1;
		int init_y = Constant.SCREEN_HEIGHT>>1;
		int x_s = 0;
		int y_s = 0;
		int r = 50;
		Color c = new Color(200,100,100);
		ball = new Ball(init_x,init_y,x_s,y_s,r,c);
	}
	
	public void draw(Graphics g){
		g.setColor(ball.getB_c());
		g.fillOval(ball.getB_x(), ball.getB_y(), ball.getB_r(), ball.getB_r());
		if(MouseControl.isDragged){
			ball.setB_x(MouseControl.origin.x-(ball.getB_r()>>1));
			ball.setB_y(MouseControl.origin.y-(ball.getB_r()>>1));
			t_x = MouseControl.s_dra.x-MouseControl.origin.x;
			t_y = MouseControl.s_dra.y-MouseControl.origin.y;
		}

		limit(); 
		ball.setB_speed_x((int)t_x);
		ball.setB_speed_y((int)t_y);
		ball.setB_x(ball.getB_x()+ball.getB_speed_x());
		ball.setB_y(ball.getB_y()+ball.getB_speed_y());
	}	
	
	//限制小球范围
	public void limit(){
		t_x *=0.96;
		t_y *=0.96;
		if((ball.getB_x()>=Constant.SCREEN_WIDTH-ball.getB_r()&&t_x>0)||(ball.getB_x()<=0&&t_x<0)){
			t_x = -t_x;
		}
		if((ball.getB_y()>=Constant.SCREEN_HEIGHT-ball.getB_r()&&t_y>0)||(ball.getB_y()<=0&&t_y<0)){
			t_y = -t_y;
		}
	}
}
