package com.zz.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyControl extends KeyAdapter{
	MainControl mainControl;
	
	public KeyControl(MainControl mainControl){
		this.mainControl = mainControl;
	}
	
	public void keyPressed(KeyEvent e) {
		//ESC退出
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		
		if(e.getKeyCode()==KeyEvent.VK_1){
			MainControl.Snow = !MainControl.Snow;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_2){
			MainControl.Boom = !MainControl.Boom;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_3){
			MainControl.Line = !MainControl.Line;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_4){
			MainControl.PopBall = !MainControl.PopBall;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			MainControl.stop = !MainControl.stop;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			MainControl.speed+=10;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if(MainControl.speed>10)
				MainControl.speed-=10;
		}
	}
}
