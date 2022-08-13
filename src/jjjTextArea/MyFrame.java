package jjjTextArea;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {
		
		MyPanel panel = new MyPanel();
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setVisible(true);
		
	}
}
