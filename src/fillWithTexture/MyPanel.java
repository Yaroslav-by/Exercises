package fillWithTexture;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	BufferedImage image;

	MyPanel() {
		
		this.setPreferredSize(new Dimension(800, 600));
		
		try {
			image = ImageIO.read(new File("Images//GrassTexture.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(image.getWidth() + " " + image.getHeight());
	}

}
