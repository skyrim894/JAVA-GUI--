package com.zz.control;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.zz.entity.Fall;
import com.zz.entity.Grap;
import com.zz.entity.Icons;
import com.zz.entity.Say;
import com.zz.entity.Sit;
import com.zz.entity.Sleep;
import com.zz.entity.Summon;
import com.zz.entity.Wait;
import com.zz.entity.Walk;
import com.zz.frame.FrameAction;
import com.zz.frame.MyFrame;
import com.zz.frame.MyPanel;

/**
 *	所有类的主控制器
 */
public class SoftControl {
	public static int ACTION_ID = 0;//表示动作执行时的id
	public static boolean CAN_CHANGE_ACTION = true; 
	public static boolean IS_WORD_VISIBLE = false;
	public static int NOW_WORD = 0 ; 
	
	public MyPanel myPanel;
	public MyFrame myFrame;
	public Icons icons = new Icons();
	public TimerControl timerControl;
	public FrameAction frameAction;
	
	//设置各个动作的初始坐标（相对窗口）
	public Fall fall = new Fall(10,50);
	public Grap grap = new Grap(10, 50);
	public Sit sit = new Sit(10,50);
	public Sleep sleep = new Sleep(10,50);
	public Wait wait = new Wait(10,50);
	public Walk walk = new Walk(10,50);
	public Summon summon = new Summon(10,50);
	public Say say = new Say(0,10);
	
	public SoftControl(){
		this.myPanel = new MyPanel(this);
		
		myFrame = new MyFrame(myPanel);
		myFrame.setVisible(true);
		myFrame.setIconImage(Icons.ICON_IMG);
		
		MouseControl mouseControl = new MouseControl(this);
		myFrame.addMouseListener(mouseControl);
		myFrame.addMouseMotionListener(mouseControl);
		
		frameAction = new FrameAction(this);
		timerControl = new TimerControl(this);
		timerControl.start();
		//添加系统托盘
		if(SystemTray.isSupported()){
			SystemTray systemTray = SystemTray.getSystemTray();
			ActionListener listener1 = new ActionListener() {
				   public void actionPerformed(ActionEvent e) {
					   myFrame.setVisible(true);	
				   }	    
			   };
    		ActionListener listener2 = new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	myFrame.setVisible(false);	
				    }	    
			   };	
			   
			PopupMenu popup = new PopupMenu();
			   
			MenuItem mainFrameItem = new MenuItem("(max)");
			mainFrameItem.addActionListener(listener1);
			   
			MenuItem limitFrameItem = new MenuItem("(min)");
			limitFrameItem.addActionListener(listener2);
			   
			MenuItem exitItem = new MenuItem("(exit)");
			exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     if (JOptionPane.showConfirmDialog(null, "exit", "exit?", JOptionPane.YES_NO_OPTION) == 0) {
			      System.exit(0);
			     }
			    }
			});
			   
			popup.add(mainFrameItem);
			popup.add(limitFrameItem);
			popup.add(exitItem);
			   
			TrayIcon  trayIcon = new TrayIcon(Icons.ICON_IMG, "パガ", popup);
			trayIcon.addActionListener(listener1);
			trayIcon.addActionListener(listener2);
			try {
			    systemTray.add(trayIcon);
			} catch (AWTException e1) {
			    e1.printStackTrace();
			}
		}
		
	}
}
