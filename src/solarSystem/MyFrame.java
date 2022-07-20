package solarSystem;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {
		MyPanel panel = new MyPanel();
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Solar System");
		this.add(panel);
		this.pack();
		this.setVisible(true);
		
	}
}
