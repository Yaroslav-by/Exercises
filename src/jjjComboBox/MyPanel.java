package jjjComboBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends JPanel {
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(220, 200));
		this.setFocusable(true);
		
		String[] colors = {"Красный", "Оранжевый", "Желтый", "Зеленый", "Голубой",
				"Синий", "Фиолетовый"};
		JComboBox<String> box = new JComboBox<String>(colors);
		
		JCheckBox cBox = new JCheckBox();
		cBox.setText("Свой вариант");
		
		JTextField tF = new JTextField();
		tF.setPreferredSize(new Dimension(180, 30));
		tF.setEnabled(false);
		tF.setText("Placeholder");

		cBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cBox.isSelected()) {
					tF.setEnabled(true);
					box.setEnabled(false);
				} else {
					tF.setEnabled(false);
					box.setEnabled(true);
				}
			}
			
		});
		
		JButton button = new JButton("Ответ");
		button.setFocusable(false);
		button.setPreferredSize(new Dimension(120, 30));
		
		JLabel label = new JLabel("Ответ: ");
		label.setPreferredSize(new Dimension(120, 30));
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (tF.isEnabled())
					label.setText("Ответ: " + tF.getText());
				else
					label.setText("Ответ: " + box.getSelectedItem());
				
			}
			
		});
		
		this.add(box);
		this.add(cBox);
		this.add(tF);
		this.add(button);
		this.add(label);
		
	}
}
