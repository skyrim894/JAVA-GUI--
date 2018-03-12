package cn.zz.controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cn.zz.util.Constant;

public class MouseController extends MouseAdapter{
	MainController mainController;
	private Point origin = new Point();
	public static int mouse_x = 0; 
	public static int mouse_y = 0;
	
	public MouseController(MainController mainController){
		this.mainController = mainController;
	}
	
	public void mousePressed(MouseEvent e) {
		origin.x = e.getX();
		origin.y = e.getY();
	}
	
	public void mouseDragged(MouseEvent e) {
		//拖动窗口
		Point p = mainController.myFrame.getLocation();
		if(MainController.IS_BLOCK==true){
			if(e.getX()<Constant.CANVAS_WIDTH-20&&e.getX()>20)
				MainController.BLOCK_X = e.getX();
		}else{
			mainController.myFrame.setLocation(
			        p.x + (e.getX() - origin.x), 
			        p.y + (e.getY() - origin.y));
		}
	}
	
	
	public void mouseMoved(MouseEvent e) {
		//获得鼠标位置
		mouse_x = e.getX();
		mouse_y = e.getY();
		
		//判断鼠标是否在滑块上（愚蠢）
		if(mouse_x>MainController.BLOCK_X&&
				mouse_x<MainController.BLOCK_X+10&&
				mouse_y<Constant.CANVAS_Y+20&&
				mouse_y>Constant.CANVAS_Y){
			MainController.IS_BLOCK = true ;
		}else{
			MainController.IS_BLOCK = false ;
		}
	}
	
	
	public void mouseClicked(MouseEvent e) {
		//双击退出
		if(e.getClickCount()==2){
			System.exit(0);
		}
	}
}
