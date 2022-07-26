package simpleDel;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	private RandomForm temp;
	private ArrayList<RandomForm> labels;
	private Graphics2D g2D;
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(800, 600));
		this.setFocusable(true);
		this.setLayout(null);
		this.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		
		labels = new ArrayList<RandomForm>();
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == 1) {
					temp = new RandomForm(e.getX(), e.getY());
					
					temp.addMouseListener(new MouseAdapter() {
						
						@Override
						public void mousePressed(MouseEvent e) {
							if (e.getButton() == 2) {
								labels.remove(e.getSource());
								repaint();
							}
						}
						
					});
					
					MyPanel.this.add(temp);
					labels.add(temp);
					repaint();
					
				} 
				
			}
			
		});
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		g2D = (Graphics2D) g;
		
		g2D.setBackground(Color.white);
		g2D.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		for (RandomForm i : labels) {
			i.paint(g2D);
		}
		
	}
}
