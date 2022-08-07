package changeSizeOfLabel;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyFrame extends JFrame {

	public MyFrame() {
		
		MyPanel panel = new MyPanel();
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Change Size Of Label");
		
		JLabel label = new JLabel("Моя первая надпись!");
		label.setFont(new Font("Calibri", Font.ITALIC, 50));
		
		JSlider slider = new JSlider(5, 100, 50);
		slider.setPreferredSize(new Dimension(950, 50));
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(15);
		slider.setPaintLabels(true);
		slider.setFont(new Font("Calibri", Font.ITALIC, 20));
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				label.setFont(new Font("Calibri", Font.ITALIC, slider.getValue()));
				
			}
		});
		
		panel.add(Box.createRigidArea(new Dimension(1000, 200)));
		panel.add(label);
		panel.add(slider);
		
		this.add(panel);
		this.setVisible(true);
	}
}
