package enterPassword;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {

	public MyFrame() {
		
		if (JOptionPane.showConfirmDialog(this, 
				"Приветствуем Вас, желаете зарегистрироваться?", 
				"Регистрация", JOptionPane.YES_NO_OPTION) == 1) {
			System.exit(1);
		} 
		
		boolean isRight = false;
		while (isRight == false) {
			String temp = JOptionPane.showInputDialog(this, "Введите логин: ");
			if (temp.length() < 5 || temp.contains(" ")) {
				continue;
			} else {
				isRight = true;
			}
		}
		
		isRight = false;
		while (isRight == false) {
			String temp = JOptionPane.showInputDialog(this, "Введите пароль: ");
			if (temp.length() <= 8 || temp.contains(" ")) {
				continue;
			} else if (temp.length() > 8) {
				int numC = 0;
				int strC = 0;
				for (int i = 0; i <= temp.length(); i++) {
					if (numC >= 1 && strC >= 1) {
						isRight = true;
						break;
					} else if (Character.isDigit(temp.charAt(i))) {
						numC++;
					} else if (Character.isLetter(temp.charAt(i))) {
						strC++;
					}
				}
			}
		}
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}
