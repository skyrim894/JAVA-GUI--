package com.zz.control;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseControl extends MouseAdapter{
	MainControl mainControl;
	public static Point origin = new Point();
	public static boolean isDragged = false;
	public static Point s_dra = new Point(); 
	public static Point e_dra = new Point(); 
	
	public MouseControl(MainControl mainControl){
		this.mainControl = mainControl;
	}
	
	
	public Point getOrigin() {
		return origin;
	}

	public void mouseMoved(MouseEvent e) {
		origin.x = e.getX();
		origin.y = e.getY(); 
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2){
			System.exit(0);
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		if(MainControl.PopBall){
			origin.x = e.getX();
			origin.y = e.getY();
			isDragged = true;
		}
	}
	
	public void mousePressed(MouseEvent e) {
		if(MainControl.PopBall){
			s_dra.x = e.getX();
			s_dra.y = e.getY();
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if(MainControl.PopBall){
			e_dra.x = e.getX();
			e_dra.y = e.getY();
			isDragged = false;
		}
	}
	
	public Point getDistance(){
		Point dis = new Point();
		dis.x = origin.x - s_dra.x;
		dis.y = origin.y - s_dra.y;
		return dis;
	} 
}
