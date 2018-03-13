package com.zz.control;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.zz.frame.Constant;

public class MouseControl extends MouseAdapter{
	
	//判断当前是否被抓取
	public static boolean isGrap = false;
	
	private SoftControl softControl;
	//表示相对窗口原点坐标位置
	private Point origin = new Point();
	
	public MouseControl(SoftControl softControl){
		this.softControl = softControl;
	}
	
	public void mousePressed(MouseEvent e) {
		origin.x = e.getX();
		origin.y = e.getY();
	}
	
	@Override
	public void mouseReleased(MouseEvent e){
//		SoftControl.CAN_CHANGE_ACTION = true;
		isGrap = false;
	}
	
	public void mouseDragged(MouseEvent e) {
		SoftControl.CAN_CHANGE_ACTION = false;
		
		//若正在执行走动动作则线使其等待再执行抓取
		if(SoftControl.ACTION_ID == Constant.WALK){
			if(origin.y-e.getY()==0){
				SoftControl.ACTION_ID = Constant.WAIT;
			}
		}else{
		    Point p = softControl.myFrame.getLocation();
		    softControl.myFrame.setLocation(
		        p.x + (e.getX() - origin.x), 
		        p.y + (e.getY() - origin.y));
		    SoftControl.ACTION_ID = Constant.GRAP;
		    isGrap = true;
		}
	}
	
	public void mouseClicked(MouseEvent e){
		
		SoftControl.CAN_CHANGE_ACTION = true;
		//点击时更换动作
		SoftControl.ACTION_ID = (int)(Math.random()*5);
//		System.out.println("clicked:"+SoftControl.ACTION_ID);
	}
}
