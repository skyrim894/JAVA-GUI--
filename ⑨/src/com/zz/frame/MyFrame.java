package com.zz.frame;
import java.awt.Color;
import javax.swing.JFrame;

 
public class MyFrame extends JFrame implements Constant{  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame(MyPanel myPanel) {  
    	this.setUndecorated(true); // ��װ��  
    	this.setSize(FRAME_WIDTH, FRAME_HEIGHT); // ���ô��ڴ�С  
//      AWTUtilities.setWindowOpaque(this, false);//����͸�� 
//      AWTUtilities.setWindowOpacity(this, 0.8f);
        this.setBackground(new Color(0,0,0,0));//alpha����Ϊ��
        this.setLocation(FRAME_X, FRAME_Y);
        this.setAlwaysOnTop(true);
        this.setContentPane(myPanel);
//        this.setVisible(true);
    }
}