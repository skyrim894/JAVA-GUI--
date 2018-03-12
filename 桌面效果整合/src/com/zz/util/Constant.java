package com.zz.util;

import java.awt.Toolkit;

public interface Constant {
	//��Ļ���
	int SCREEN_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int SCREEN_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	//��ʼλ��
	int FRAME_X= 0;
	int FRAME_Y= 0;
	
	//��ʼ�ٶ�
	int INIT_SPEED = 10;
	
	//���Ӵ�С
	int INIT_MIN_SiZE = 1;
	int INIT_MAX_SiZE = 10;
	
}
