package com.zz.util;

import java.awt.Toolkit;

public interface Constant {
	//��Ļ���
	int SCREEN_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int SCREEN_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	//��ʼλ��
	int FRAME_X = 0;
	int FRAME_Y = 0 ;
//	int FRAME_Y=(SCREEN_HEIGHT-FRAME_HEIGHT)/2;
	
	
	int ANI_NO = 0;//�޶���
	int ANI_START = 1;//������򿪣���ʼ����
	int ANI_END = 2;//��������
	
	//Ĭ�ϱ����ַ
	String SAVE_PATH = "C:\\Users\\Administrator\\Desktop\\";
}
