package firstLabel;

import java.awt.Font;

import javax.swing.*;

public class MyFrame extends JFrame {

	public MyFrame() {
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("First label");
		this.setVisible(true);
		
		JLabel label = new JLabel("Моя первая надпись!");
		label.setFont(new Font("Calibri", Font.ITALIC, 50));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label);
		
		
	}
}
