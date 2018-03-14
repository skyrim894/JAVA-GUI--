package com.zz.frame;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.zz.control.MainController;

public class MyPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	MainController mainController;
	
	public MyPanel(MainController mainController){
		this.mainController = mainController;
		this.setOpaque(false);
	}
	
	
	public void paintComponent(Graphics g){
		mainController.drawFrame.draw(g);
	}
}
