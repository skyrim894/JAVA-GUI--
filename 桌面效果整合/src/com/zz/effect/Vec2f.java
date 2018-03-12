package com.zz.effect;

public class Vec2f {
	public double x, y;

	public Vec2f(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// 路径公式设置时运用到的一些计算
	// 点的位置加法计算
	public Vec2f add(Vec2f v){
		return new Vec2f(this.x+v.x,this.y+v.y);
	}

	// 乘法计算
	public Vec2f multiply(double f){
		return new Vec2f(this.x*f,this.y*f);
	}
}