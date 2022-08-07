package changeSizeOfLabel;

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
		
	}
}
