package com.zz.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ToClipboard implements Transferable{
	Image image;
	public ToClipboard(Image image) {
		this.image = image;
	
	}
	
	public void setImage(){
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(this,null);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return new DataFlavor[]{
			DataFlavor.imageFlavor	
		};
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return DataFlavor.imageFlavor.equals(flavor);
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if(!DataFlavor.imageFlavor.equals(flavor)){
			throw new UnsupportedFlavorException(flavor);
		}
		return image;
	};
	
}


