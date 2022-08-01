package confirmWindow;

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
					// 0 - yes
					// 1 - no
					
					int firstQ = JOptionPane.showConfirmDialog(getComponentPopupMenu(), 
							"Are you enjoying learning java?", 
							"Confirm Window", 
							JOptionPane.YES_NO_OPTION);
					
					int secondQ = JOptionPane.showConfirmDialog(getComponentPopupMenu(), 
							"Will you continue?", 
							"Confirm Window", 
							JOptionPane.YES_NO_OPTION);
					
					JOptionPane.showMessageDialog(getComponentPopupMenu(), 
						((firstQ == 0 && secondQ == 0) ? "You are enjoying java and you will continue" : 
						 (firstQ == 1 && secondQ == 0) ? "You aren't enjoying java but you will continue" :
						 (firstQ == 0 && secondQ == 1) ? "You are enjoying java but you wont continue" :
						  "You aren't enjoing java and you wont continue"), 
							"Confirm Window", 
							JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}
			
		});
	}
}
