package com.zz.util;

import java.awt.Toolkit;

public interface Constant {
	int SCREEN_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int SCREEN_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	int FRAME_X= 0;
	int FRAME_Y= 0;
	
	//snow效果的雪花大小控制
	int INIT_MIN_SiZE = 1;
	int INIT_MAX_SiZE = 10;
	
}
