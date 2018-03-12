package com.zz.frame;

import com.zz.control.MouseControl;
import com.zz.control.SoftControl;

public class FrameAction {
private SoftControl softControl;
	
	public FrameAction(SoftControl softControl){
		this.softControl = softControl;
	}
	
	public void drawFrameAction(){
		int L_Y=(int)softControl.myFrame.getLocationOnScreen().getY();
		int L_X=(int)softControl.myFrame.getLocationOnScreen().getX();

		//����Y�ᳬ����Ļʱ����ΪY���ʼ�߶�
		if(L_Y+Constant.FRAME_HEIGHT>Constant.SCREEN_HEIGHT){
			SoftControl.ACTION_ID=Constant.WAIT;
			L_Y = Constant.FRAME_Y;
		}
		
		//��׹
		if(L_Y+Constant.FRAME_HEIGHT<Constant.SCREEN_HEIGHT){
			if(!MouseControl.isGrap){
				SoftControl.ACTION_ID=Constant.FALL;
				L_Y+=10;
			
			//��׹ʱ�����Զ��ı䶯��
			SoftControl.CAN_CHANGE_ACTION = false;
			}
			if(L_Y+Constant.FRAME_HEIGHT>=Constant.SCREEN_HEIGHT){
				L_Y = Constant.FRAME_Y;
				SoftControl.ACTION_ID = Constant.SIT;
				SoftControl.CAN_CHANGE_ACTION = true;
			}
		}
		
		//�߶�
		if(SoftControl.ACTION_ID==Constant.WALK){
			
			L_X-=10;
			if(L_X+Constant.FRAME_WIDTH<0){
				L_X=Constant.SCREEN_WIDTH;
			}
		}
		
		//˯��ʱ���Զ��ı䶯���ر�
		if(SoftControl.ACTION_ID==Constant.SLEEP){
			SoftControl.CAN_CHANGE_ACTION = false;
		}
		
		//�ȴ�ʱ�Զ��ȴ�������
		if(SoftControl.ACTION_ID==Constant.WAIT){
			SoftControl.CAN_CHANGE_ACTION = true;
		}
			
		softControl.myFrame.setLocation(L_X,L_Y);
	}
}
