package DVD;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MyPanel extends JPanel {
	
	BufferedImage image;
	private int x = 800;
	private int y = 300;
	private boolean isToRightUp = true;
	private boolean isToLeftUp = false;
	private boolean isToRightDown = false;
	private boolean isToLeftDown = false;
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(1200, 600));
		
		try {
			image = ImageIO.read(new File("Images//logo1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Timer timer = new Timer(5, (e) -> {
			
			setNewCoord();
			
								});
		timer.start();
			
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setBackground(Color.black);
		g2D.clearRect(0, 0, 1200, 600);
		g2D.drawImage(image, x, y, this);
		
	}
	
	public void setNewCoord() {
		
		if ((this.x == 996 && this.y == 104) || (this.x == 394 && this.y == 506)) {
			changeLogo();
			this.isToRightUp = false;
			this.isToRightDown = false;
			this.isToLeftUp = true;
			this.isToLeftDown = false;
		} else if (this.x == 896 && this.y == 4) {
			changeLogo();
			this.isToRightUp = false;
			this.isToRightDown = false;
			this.isToLeftUp = false;
			this.isToLeftDown = true;
		} else if ((this.x == 510 && this.y == 2) || (this.x == 114 && this.y == 2)) {
			changeLogo();
			this.isToRightUp = false;
			this.isToRightDown = true;
			this.isToLeftUp = false;
			this.isToLeftDown = false;
		} else if ((this.x == 2 && this.y == 114) || (this.x == 604 && this.y == 492)) {
			changeLogo();
			this.isToRightUp = true;
			this.isToRightDown = false;
			this.isToLeftUp = false;
			this.isToLeftDown = false;
		} else if (this.x == 1000 && this.y == 96) {
			changeLogo();
			this.isToRightUp = true;
			this.isToRightDown = false;
			this.isToLeftUp = false;
			this.isToLeftDown = false;
			this.x = 800;
			this.y = 300;
		}
		
		if (this.isToRightUp) {
			this.x = this.x + 2;
			this.y = this.y - 2;
		} else if (this.isToLeftUp) {
			this.x = this.x - 2;
			this.y = this.y - 2;
		} else if (this.isToLeftDown) {
			this.x = this.x - 2;
			this.y = this.y + 2;
		} else if (this.isToRightDown) {
			this.x = this.x + 2;
			this.y = this.y + 2;
		}
		
		repaint();
	
	}
	
	public void changeLogo() {
		
		Random r = new Random();
		int n = r.nextInt(1, 4);
		System.out.println(n);
		if (n == 1) {
			try {
				this.image = ImageIO.read(new File("Images//logo1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} else if (n == 2) {
			try {
				this.image = ImageIO.read(new File("Images//logo2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} else {
			try {
				this.image = ImageIO.read(new File("Images//logo3.png"));
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
}