package com.zz.control;

public class TimerController {
	private MainController mainController;
	private Thread mainThread ;
	private Thread aniThread ;
	
	public TimerController(MainController mainController){
		this.mainController = mainController;
	}
	
	public void start(){
		mainThread = new Thread(){
			public void run(){
				while(true){
					mainController.myPanel.repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		aniThread = new Thread(){
			public void run(){
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		};

		
		mainThread.start();
//		aniThread.start();
	}
}
