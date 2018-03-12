package com.zz.control;

import com.zz.frame.Constant;

public class TimerControl {
	private Thread actionTimer ;
	private Thread sayTimer ;
	private Thread autoActionTimer;
	
	
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
						//减少说话几率
						int keepQuiet = (int)(Math.random()*10);
						
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
						int timer = (int)(Math.random()*15000)+5000;
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
