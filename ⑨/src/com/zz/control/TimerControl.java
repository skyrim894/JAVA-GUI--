package com.zz.control;

import com.zz.frame.Constant;

public class TimerControl {
	private Thread actionTimer ;//控制普通动作图片替换间隔
	private Thread sayTimer ;//控制说话时间间隔
	private Thread autoActionTimer;//控制自动进行动作间隔
	
	
	private SoftControl softControl;
	
	public TimerControl(SoftControl softControl){
		this.softControl = softControl;
	}
	
	public void start(){
		actionTimer = new Thread(){
			public void run(){
				while(true){
					try {
					int timer = 100;
					//当执行睡眠和召唤动作时，图片替换间隔为1秒
					if(SoftControl.ACTION_ID==Constant.SLEEP||SoftControl.ACTION_ID==Constant.SUMMON){
						timer = 1000;
					}
					
					softControl.myPanel.repaint();
					softControl.frameAction.drawFrameAction();
					
						Thread.sleep(timer);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		sayTimer = new Thread(){
			public void run(){
				while(true){
					try {
						//控制说话频率
						int keepQuiet = (int)(Math.random()*10);
						
						//当正在静坐或等待动作时才可执行说话动作
						if((SoftControl.ACTION_ID == Constant.SIT||
								SoftControl.ACTION_ID == Constant.WAIT)&&
								keepQuiet<1){
							SoftControl.NOW_WORD = (int)(Math.random()*(Constant.WORD.length));
							SoftControl.IS_WORD_VISIBLE = true;
						}	
						
						Thread.sleep(3000);
						SoftControl.IS_WORD_VISIBLE = false;
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					
				}
			}
		};
	
		autoActionTimer = new Thread(){
			public void run(){
				try {
					while(true){
						//控制动作频率
						int timer = (int)(Math.random()*15000)+5000;
						//在 可执行动作 状态时随机执行动作
						if(SoftControl.CAN_CHANGE_ACTION){
							SoftControl.ACTION_ID = (int)(Math.random()*5);
						}
						Thread.sleep(timer);
					}	
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
		};
		
		actionTimer.start();
		autoActionTimer.start();
		sayTimer.start();
	}
}
