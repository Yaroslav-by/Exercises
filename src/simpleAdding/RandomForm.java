package simpleAdding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JLabel;

public class RandomForm extends JLabel {
	
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	RandomForm(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		Random r = new Random();
		
		this.setBounds(x, y, r.nextInt(10, 70), r.nextInt(10, 70));
		this.setBackground(new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255)));
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setColor(getBackground());
		g2D.drawOval(x, y, this.getWidth(), this.getHeight());
		g2D.fillOval(x, y, this.getWidth(), this.getHeight());
		
	}
}
