package com.zz.control;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.zz.util.Constant;
import com.zz.util.CutScreen;
import com.zz.util.ToClipboard;


public class KeyControl extends KeyAdapter{

	private Point start = new Point();
	private Point end = new Point();
	MainController mainController;
	private boolean isCtrl = false;
	
	public KeyControl(MainController mainController) {
		this.mainController = mainController;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_CONTROL){
			isCtrl = true;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_C&&isCtrl){
			start = mainController.mouseController.getORIGIN_START();
			end = mainController.mouseController.getORIGIN_END();
			CutScreen cs = new CutScreen(Constant.SAVE_PATH+"��ͼ","png");

			ToClipboard tc = null;
			try {
				tc = new ToClipboard(cs.getImage(start.x, start.y, end.x, end.y));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			tc.setImage();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_S&&isCtrl){
			start = mainController.mouseController.getORIGIN_START();
			end = mainController.mouseController.getORIGIN_END();
			CutScreen cs = new CutScreen(Constant.SAVE_PATH+"��ͼ","png");
			cs.snapShot(start.x, start.y, end.x, end.y);
			MainController.isSave = true ;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			MainController.isHidden = !MainController.isHidden; 
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_CONTROL){
			isCtrl = false;
		}
		
	}
	
}
