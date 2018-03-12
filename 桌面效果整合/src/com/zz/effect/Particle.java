package com.zz.effect;

import java.awt.Color;

public class Particle {
// 粒子的起点，速度，重力
public Vec2f position,velocity,acceleration;
	public double life;
	public double age;
	public int x = 0, y = 0;
	public Color color = null;
	public int size ;

	public Particle() {
	}

	// 画粒子时的x,y坐标
	public int getX() {
		return (int) this.position.x;
	}

	public int getY() {
		return (int) this.position.y;
	}
}