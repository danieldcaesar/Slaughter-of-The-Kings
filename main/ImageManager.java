package main;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.image.BufferedImage;

/**
   The ImageManager class manages the loading and processing of images.
*/

public class ImageManager {
      
   	public ImageManager () {

	}

	public static Image loadImage (String fileName) {
		return new ImageIcon(fileName).getImage();
	}

	public static BufferedImage loadBufferedImage(String filename) {
		BufferedImage bi = null;
		FileInputStream fis = null;
		File file = new File (filename);
			if(!file.exists()) System.out.println("file "+filename+" failed.");
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
		

		try {
			bi = ImageIO.read(fis);
		}
		catch (IOException ioe) {
			System.out.println ("Error opening file " + filename + ":" + ioe);
		}
		return bi;
	}


  	// make a copy of the BufferedImage src

	public static BufferedImage copyImage(BufferedImage src) {
		if (src == null)
			return null;


		int imWidth = src.getWidth();
		int imHeight = src.getHeight();

		BufferedImage copy = new BufferedImage (imWidth, imHeight,
							BufferedImage.TYPE_INT_ARGB);

    		Graphics2D g2d = copy.createGraphics();

    		// copy image
    		g2d.drawImage(src, 0, 0, null);
    		g2d.dispose();

    		return copy; 
	  }

}


