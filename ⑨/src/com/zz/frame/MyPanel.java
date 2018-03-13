package com.zz.frame;

import java.awt.Graphics;
import javax.swing.JPanel;

import com.zz.control.SoftControl;

public class MyPanel extends JPanel implements Constant{

	private static final long serialVersionUID = 1L;
	
	private SoftControl softControl;
	
	public MyPanel(SoftControl softControl){
		this.softControl = softControl;
		this.setOpaque(false);
	}

	public void paintComponent(Graphics g){
		//调用动作
		switch(SoftControl.ACTION_ID){
		case WAIT : softControl.wait.draw(g);
			break;
		case WALK : softControl.walk.draw(g);
			break;
		case SIT : softControl.sit.draw(g);
			break;
		case SLEEP : softControl.sleep.draw(g);
			break;
		case SUMMON : softControl.summon.draw(g);
			break;
		case GRAP : softControl.grap.draw(g);
			break;
		case FALL : softControl.fall.draw(g);
			break;
		}
		
		if(SoftControl.IS_WORD_VISIBLE)
			softControl.say.draw(g);
	}
	
	
}