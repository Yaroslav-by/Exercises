package simpleMovement;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

	public void setX(double x) {
		this.x = (int) x;
	}

	public int getY() {
		return y;
	}

	public void setY(double y) {
		this.y = (int) y;
	}

	RandomForm(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		Random r = new Random();
		
		this.setBounds(x, y, r.nextInt(10, 70), r.nextInt(10, 70));
		this.setBackground(new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255)));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setColor(getBackground());
		g2D.drawOval(x, y, this.getWidth(), this.getHeight());
		g2D.fillOval(x, y, this.getWidth(), this.getHeight());
		
	}
}
