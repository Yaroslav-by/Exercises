package race;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MyPanel extends JPanel {
	
	private BufferedImage blueCar;
	private BufferedImage greenCar;
	private BufferedImage pinkCar;
	private BufferedImage redCar;
	private BufferedImage yellowCar;
	
	private String status = "Ready!";
	
	private Timer start;
	private Timer game;
	
	private static int x = 0;
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(800, 800));
		try {
			blueCar = ImageIO.read(new File("Images\\Cars\\BlueCar.png"));
			greenCar = ImageIO.read(new File("Images\\Cars\\GreenCar.png"));
			pinkCar = ImageIO.read(new File("Images\\Cars\\PinkCar.png"));
			redCar = ImageIO.read(new File("Images\\Cars\\RedCar.png"));
			yellowCar = ImageIO.read(new File("Images\\Cars\\YellowCar.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		start = new Timer(1000, (e) -> changeStatus(MyPanel.x));
		start.start();
		
		game = new Timer(1000, (e) -> System.out.println("da"));
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setBackground(Color.LIGHT_GRAY);
		g2D.clearRect(0, 0, 800, 800);
		g2D.setColor(Color.black);
		g2D.setStroke(new BasicStroke(5));
		g2D.drawLine(0, 300, 800, 300);
		g2D.drawLine(0, 400, 800, 400);
		g2D.drawLine(0, 500, 800, 500);
		g2D.drawLine(0, 600, 800, 600);
		g2D.drawLine(0, 700, 800, 700);
		g2D.setFont(new Font("Times New Roman", Font.BOLD, 50));
		g2D.drawString(status, 325, 100);
		g2D.drawImage(blueCar, 0, 250, this);
		g2D.drawImage(greenCar, 0, 350, this);
		g2D.drawImage(pinkCar, 0, 450, this);
		g2D.drawImage(redCar, 0, 550, this);
		g2D.drawImage(yellowCar, 0, 650, this);
		
	}
	
	public void changeStatus(int x) {
		MyPanel.x++;
		
		switch (x) {
			case 1:
				this.status = "Set!";
				repaint();
				break;
			case 2:
				this.status = "Let's go!";
				repaint();
				break;
			case 3:
				start.stop();
				game.start();
		}
	}
	
	
	public void playGame() {
		
	}
	

}
