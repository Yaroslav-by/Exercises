package enterPassword;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class MyFrame extends JFrame {

	public MyFrame() {
		
		UIManager.put("OptionPane.yesButtonText", "��");
		UIManager.put("OptionPane.noButtonText", "���");
		UIManager.put("OptionPane.cancelButtonText", "������");
		UIManager.put("OptionPane.okButtonText" , "������");
		
		if (JOptionPane.showConfirmDialog(this, 
				"������������ ���, ������� ������������������?", 
				"�����������", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
			System.exit(1);
		} 
		
		UIManager.put("OptionPane.noButtonText", "������");
		boolean isRight = false;
		String login = null;
		while (isRight == false) {
			try {
				login = JOptionPane.showInputDialog(this, "������� �����: ");
				if (login.length() < 5 || login.contains(" ")) {
					continue;
				} else {
					isRight = true;
				}	
			} catch (NullPointerException e) {
				System.exit(1);
			}
			
		}

		isRight = false;
		String password = null;
		while (isRight == false) {
			try {
				
				JPasswordField pF = new JPasswordField();
				pF.setEchoChar('*');
				if (JOptionPane.showConfirmDialog(this, pF, "������� ������: ", JOptionPane.YES_NO_OPTION) ==
						JOptionPane.NO_OPTION) {
					System.exit(1);
				}
				
				password = pF.getText();
				
				if ((password.length() <= 8) || password.contains(" ")) {
					continue;
				} else if (password.length() > 8) {
					int numC = 0;
					int strC = 0;
					for (int i = 0; i <= password.length(); i++) {
						if (numC >= 1 && strC >= 1) {
							isRight = true;
						} else if (Character.isDigit(password.charAt(i))) {
							numC++;
						} else if (Character.isLetter(password.charAt(i))) {
							strC++;
						}
					}
				}	
			} catch (NullPointerException e) {
				continue;
			} catch (StringIndexOutOfBoundsException e) {
				continue;
			}

		}
		
		isRight = false;
		while (isRight == false) {
			JPasswordField pF = new JPasswordField();
			pF.setEchoChar('*');
			if (JOptionPane.showConfirmDialog(this, pF, "����������� ������: ", JOptionPane.YES_NO_OPTION) ==
					JOptionPane.NO_OPTION) {
				System.exit(1);
			}
			
			String newPassword = pF.getText();
			if (newPassword.equals(password)) {
				isRight = true;
			} else {
				continue;
			}

		}
		
		String[] information = {"��� �����: " + login, "��� ������: " + password};
		JOptionPane.showMessageDialog(this, information, "����������", JOptionPane.INFORMATION_MESSAGE, null);
		System.exit(1);
		
	}
}
