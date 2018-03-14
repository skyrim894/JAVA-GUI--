package com.zz.effect;

import java.awt.Color;

/**
 *	用来存放对象的生命周期信息，颜色信息，
 */
public class Particle {
	
public Vec2f position,velocity,acceleration;
	public double life;
	public double age;
	public int x = 0, y = 0;
	public Color color = null;
	public int size ;

	public Particle() {
	}

	public int getX() {
		return (int) this.position.x;
	}

	public int getY() {
		return (int) this.position.y;
	}
}