package jjjTextArea;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyPanel extends JPanel {
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(600, 500));
		this.setFocusable(true);
		
		JTextField tF = new JTextField("Новая строка");
		tF.setPreferredSize(new Dimension(500, 40));
		
		JButton b = new JButton("Записать");
		b.setPreferredSize(new Dimension(100, 30));
		b.setFocusable(false);
		
		JTextArea area = new JTextArea(20,50);
		area.setEditable(false);
		JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setEnabled(true);
		
		b.addActionListener((e) -> area.setText(area.getText() + "\n" + tF.getText()));
		
		this.add(tF);
		this.add(b);
		this.add(scroll);
		
		
	}
}
