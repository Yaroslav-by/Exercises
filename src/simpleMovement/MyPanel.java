package simpleMovement;

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
	private boolean isPressed;
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(800, 600));
		this.setFocusable(true);
		this.setLayout(null);
		
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
								MyPanel.this.remove(e.getComponent());
								repaint();
							} else if (e.getButton() == 3) {
								isPressed = true;
							}
						}
						
						public void mouseReleased(MouseEvent e) {
							
							isPressed = false;
							
						}
						
					});
					
					temp.addMouseMotionListener(new MouseAdapter() {
						
					    public void mouseMoved(MouseEvent e) {
//					    	if (isPressed) {
//					    		System.out.println("Mouse moved on copmonent" + e.getComponent());
//					    	}
					        
					    }
					    
					    public void mouseDragged(MouseEvent e) {
					    	if (isPressed) {
					    		System.out.println("Mouse drugged" + e);
					    		
					    		((RandomForm) e.getComponent()).setX(
					    						e.getComponent().getBounds().getX() + e.getX());
					    		((RandomForm) e.getComponent()).setY(
					    						e.getComponent().getY() + e.getY());
					    		e.getComponent().setBounds(e.getComponent().getX(), 
					    									e.getComponent().getY(), 
					    									e.getComponent().getWidth(), 
					    									e.getComponent().getHeight());
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
