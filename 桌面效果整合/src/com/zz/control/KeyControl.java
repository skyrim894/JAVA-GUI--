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
		
		//每次添加新功能需要在此加上键盘控制键
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
		
		//暂停画面
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			MainControl.stop = !MainControl.stop;
		}
		
		//增大重绘时间间隔
		if(e.getKeyCode() == KeyEvent.VK_UP){
			MainControl.speed+=10;
		}
		//减小重绘时间间隔
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if(MainControl.speed>10)
				MainControl.speed-=10;
		}
	}
}
