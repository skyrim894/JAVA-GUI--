package com.zz.effect;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

/**
 *	烟花效果具体实现类
 */
public class Bomb {
	
	public Vec2f position, velocity, acceleration;
	public double life, age, start_time;
	public int size;
	public int x, y;
	public float alpha;

	public int getX() {
		return (int) position.x;
	}

	public int getY() {
		return (int) position.y;
	}

	public Color Bombcolor;
	private ArrayList<Particle> pr = new ArrayList<>();
	private Color color2[] = { Color.BLUE.brighter(), Color.CYAN.brighter(), Color.GRAY.brighter(),
			Color.lightGray.brighter(), Color.ORANGE.brighter(), Color.RED.brighter(), Color.ORANGE.brighter(),
			Color.magenta.brighter(), Color.YELLOW.brighter() };
	private Color color1[] = { new Color(0, 200, 20,100), new Color(250, 40, 40,100), new Color(20, 250, 60,100),
			new Color(110, 10, 110,100), new Color(10, 100, 130,100), new Color(250, 0, 250,100), new Color(0, 100, 200,100),
			new Color(100, 80, 250,100), new Color(80, 0, 0,100),new Color(0,0,100,100),new Color(0,50,200,100),new Color(11,151,10,100) };
	private int colornum1 = -1, colornum2 = -1;

	public void drawscatter(Graphics2D g2d, double dt, double x, double y) {
		if (colornum1 == -1 || colornum2 == -1) {
			colornum1 = (int) (Math.random() * (color1.length - 1));
			 colornum2 = (int) (Math.random() * (color2.length - 1));
		}
		if (pr.size() < 540) {
			if(pr.size()==300){
				colornum1 = (int) (Math.random() * (color1.length - 1));
				 colornum2 = (int) (Math.random() * (color2.length - 1));
			}
			for (int i = 0; i < 300; ++i) {
				Particle tp = new Particle();
				tp.position = new Vec2f(x, y);
				tp.velocity = sampleDirectionv2().multiply(1 - (double) (i / 30) / (double) 10);// �ٶ�����
				tp.acceleration = tp.velocity.multiply(0.1);
				tp.life = 7;
				tp.age = 1;
				tp.color = color1[colornum1];
				tp.size = (int) (2 + Math.random() * 3);
				pr.add(tp);
			}
			for (int i = 0; i < 300; ++i) {
				Particle tp = new Particle();
				tp.position = new Vec2f(x, y);
				tp.velocity = sampleDirectionv1().multiply(1 - (double) (i / 30) / (double) 20);// �ٶ�����
				tp.acceleration = tp.velocity.multiply(0.1);
				tp.life = 7;
				tp.age = 1;
				tp.color = color2[colornum2];
				tp.size = (int) (2 + Math.random() * 3);
				pr.add(tp);
			}
		}
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < pr.size(); ++i) {
			Particle p = pr.get(i);
			if (p.age == 1)
				alpha = 1f;
			p.age += dt;
			if (p.age >= p.life) {
				pr.remove(i);
			}
			
			if(p.age>7)
				p.size-=0.1;
			p.position = p.position.add(p.velocity.multiply(dt));
			p.velocity = p.velocity.add(p.acceleration.multiply(dt));

			alpha -= 0.00019 / (double) p.life;
			g2d.setColor(p.color);
			g2d.fillOval(p.getX(), p.getY(), p.size, p.size);
		}
	}

	public static Vec2f sampleDirectionv2() {
		double theta = Math.random() * 4 * Math.PI;
		return new Vec2f((12 * Math.cos(theta)), (12 * Math.sin(theta)));
	}

	public static Vec2f sampleDirectionv1() {
		double theta = Math.random() * 4 * Math.PI;
		return new Vec2f((20 * Math.cos(theta)), 20 * (Math.sin(theta)));
	}
}