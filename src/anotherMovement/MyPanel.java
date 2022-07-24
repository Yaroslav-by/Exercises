package anotherMovement;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	private Image image;
	private int x = 0;
	private int y = 0;
	private TexturePaint tP;
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(800, 600));
		this.setFocusable(true);
		
		try {
			BufferedImage bF = ImageIO.read(new File("Images//GrassTexture.jpg"));
			tP = new TexturePaint(bF, new Rectangle(50, 50));
			image = ImageIO.read(new File("Images//Bender.png"));
			image = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				switch(e.getKeyCode()) {
					case (40):
						if (y + 50 == 600) 
							y = 0;
						else
							y = y + 50;
						repaint();
						break;
					case (38):
						if (y - 50 == -50)
							y = 550;
						else
							y = y - 50;
						repaint();
						break;
					case (39): 
						if (x + 50 == 800) 
							x = 0;
						else
							x = x + 50;
						repaint();
						break;
					case (37): 
						if (x - 50 == -50) 
							x = 750;
						else
							x = x - 50;
						repaint();
						break;
				}
			}	
		});
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(tP);
		g2D.fillRect(0, 0, 800, 600);
		g2D.drawImage(image, x, y, this);
	}
}
