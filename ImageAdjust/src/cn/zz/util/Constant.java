package cn.zz.util;

import java.awt.Toolkit;

public interface Constant {
	int FRAME_WIDTH = 400;
	int FRAME_HEIGHT = 200;
	
	int SCREEN_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int SCREEN_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	int FRAME_X=(SCREEN_WIDTH-FRAME_WIDTH)/2;
	int FRAME_Y=(SCREEN_HEIGHT-FRAME_HEIGHT)/2;
	
	int FILE_WIDTH = FRAME_WIDTH ;
	int FILE_HEIGHT = 100 ;
	
	int CANVAS_WIDTH = FRAME_WIDTH;
	int CANVAS_HEIGHT = FRAME_HEIGHT-FILE_HEIGHT;
	
	int CANVAS_X = 0 ;
	int CANVAS_Y = FILE_HEIGHT ;
	

}
