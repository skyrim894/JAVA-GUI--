package cn.zz.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.zz.frame.MyFrame;
import cn.zz.frame.MyPanel;
import cn.zz.util.Constant;
import cn.zz.util.FileChooser;
import cn.zz.util.FileSave;
import cn.zz.util.Image1;

public class MainController implements Constant{
	public MyPanel myPanel;
	public MyFrame myFrame;
	public TimerController timerController;
	public MouseController mouseController;
	
	public static String file ;
	public static int BLOCK_X = CANVAS_WIDTH>>2 ;
	public static boolean IS_BLOCK = false ;
	
	public static boolean WHITE_BLACK = false;
	public static boolean BACKGROUND_HIDDEN = false;
	public static boolean FOREGROUND_HIDDEN = false;
	public static boolean BACKGROUND_TRANSPARENT = false;
	public static boolean TO_SHADOW = false;
	public static boolean TO_CANVAS = false;
	public static boolean PIXIV = false;
	
	
	public MainController(){
		this.myPanel = new MyPanel(this);
		
		myFrame = new MyFrame(myPanel);
		initFrame(myFrame);
		myFrame.setVisible(true);
		
		timerController = new TimerController(this);
		timerController.start();
		
		mouseController = new MouseController(this);
		myFrame.addMouseListener(mouseController);
		myFrame.addMouseMotionListener(mouseController);
	}
	
	public void initFrame(JFrame frame){
		frame.setLayout(null);
		JPanel panel = new JPanel();
		panel.setSize(FILE_WIDTH, FILE_HEIGHT);
		panel.setLocation(0, 0);
		
		final JTextField filename = new JTextField(20);
		JButton choose = new JButton("选择文件");
		JButton save = new JButton("保存");
		
		final JButton type1 = new JButton("黑白");
		final JButton type2 = new JButton("保留亮色");
		final JButton type3 = new JButton("保留暗色");
		final JButton type4 = new JButton("暗色转为透明");
		final JButton type5 = new JButton("暗色转为阴影");
		final JButton type6 = new JButton("画布效果");
		final JButton type7 = new JButton("马赛克效果");
		
		
		panel.add(filename);
		panel.add(choose);
		panel.add(save);
		
		panel.add(type1);
		panel.add(type2);
		panel.add(type3);
		panel.add(type4);
		panel.add(type5);
		panel.add(type6);
		panel.add(type7);
		
		frame.add(panel);
		
		choose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FileChooser fc = new FileChooser(); 
				String filepath = null;
				if(fc.getFilepath()!=null&&fc.getFilename()!=null){
					filepath = fc.getFilepath()+fc.getFilename();
					Image1.getImage(filepath);
				}else{
					return ;
				}
				filename.setText(filepath);
				file = filepath;
			}
		});
		
		save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(file!=null){
					FileChooser fc = new FileChooser(); 
					String path = null;
					if(fc.getFilepath()!=null&&fc.getFilename()!=null){
						path = fc.getFilepath()+fc.getFilename();
					}else{
						return ;
					}
					if(file!=null&&path!=null&&file.trim()!=""&&path.trim()!=""){
						int flag = ((MainController.BLOCK_X-20)*280)/(CANVAS_WIDTH-40)-10;
						FileSave.save(file, path, flag);
						JOptionPane.showMessageDialog(null, "保存成功");
					}
				}
			}
		});
		type1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 WHITE_BLACK = !WHITE_BLACK;
				 if(WHITE_BLACK){
						type1.setBackground(Color.YELLOW);
					}else{
						type1.setBackground(Color.DARK_GRAY);
					}
			}
		});
		type2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BACKGROUND_HIDDEN = !BACKGROUND_HIDDEN;
				if(BACKGROUND_HIDDEN){
					type2.setBackground(Color.YELLOW);
				}else{
					type2.setBackground(Color.GRAY);
				}
			}
		});
		type3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FOREGROUND_HIDDEN = !FOREGROUND_HIDDEN;
				if(FOREGROUND_HIDDEN){
					type3.setBackground(Color.YELLOW);
				}else{
					type3.setBackground(Color.GRAY);
				}
			}
		});
		type4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BACKGROUND_TRANSPARENT = !BACKGROUND_TRANSPARENT;
				if(BACKGROUND_TRANSPARENT){
					type4.setBackground(Color.YELLOW);
				}else{
					type4.setBackground(Color.GRAY);
				}
			}
		});
		type5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TO_SHADOW = !TO_SHADOW;
				if(TO_SHADOW){
					type5.setBackground(Color.YELLOW);
				}else{
					type5.setBackground(Color.GRAY);
				}
			}
		});
		type6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TO_CANVAS = !TO_CANVAS;
				if(TO_CANVAS){
					type6.setBackground(Color.YELLOW);
				}else{
					type6.setBackground(Color.GRAY);
				}
			}
		});
		type7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PIXIV = !PIXIV;
				if(PIXIV){
					type7.setBackground(Color.YELLOW);
				}else{
					type7.setBackground(Color.GRAY);
				}
			}
		});
		
	}
}
