package Square;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MyPanel extends JPanel{

	private BufferedImage image;
	private int x = 0;
	private int y = 0;
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(700, 700));
		
		try {
			image = ImageIO.read(new File("Images\\Ball.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Timer timer = new Timer(20, (e) -> 
		
					newCoord()
		
								);
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		Random r = new Random();
		g2D.setBackground(new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255)));
		g2D.clearRect(0, 0, 700, 700);
		g2D.drawImage(image, x, y, this);
		
	}
	
	public void newCoord() {
		
		if (x < 570 && y == 0) {
			this.x = this.x + 5;
		} else if (x == 570 && y < 570) {
			this.y = this.y + 5;
		} else if (x > 0 && y == 570) {
			this.x = this.x - 5;
		} else {
			this.y = y - 5;
		}
		repaint();
		
	}
}
