package DVD;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MyPanel extends JPanel {
	
	BufferedImage image;
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(700, 700));
		
		try {
			image = ImageIO.read(new File("Images//Car.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(image, 0, 0, this);
		
	}
}