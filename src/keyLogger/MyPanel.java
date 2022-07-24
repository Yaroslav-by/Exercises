package keyLogger;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class MyPanel extends JPanel {
	
	MyPanel() {
		
		this.setPreferredSize(new Dimension(800, 600));
		
		JLabel label = new JLabel();
		label.setFont(new Font("Dialog", Font.BOLD, 30));
		label.setText("Enter text:");
		label.setHorizontalAlignment(JLabel.CENTER);
		
		JTextArea area = new JTextArea(15, 60);
		area.setFont(new Font("Dialog", Font.PLAIN, 16));
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		
		JButton button = new JButton("Save");
		button.setPreferredSize(new Dimension(150, 50));
		button.setFont(new Font("Dialog", Font.BOLD, 30));
		button.setFocusable(false);
		button.addActionListener((e) -> {
			
			try (Scanner sc = new Scanner(area.getText());
				 FileWriter writer = new FileWriter("Text.txt");) 
			{
				while(sc.hasNext()) {
					String temp = sc.nextLine();
					writer.write(temp + "\n");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		});
		
		this.add(label);
		this.add(new JScrollPane(area));
		this.add(button);
		
	}
	
}
