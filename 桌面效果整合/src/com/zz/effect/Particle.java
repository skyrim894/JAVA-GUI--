package com.zz.effect;

import java.awt.Color;

public class Particle {
// ���ӵ���㣬�ٶȣ�����
public Vec2f position,velocity,acceleration;
	public double life;
	public double age;
	public int x = 0, y = 0;
	public Color color = null;
	public int size ;

	public Particle() {
	}

	// ������ʱ��x,y����
	public int getX() {
		return (int) this.position.x;
	}

	public int getY() {
		return (int) this.position.y;
	}
}