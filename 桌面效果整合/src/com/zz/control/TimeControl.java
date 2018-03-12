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
					mainControl.myPanel.repaint();
					try {
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
