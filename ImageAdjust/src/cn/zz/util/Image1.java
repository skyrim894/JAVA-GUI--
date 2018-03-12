package cn.zz.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import cn.zz.controller.MainController;

public class Image1 {
	
	private static Image smallImage = null;
	private static ImageIcon imageIcon = null;
	private static int i_width;
	private static int i_height;
	
	public static void getImage(String os){
		imageIcon = new ImageIcon(os);
		Image image = imageIcon.getImage();
		i_width = imageIcon.getIconWidth();
		i_height = imageIcon.getIconHeight();
		
		if((imageIcon.getIconWidth()>=Constant.CANVAS_WIDTH||imageIcon.getIconHeight()>=Constant.CANVAS_HEIGHT)){
			if(imageIcon.getIconWidth()>imageIcon.getIconHeight()){
				i_width = Constant.CANVAS_WIDTH;
				i_height = (imageIcon.getIconHeight()*Constant.CANVAS_WIDTH)/imageIcon.getIconWidth();
			}else{
				i_height = Constant.CANVAS_HEIGHT;
				i_width = imageIcon.getIconWidth()*Constant.CANVAS_HEIGHT/imageIcon.getIconHeight();
			}
		}
		smallImage = image.getScaledInstance(i_width, i_height, Image.SCALE_SMOOTH);
	}

	
	public static BufferedImage setAlpha(int flag) {
		BufferedImage smallBufferedImage = null;
		int temp = 0;
		int[] list = new int[i_width/(flag<1?1:flag)+1];
		if(smallImage!=null)
		try {
			smallBufferedImage = new BufferedImage(i_width, i_height, BufferedImage.TYPE_4BYTE_ABGR);
			
			Graphics2D g2D = (Graphics2D) smallBufferedImage.getGraphics();
			g2D.drawImage(new ImageIcon(smallImage).getImage(), 0, 0,null);
			
			for (int j1 = smallBufferedImage.getMinY(); j1 < smallBufferedImage.getHeight(); j1++) {
				for (int j2 = smallBufferedImage.getMinX(); j2 < smallBufferedImage.getWidth(); j2++) {
					int pixel = smallBufferedImage.getRGB(j2, j1);
					int[] rgb = new int[3];
					rgb[0] = (pixel & 0xff0000) >> 16;
					rgb[1] = (pixel & 0xff00) >> 8;
					rgb[2] = (pixel & 0xff);
					
					//对超过阈值的像素颜色进行处理
					if (rgb[0] > flag || rgb[1] > flag || rgb[2] > flag) {
						if(MainController.WHITE_BLACK) pixel = 0xffffffff;
						if(MainController.BACKGROUND_HIDDEN) pixel = 0xff000000|pixel;
						if(MainController.FOREGROUND_HIDDEN) pixel = 0xffffffff;
						if(MainController.BACKGROUND_TRANSPARENT) ;
						if(MainController.TO_SHADOW) ;
						
					} else {
						if(MainController.WHITE_BLACK) pixel = 0xff000000;
						if(MainController.BACKGROUND_HIDDEN) pixel = 0xff000000;
						if(MainController.FOREGROUND_HIDDEN) pixel = 0xff000000|pixel;
						if(MainController.BACKGROUND_TRANSPARENT) pixel = 0xff000000^pixel;
						if(MainController.TO_SHADOW){
							if(j2%3==0&&j1%3==0){
								pixel = 0xff000000;
							}else if(j2%3==1&&j1%3==1){
								pixel = 0xff000000;
							}else if(j2%3==2&&j1%3==2){
								pixel = 0xff000000;
							}else{
								pixel = 0xffeeeeee;
							}
						}
					}
					if(MainController.TO_CANVAS){
						if(j2%3==0&&j1%3==0){
							pixel = pixel|0x333333;
						}
					}
					if(MainController.PIXIV){
						flag = flag<1?1:flag;
						if(j2%flag==0&&j1%flag==0){
							temp = pixel;
							list[j2/flag] = temp;
						}else{
							if(j1%flag==0)
								pixel = temp;
							else
								pixel = list[j2/flag];
						}
					}
					
					smallBufferedImage.setRGB(j2, j1, pixel);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return smallBufferedImage;
	}
}
