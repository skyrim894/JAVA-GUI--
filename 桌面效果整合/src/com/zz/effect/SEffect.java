package com.zz.effect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import com.zz.control.MainControl;
import com.zz.util.Constant;

public class SEffect {
	MainControl mainControl;
	//�������ӵĶ���
	private ArrayList<Particle> ps = new ArrayList<>();
	private Random ran = new Random();
	//�ƶ�����
	double dt = 0.2d;
	
	public SEffect(MainControl mainControl) {
		this.mainControl = mainControl;
	}
	
	public void draw(Graphics2D bg){
		// �������ӷ������
		Particle tp = new Particle();
		//ran.nextInt(Constant.SCREEN_WIDTH)
		tp.position = new Vec2f(ran.nextInt(Constant.SCREEN_WIDTH), 0);//���ӷ������ʼ��
		tp.velocity = new Vec2f(0, 50);// ����
		tp.acceleration = sampleDirection();
	//	tp.life = 400;//400������Ϊһ������
	//	tp.age = 1;
		ps.add(tp);
		
		for (int i = 0; i < ps.size(); i++) {
			Particle p = ps.get(i);
			// 1.�ж����ӵ������Ƿ��ڣ����ں󣬴Ӷ����Ƴ�
			//p.age++;
			if (isOut(p)) {
				
				ps.remove(i);
				p = null;
				continue;
			}
			// ÿ�����ӵ���ɫ
			if(p.color!=null){
				bg.setColor(p.color);
			}else{
				p.color = new Color(255,255,255,ran.nextInt(200));
			}
			
			//ÿ�����Ӵ�С
			if(p.size==0){
				p.size = ran.nextInt(Constant.INIT_MAX_SiZE-Constant.INIT_MIN_SiZE)+Constant.INIT_MIN_SiZE;
			}
			
			p.position = p.position.add(p.velocity.multiply(dt));
			p.velocity = p.velocity.add(p.acceleration.multiply(dt));
//			System.out.println(p.getX()+","+p.getY());
			bg.fillOval(p.getX()+10, p.getY()+p.size,p.size, p.size);
//			System.out.println(ps.size());
			bg.setFont(new Font(null, Font.BOLD, 20));
			bg.drawString("size:"+ps.size(), Constant.SCREEN_WIDTH/2,Constant.SCREEN_HEIGHT-100);
		}
		
	}
	
	// ����һ���������
	public static Vec2f sampleDirection() {
		double theta = Math.random() * 2 * Math.PI;
		return new Vec2f((Math.cos(theta)), (Math.sin(theta)));
	}
	
	//�ж������Ƿ񳬳���Ļ
	public boolean isOut(Particle p){
		if(p.getY()>Constant.SCREEN_HEIGHT||p.getY()-p.size<0||
				p.getX()>Constant.SCREEN_WIDTH||p.getX()-p.size<0){
			return true;
		}
		return false;
	}
	
}
