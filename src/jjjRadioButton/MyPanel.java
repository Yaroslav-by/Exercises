package jjjRadioButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyPanel extends JPanel {
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(220, 220));
		this.setFocusable(true);
		
		ButtonGroup bG = new ButtonGroup();
		
		JRadioButton r1 = new JRadioButton("Зима");
		r1.setPreferredSize(new Dimension(180, 30));
		r1.setFocusable(false);
		
		JRadioButton r2 = new JRadioButton("Весна");
		r2.setPreferredSize(new Dimension(180, 30));
		r2.setFocusable(false);
		
		JRadioButton r3 = new JRadioButton("Лето");
		r3.setPreferredSize(new Dimension(180, 30));
		r3.setFocusable(false);
		
		JRadioButton r4 = new JRadioButton("Осень");
		r4.setPreferredSize(new Dimension(180, 30));
		r4.setFocusable(false);
		
		bG.add(r1);
		bG.add(r2);
		bG.add(r3);
		bG.add(r4);
		
		JButton b = new JButton("Ответить");
		b.setPreferredSize(new Dimension(90, 30));
		b.setFocusable(false);
		
		JLabel l = new JLabel("Ответ: ");
		l.setPreferredSize(new Dimension(170, 30));
		
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (r1.isSelected())
					l.setText("Ответ: " + r1.getText());
				else if (r2.isSelected())
					l.setText("Ответ: " + r2.getText());
				else if (r3.isSelected())
					l.setText("Ответ: " + r3.getText());
				else if (r4.isSelected())
					l.setText("Ответ: " + r4.getText());
				
			}
			
		});
		
		this.add(r1);
		this.add(r2);
		this.add(r3);
		this.add(r4);
		this.add(b);
		this.add(l);
		
		
	}
}
