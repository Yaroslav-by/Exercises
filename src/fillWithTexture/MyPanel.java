package fillWithTexture;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	TexturePaint p;

	MyPanel() {
		
		this.setPreferredSize(new Dimension(800, 600));
	
		try {
			BufferedImage i = ImageIO.read(new File("Images//GrassTexture.jpg"));
			p = new TexturePaint(i, new Rectangle(50, 50));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setPaint(p);
		g2D.fillRect(0, 0, 800, 600);
		
	}

}
