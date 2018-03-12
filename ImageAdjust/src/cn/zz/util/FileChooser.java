package cn.zz.util;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JOptionPane;


public class FileChooser {
	String filepath =null;
	String filename =null;
	
	public String getFilepath() {
		return filepath;
	}

	public String getFilename() {
		return filename;
	}

	public FileChooser(){
		FileDialog dialog = new FileDialog(new Frame(), "选择图片", FileDialog.LOAD);  
		FilenameFilter ff=new FilenameFilter(){//window环境无法使用
			public boolean accept(File dir, String name) {
				return name.endsWith(".jpg")||name.endsWith(".JPG")||name.endsWith(".png");
			}
		};
		dialog.setFilenameFilter(ff);
		dialog.setVisible(true);	
		filepath = dialog.getDirectory() ;
		if(dialog.getFile()!=null)
		if(dialog.getFile().endsWith(".jpg")||
				dialog.getFile().endsWith(".JPG")||
				dialog.getFile().endsWith(".png")){
			filename = dialog.getFile();
		}else{
			filename = null ;
			filepath = null ;
			JOptionPane.showMessageDialog(null, "请选择JPG/PNG格式的图片");
		}
	}
	
	
}

