package race;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
	
	private String status = "3 - Ready!";
	private int stringX = 325;
	private int stringY = 100;
	
	private Timer start;
	private Timer game;
	
	private static int x = 0;
	
	private Car blueCar;
	private Car greenCar;
	private Car pinkCar;
	private Car redCar;
	private Car yellowCar;
	
	MyPanel() {
		
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800, 800));
		
		blueCar = new Car("Images\\Cars\\BlueCar.png", 0, 250);
		greenCar = new Car("Images\\Cars\\GreenCar.png", 0, 350);
		pinkCar = new Car("Images\\Cars\\PinkCar.png", 0, 450);
		redCar = new Car("Images\\Cars\\RedCar.png", 0, 550);
		yellowCar = new Car("Images\\Cars\\YellowCar.png", 0, 650);
		
		this.add(blueCar);
		this.add(greenCar);
		this.add(pinkCar);
		this.add(redCar);
		this.add(yellowCar);
		
		start = new Timer(1000, (e) -> changeStatus(MyPanel.x));
		start.start();
		
		game = new Timer(30, (e) -> playGame());
		
	}
	
	@Override
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
		g2D.drawString(status, stringX, stringY);
		blueCar.paint(g2D);
		greenCar.paint(g2D);
		pinkCar.paint(g2D);
		redCar.paint(g2D);
		yellowCar.paint(g2D);
		
	}
	
	public void changeStatus(int x) {
		MyPanel.x++;
		
		switch (x) {
			case 1:
				this.status = "2 - Set!";
				repaint();
				break;
			case 2:
				this.status = "1 - Gooo!";
				repaint();
				break;
			case 3:
				this.status = "\\ʕ•́ᴥ•̀ʔ/";
				start.stop();
				game.start();
		}
	}
	
	
	public void playGame() {
		blueCar.moveCar();
		greenCar.moveCar();
		pinkCar.moveCar();
		redCar.moveCar();
		yellowCar.moveCar();
		
		isThereIsWinner();
		
		repaint();
	}
	
	public void isThereIsWinner() {
		
		if (blueCar.getX() >= getWidth() - 80) {
			blueCar.setWinner(true);
			this.status = "Blue Car Wins!!!";
			this.stringX = 180;
			game.stop();
		} else if (greenCar.getX() >= this.getWidth() - 80) {
			greenCar.setWinner(true);
			this.status = "Green Car Wins!!!";
			this.stringX = 180;
			game.stop();
		} else if (pinkCar.getX() >= this.getWidth() - 80) {
			pinkCar.setWinner(true);
			this.status = "Pink Car Wins!!!";
			this.stringX = 180;
			game.stop();
		} else if (redCar.getX() >= this.getWidth() - 80) {
			redCar.setWinner(true);
			this.status = "Red Car Wins!!!";
			this.stringX = 180;
			game.stop();
		} else if (yellowCar.getX() >= this.getWidth() - 80) {
			yellowCar.setWinner(true);
			this.status = "Yellow Car Wins!!!";
			this.stringX = 180;
			game.stop();
		}
		
	}
	

}
