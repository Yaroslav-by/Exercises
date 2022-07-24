package simpleAdding;

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
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(800, 600));
		this.setFocusable(true);
		this.setLayout(null);
		
		labels = new ArrayList<RandomForm>();
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				temp = new RandomForm(e.getX(), e.getY());
				MyPanel.this.add(temp);
				labels.add(temp);
				repaint();
			}
			
		});
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		
		for (RandomForm i : labels) {
			i.paint(g2D);
		}
		
	}
}
