package Diagonal;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MyPanel extends JPanel{

	private BufferedImage image;
	private int x = 0;
	private int y = 0;
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(700, 700));
		
		try {
			image = ImageIO.read(new File("Images\\Car.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		Anonymous class
//		Timer timer = new Timer(1000, new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("da");
//			}
//			
//		});
//		timer.start();
		
//		Lambda expression
		Timer timer = new Timer(20, (e) ->  
		
					setNewCoord()
		
								);
		timer.start();

	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setBackground(Color.lightGray);
		g2D.clearRect(0, 0, 700, 700);
		g2D.drawImage(image, x, y, this);
		
	}
	
	public void setNewCoord() {
		this.x = this.x + 3;
		this.y = this.y + 3;
		if (x > 700 && y > 700) {
			this.x = -20;
			this.y = -20;
		}
		repaint();
	}
	
}


