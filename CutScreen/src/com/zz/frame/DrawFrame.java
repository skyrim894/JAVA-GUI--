package com.zz.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import com.zz.control.MainController;
import com.zz.util.Constant;

public class DrawFrame implements Constant{
	
	private Point start = new Point();
	private Point end = new Point();
	private MainController mainController;
	
	public DrawFrame(MainController mainController){
		this.mainController = mainController;
	}
	
	//绘制截图画面
	public void draw(Graphics g) {
		if(MainController.isCutStart){
			start = mainController.mouseController.getORIGIN_START();
			end = mainController.mouseController.getORIGIN_END();
		}
		
		if(!MainController.isHidden){
			g.setColor(new Color(0,0,0,100));
			g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		}
		
		if(!MainController.isCutStart&&!MainController.isHidden){
			drawTips(g,"Ctrl+C to copy,Ctrl+S to save");
		} 

		g.clearRect(start.x,start.y,end.x-start.x,end.y-start.y);
		
		g.setColor(new Color(0,0,0,1));
		g.fillRect(start.x,start.y,end.x-start.x,end.y-start.y);

		if(MainController.isSave){
			drawTips(g,"保存到默认路径"+SAVE_PATH,SCREEN_WIDTH-400, SCREEN_HEIGHT-20,14);
		}
	}
	
	//绘制提示信息
	public void drawTips(Graphics g,String tips){
		g.setColor(new Color(255,255,0,200));
		g.setFont(new Font(null, Font.BOLD, 30));
		g.drawString(tips,50, SCREEN_HEIGHT-50);
	}
	
	public void drawTips(Graphics g,String tips,int x,int y,int fontSize){
		g.setColor(new Color(255,0,0,200));
		g.setFont(new Font(null, Font.BOLD, fontSize));
		g.drawString(tips,x,y);
	}
}
