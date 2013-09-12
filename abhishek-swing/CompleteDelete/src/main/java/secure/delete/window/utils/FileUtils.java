package secure.delete.window.utils;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;


public final class FileUtils {
	
	private static ClassLoader classLoader= Thread.currentThread().getContextClassLoader();
	public final static Image getImage(String image)
	{
		URL resource = classLoader.getResource(image);
	  	return Toolkit.getDefaultToolkit().getImage(resource);
				
	}
	public final static ImageIcon getImageIcon(String image)
	{
		URL resource = classLoader.getResource(image);
		return new ImageIcon(resource);
				
	}

}
