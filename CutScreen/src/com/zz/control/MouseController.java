package com.zz.control;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter{
	MainController mainController;
	private Point ORIGIN_START = new Point();
	private Point ORIGIN_END = new Point();
	private Point ORIGIN_NOW = new Point();
	public static int mouse_x = 0; 
	public static int mouse_y = 0;
	
	public Point getORIGIN_NOW() {
		return ORIGIN_NOW;
	}

	public void setORIGIN_NOW(Point oRIGIN_NOW) {
		ORIGIN_NOW = oRIGIN_NOW;
	}

	public Point getORIGIN_START() {
		return ORIGIN_START;
	}

	public void setORIGIN_START(Point oRIGIN_START) {
		ORIGIN_START = oRIGIN_START;
	}

	public Point getORIGIN_END() {
		return ORIGIN_END;
	}

	public void setORIGIN_END(Point oRIGIN_END) {
		ORIGIN_END = oRIGIN_END;
	}

	public MouseController(MainController mainController){
		this.mainController = mainController;
	}
	
	public void mousePressed(MouseEvent e) {
		
		MainController.isCutStart = true;
		
		MainController.isSave = false ;
		
		ORIGIN_START.x = e.getX();
		ORIGIN_START.y = e.getY();
	}
	
	public void mouseDragged(MouseEvent e) {
		ORIGIN_END.x = e.getX();
		ORIGIN_END.y = e.getY();
	}
	
	
	public void mouseMoved(MouseEvent e) {
		ORIGIN_NOW.x = e.getX();
		ORIGIN_NOW.y = e.getY(); 
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2){
			System.exit(0);
		}
		
		if(MainController.isCutStart&&e.getClickCount()==1){
			MainController.isCutStart = false;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MainController.isCutStart = false;
		
	}

	
}
