package com.zz.effect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import com.zz.control.MainControl;
import com.zz.util.Constant;

/**
 *	雪花效果具体实现类
 */
public class Snow {
	MainControl mainControl;
	private ArrayList<Particle> ps = new ArrayList<>();
	private Random ran = new Random();
	double dt = 0.2d;
	
	public Snow(MainControl mainControl) {
		this.mainControl = mainControl;
	}
	
	public void draw(Graphics2D bg){
		Particle tp = new Particle();
		tp.position = new Vec2f(ran.nextInt(Constant.SCREEN_WIDTH), 0);
		tp.velocity = new Vec2f(0, 50);
		tp.acceleration = sampleDirection();
		ps.add(tp);
		
		for (int i = 0; i < ps.size(); i++) {
			Particle p = ps.get(i);
			if (isOut(p)) {
				
				ps.remove(i);
				p = null;
				continue;
			}
			if(p.color!=null){
				bg.setColor(p.color);
			}else{
				p.color = new Color(255,255,255,ran.nextInt(200));
			}
			
			if(p.size==0){
				p.size = ran.nextInt(Constant.INIT_MAX_SiZE-Constant.INIT_MIN_SiZE)+Constant.INIT_MIN_SiZE;
			}
			
			p.position = p.position.add(p.velocity.multiply(dt));
			p.velocity = p.velocity.add(p.acceleration.multiply(dt));
			bg.fillOval(p.getX()+p.size, p.getY()+p.size,p.size, p.size);
			bg.setFont(new Font(null, Font.BOLD, 20));
			bg.drawString("size:"+ps.size(), Constant.SCREEN_WIDTH/2,Constant.SCREEN_HEIGHT-100);
		}
	}
	
	public static Vec2f sampleDirection() {
		double theta = Math.random() * 2 * Math.PI;
		return new Vec2f((Math.cos(theta)), (Math.sin(theta)));
	}
	
	//判断是否超出屏幕
	public boolean isOut(Particle p){
		if(p.getY()>Constant.SCREEN_HEIGHT||p.getY()+p.size<0||
				p.getX()>Constant.SCREEN_WIDTH||p.getX()+p.size<0){
			return true;
		}
		return false;
	}
}
