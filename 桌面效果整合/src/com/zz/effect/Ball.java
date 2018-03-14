package com.zz.effect;

import java.awt.Color;

import com.zz.util.Constant;

/**
 *	模拟球形特征
 */
public class Ball{
	private int b_x;
	private int b_y;
	private int b_speed_x;
	private int b_speed_y;
	private int b_r;
	private Color b_c;
	/**
	 * @param b_x
	 * @param b_y
	 * @param b_speed_x
	 * @param b_speed_y
	 * @param b_r
	 * @param b_c
	 */
	public Ball(int b_x, int b_y, int b_speed_x, int b_speed_y, int b_r, Color b_c) {
		super();
		this.b_x = b_x;
		this.b_y = b_y;
		this.b_speed_x = b_speed_x;
		this.b_speed_y = b_speed_y;
		this.b_r = b_r;
		this.b_c = b_c;
	}
	public int getB_x() {
		return b_x;
	}
	public void setB_x(int b_x) {
		if(b_x>Constant.SCREEN_WIDTH-b_r||b_x<0){
			b_speed_x = -b_speed_x;
		}
		
		this.b_x = b_x;
	}
	public int getB_y() {
		return b_y;
	}
	public void setB_y(int b_y) {
		if(b_y>Constant.SCREEN_HEIGHT-b_r||b_y<0){
			b_speed_y = -b_speed_y;
		}
		this.b_y = b_y;
	}
	public int getB_speed_x() {
		return b_speed_x;
	}
	public void setB_speed_x(int b_speed_x) {
		this.b_speed_x = b_speed_x;
	}
	public int getB_speed_y() {
		return b_speed_y;
	}
	public void setB_speed_y(int b_speed_y) {
		this.b_speed_y = b_speed_y;
	}
	public int getB_r() {
		return b_r;
	}
	public void setB_r(int b_r) {
		this.b_r = b_r;
	}
	public Color getB_c() {
		return b_c;
	}
	public void setB_c(Color b_c) {
		this.b_c = b_c;
	}
}