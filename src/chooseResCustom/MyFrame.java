package chooseResCustom;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class MyFrame extends JFrame {

	public MyFrame() {
		
		JRadioButton r1 = new JRadioButton("800x600");
		JRadioButton r2 = new JRadioButton("1024x768");
		JRadioButton r3 = new JRadioButton("1200x600");
		JRadioButton r4 = new JRadioButton("1280x1024");
		JRadioButton r5 = new JRadioButton("1680x1050");
		JRadioButton r6 = new JRadioButton("1920x1080");
		
		ButtonGroup group = new ButtonGroup();
		group.add(r1);
		group.add(r2);
		group.add(r3);
		group.add(r4);
		group.add(r5);
		group.add(r6);
		
		Box panel = new Box(BoxLayout.Y_AXIS);
		panel.add(r1);
		r1.setSelected(true);
		panel.add(r2);
		panel.add(r3);
		panel.add(r4);
		panel.add(r5);
		panel.add(r6);
		
		JOptionPane.showMessageDialog(this, panel, "Выберите разрешение: ", JOptionPane.QUESTION_MESSAGE);
		
		if (r1.isSelected()) {
			this.setSize(800, 600);
		} else if (r2.isSelected()) {
			this.setSize(1024, 768);
		} else if (r3.isSelected()) {
			this.setSize(1200, 600);
		} else if (r4.isSelected()) {
			this.setSize(1280, 1024);
		} else if (r5.isSelected()) {
			this.setSize(1680, 1050);
		} else if (r6.isSelected()) {
			this.setSize(1920, 1080);
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Choose Res");
		this.setVisible(true);
		
	}
}
