package race;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {
		MyPanel panel = new MyPanel();
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Race");
		this.add(panel);
		this.pack();
		this.setVisible(true);
		
	}
}
