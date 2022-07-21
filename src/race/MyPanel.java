package race;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(800, 800));
		
	}
	
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
		
	}

}
