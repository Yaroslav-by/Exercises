package twoWindows;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(800, 600));
		this.setFocusable(true);
		
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == 32) {
					
					JOptionPane.showMessageDialog(getComponentPopupMenu(), 
							"Your name is " + JOptionPane.showInputDialog(
									getComponentPopupMenu(), 
									"Enter your name: "), 
							"2 Windows", 
							JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}
			
		});
	}
}
