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

		//窗口Y轴超出屏幕时重置为Y轴初始高度
		if(L_Y+Constant.FRAME_HEIGHT>Constant.SCREEN_HEIGHT){
			SoftControl.ACTION_ID=Constant.WAIT;
			L_Y = Constant.FRAME_Y;
		}
		
		//下坠
		if(L_Y+Constant.FRAME_HEIGHT<Constant.SCREEN_HEIGHT){
			if(!MouseControl.isGrap){
				SoftControl.ACTION_ID=Constant.FALL;
				L_Y+=10;
			
			//下坠时不能自动改变动作
			SoftControl.CAN_CHANGE_ACTION = false;
			}
			if(L_Y+Constant.FRAME_HEIGHT>=Constant.SCREEN_HEIGHT){
				L_Y = Constant.FRAME_Y;
				SoftControl.ACTION_ID = Constant.SIT;
				SoftControl.CAN_CHANGE_ACTION = true;
			}
		}
		
		//走动
		if(SoftControl.ACTION_ID==Constant.WALK){
			
			L_X-=10;
			if(L_X+Constant.FRAME_WIDTH<0){
				L_X=Constant.SCREEN_WIDTH;
			}
		}
		
		//睡觉时，自动改变动作关闭
		if(SoftControl.ACTION_ID==Constant.SLEEP){
			SoftControl.CAN_CHANGE_ACTION = false;
		}
		
		//等待时自动等待动作打开
		if(SoftControl.ACTION_ID==Constant.WAIT){
			SoftControl.CAN_CHANGE_ACTION = true;
		}
			
		softControl.myFrame.setLocation(L_X,L_Y);
	}
}
