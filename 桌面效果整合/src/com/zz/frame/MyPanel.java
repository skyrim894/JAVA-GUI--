package com.zz.frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;

import com.zz.control.MainControl;
import com.zz.effect.Bomb;
import com.zz.effect.LinkLine;
import com.zz.effect.PopBall;
import com.zz.util.Constant;

public class MyPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private MainControl mainControl;
	private Bomb bomb = new Bomb();
	private LinkLine link = new LinkLine();
	private PopBall ball = new PopBall();
	
	public MyPanel(MainControl mainControl){
		this.mainControl = mainControl;
		this.setOpaque(false);
	}

	public void paintComponent(Graphics g){
		Graphics2D gc = (Graphics2D) g;
		drawTip(gc);
		gc.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(MainControl.Snow)//雪花效果
			mainControl.sEffect.draw(gc);
		if(MainControl.Boom)//烟花效果
			bomb.drawscatter(gc, 0.1,ThreadLocalRandom.current().nextInt(200, Constant.SCREEN_WIDTH-200) ,ThreadLocalRandom.current().nextInt(200, 500));
		if(MainControl.Line)//连线效果
			link.draw(gc);
		if(MainControl.PopBall)//弹球效果
			ball.draw(g);
	}
	
	//打印提示信息
	public void drawTip(Graphics2D g){
		g.setColor(Color.WHITE);
		int initY = 50;
		g.drawString("雪花效果"+MainControl.Snow, 50, initY+=20);
		g.drawString("烟花效果"+MainControl.Boom, 50, initY+=20);
		g.drawString("连线效果"+MainControl.Line, 50, initY+=20);
		g.drawString("弹球效果"+MainControl.PopBall, 50, initY+=20);
	}

}
