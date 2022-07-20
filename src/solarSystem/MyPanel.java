package solarSystem;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MyPanel extends JPanel {

	private int x = (int) (150 * Math.cos(Math.toRadians(0)));
	private int y = (int) (150 * Math.sin(Math.toRadians(0)));
	private int x1 = (int) (300 * Math.cos(Math.toRadians(0)));
	private int y1 = (int) (300 * Math.sin(Math.toRadians(0)));
	private BufferedImage imageSun;
	private BufferedImage imageEarth;
	private BufferedImage imageEarth1;
	private int count = 1;
	private double count1 = 0.5;
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(700, 700));
		
		try {
			imageSun = ImageIO.read(new File("Images\\Sun.png"));
			imageEarth = ImageIO.read(new File("Images\\Earth.png"));
			imageEarth1 = ImageIO.read(new File("Images\\Earth.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Timer timer = new Timer(10, (e) -> newCoordEarth());
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setBackground(Color.darkGray);
		g2D.clearRect(0, 0, 700, 700);
		g2D.drawImage(imageSun, 0, 0, this);
		g2D.drawImage(imageEarth, 310 + this.x, 310 + this.y, this);
		g2D.drawImage(imageEarth1, 310 + this.x1, 310 + this.y1, this);
		
	}
	
	public void newCoordEarth() {
		
		this.x = (int) (150 * Math.cos(Math.toRadians(count)));
		this.y = (int) (150 * Math.sin(Math.toRadians(count)));
		this.x1 = (int) (300 * Math.cos(Math.toRadians(count1)));
		this.y1 = (int) (300 * Math.sin(Math.toRadians(count1)));
		count++;
		count1 += 0.5;
		repaint();
		
	}
}
