package cn.zz.frame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import cn.zz.controller.MainController;
import cn.zz.util.Constant;
import cn.zz.util.Image1;

public class MyPanel extends JPanel implements Constant{
	private static final long serialVersionUID = 1L;
	MainController mainController;
	private int flag_value; 
	
	public MyPanel(MainController mainController){
		this.mainController = mainController;
		this.setOpaque(false);
	}
	
	public void paintComponent(Graphics g){
		flag_value = ((MainController.BLOCK_X-20)*280)/(CANVAS_WIDTH-40);
		
		if(MainController.file!=null){
			g.drawImage(Image1.setAlpha(flag_value-10), CANVAS_X, CANVAS_Y, null);
		}
		
		g.setColor(new Color(0,0,0,100));
		g.fillRect(20, CANVAS_Y, CANVAS_WIDTH-40, 4);
		
		if(MainController.IS_BLOCK){
			g.setColor(new Color(0,255,0,200));
		}else{
			g.setColor(new Color(255,0,0,200));
		}
		g.fillRect(MainController.BLOCK_X, CANVAS_Y, 10, 20);
	}
}
