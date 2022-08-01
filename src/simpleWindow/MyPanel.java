package simpleWindow;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
							"My name is Yaroslav", 
							"Simple Window", 
							JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}
			
		});
	}
}
