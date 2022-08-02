package chooseRes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {

	public MyFrame() {
		
		String choice = (String) JOptionPane.showInputDialog(this, 
							"Choose resolution", 
							"Choose resolution", 
							JOptionPane.PLAIN_MESSAGE,
							null, 
							new String[] {"800x600", "1024x768", "1200x600", "1280x1024", 
									"1680x1050", "1920x1080"},
							null);
		
		String[] temp = choice.split("x");
		
		this.setSize(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Choose Res");
		this.setVisible(true);
		
	}
}
