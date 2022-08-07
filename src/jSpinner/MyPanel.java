package jSpinner;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class MyPanel extends JPanel {
	
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(800, 600));
		this.setFocusable(true);
		this.setLayout(null);
		
		JLabel l = new JLabel("Сколько книг Вы возьмете с собой в лагерь?", SwingConstants.CENTER);
		l.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l.setBounds(200, 100, 400, 50);
		
		JLabel l1 = new JLabel("Ответ: ");
		l1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l1.setBounds(210, 300, 400, 50);
		
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setBounds(550, 170, 50, 30);
		
		JButton b = new JButton("Ответить");
		b.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b.setBounds(340, 250, 120, 40);
		b.setFocusable(false);
		b.addActionListener((e) -> l1.setText("Ответ: " + spinner.getValue()));
		
		this.add(spinner);
		this.add(l);
		this.add(b);
		this.add(l1);
		
	}
}
