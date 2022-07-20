package solarSystem;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MyPanel extends JPanel {

	private int x = (int) (10 * Math.cos(Math.toRadians(0)));
	private int y = (int) (10 * Math.sin(Math.toRadians(0)));
	private BufferedImage imageSun;
	private BufferedImage imageEarth;
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(700, 700));
		
		try {
			imageSun = ImageIO.read(new File("Images\\Sun.png"));
			imageEarth = ImageIO.read(new File("Images\\Earth.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(x + " " + y);
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setBackground(Color.darkGray);
		g2D.clearRect(0, 0, 700, 700);
		g2D.drawImage(imageSun, 0, 0, this);
		g2D.drawImage(imageEarth, 400, 400, this);
		
		
	}
}
