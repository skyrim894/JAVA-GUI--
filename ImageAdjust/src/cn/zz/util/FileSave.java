package cn.zz.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import cn.zz.controller.MainController;

public class FileSave {
	
	public static void save(String os,String path,int flag){
		
		try {
            ImageIcon imageIcon = new ImageIcon(os);
            int temp = 0;
    		int[] list = new int[imageIcon.getIconWidth()/(flag<1?1:flag)+1];
            BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(),imageIcon.getIconHeight()
                , BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();
            g2D.drawImage(imageIcon.getImage(), 0, 0,imageIcon.getImageObserver());
            for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage.getHeight(); j1++) {
              for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage.getWidth(); j2++) {
            	  int pixel = bufferedImage.getRGB(j2, j1);
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
                bufferedImage.setRGB(j2, j1, pixel);
              }
            }
            ImageIO.write(bufferedImage, "png",  new File(path));
          }
          catch (Exception e) {
            e.printStackTrace();
          }
	}
}
