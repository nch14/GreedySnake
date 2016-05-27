package view;

import javax.swing.*;
import java.awt.*;

public class ImageSetter extends ImageIcon{
	
	 /**
	 *
	 * new ImageSetter(String path, int width, int height).getNewIcon
	 */
	private static final long serialVersionUID = 1L;
	String Path;
	int Width;
	int Height;
	ImageIcon icon;
	public ImageSetter(String path, int width, int height) {
		if(width<=0||height<=0)
			return;
		icon = new ImageIcon(ImageSetter.class.getClassLoader().getResource(path).getPath());
		Image newImage = icon.getImage();
		newImage = newImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		icon.setImage(newImage);
	}
	public ImageIcon getNewIcon (){
		return icon;
	}


}

