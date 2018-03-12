package com.zz.frame;
import java.awt.Color;
import javax.swing.JFrame;

 
public class MyFrame extends JFrame implements Constant{  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame(MyPanel myPanel) {  
    	this.setUndecorated(true); // 不装饰  
    	this.setSize(FRAME_WIDTH, FRAME_HEIGHT); // 设置窗口大小  
//      AWTUtilities.setWindowOpaque(this, false);//窗口透明 
//      AWTUtilities.setWindowOpacity(this, 0.8f);
        this.setBackground(new Color(0,0,0,0));//alpha分量为零
        this.setLocation(FRAME_X, FRAME_Y);
        this.setAlwaysOnTop(true);
        this.setContentPane(myPanel);
//        this.setVisible(true);
    }
}