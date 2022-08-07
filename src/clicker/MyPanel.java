package clicker;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyPanel extends JPanel {
	
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(800, 600));
		this.setFocusable(true);
		this.setLayout(null);
		
		JLabel l = new JLabel("0", SwingConstants.CENTER);
		l.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l.setBounds(300, 250, 200, 50);
		
		JButton b = new JButton("Click me!");
		b.setPreferredSize(new Dimension(200, 50));
		b.setFocusable(false);
		b.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b.setBounds(300, 200, 200, 50);
		b.addActionListener((e) -> l.setText(Integer.toString(Integer.parseInt(l.getText()) + 1)));
	
		this.add(b);
		this.add(l);
		
	}
}
