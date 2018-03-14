package com.zz.control;

public class TimeControl {
	private MainControl mainControl;
	private Thread mainThread ;

	public TimeControl(MainControl mainControl){
		this.mainControl = mainControl;
	}
	
	public void start(){
		mainThread = new Thread(){
			public void run(){
				while(true){
					try {
						while(MainControl.stop){
							Thread.sleep(MainControl.speed);
						}
						mainControl.myPanel.repaint();
						Thread.sleep(MainControl.speed);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		};
		
		mainThread.start();
	}
}
