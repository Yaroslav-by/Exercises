package myWord;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;

public class MyWord {

	private JFrame frame;
	
	private String fontName = "Times New Roman";
	private int fontStyle = Font.PLAIN;
	private int fontSize = 16;
	
	private File path = null;
	private String name = null;
	private boolean isPathReady = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyWord window = new MyWord();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyWord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 10));
		frame.setBounds(100, 100, 800, 600);
		frame.setTitle("MyWord");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelUp = new JPanel();
		frame.getContentPane().add(panelUp, BorderLayout.NORTH);
		panelUp.setLayout(new BorderLayout(0, 0));
		
		JPanel panelEmpty = new JPanel();
		panelEmpty.add(Box.createRigidArea(new Dimension(10, 10)));
		panelUp.add(panelEmpty, BorderLayout.NORTH);
		
		JPanel panelButtons = new JPanel();
		panelUp.add(panelButtons);
		panelButtons.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLeft = new JPanel();
		panelButtons.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.X_AXIS));
		
		JEditorPane textPane = new JEditorPane();
		textPane.setFont(new Font(fontName, fontStyle, fontSize));
		
		JLabel labelOpenedFile = new JLabel("\u041E\u0442\u043A\u0440\u044B\u0442 \u0444\u0430\u0439\u043B:");
		
		JButton buttonOpenFile = new JButton("\u041E\u0442\u043A\u0440\u044B\u0442\u044C \u0444\u0430\u0439\u043B");
		buttonOpenFile.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonOpenFile.setFocusable(false);
		buttonOpenFile.addActionListener((e) -> {
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showSaveDialog(buttonOpenFile);
			path = fileChooser.getSelectedFile();
			
			try (
					Scanner sc = new Scanner(path);
				) 
			{
			
				while (sc.hasNext()) {
					textPane.setText(textPane.getText() + sc.nextLine() + "\n");
				}
				
				isPathReady = true;
				String[] temp = path.getAbsolutePath().split("\\\\");
				name = temp[temp.length - 1];
				labelOpenedFile.setText("Открыт файл: " + name);
				
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(
	  					  					  frame, 
	  					  					  "Упс, что-то пошло не так!", 
	  					  					  "Ошибка!", 
	  					  					  JOptionPane.ERROR_MESSAGE
											 );
				e1.printStackTrace();
			}
			
		});
		panelLeft.add(Box.createRigidArea(new Dimension(20, 10)));
		panelLeft.add(buttonOpenFile);
		panelLeft.add(Box.createRigidArea(new Dimension(20, 10)));
		
		labelOpenedFile.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panelLeft.add(labelOpenedFile);
		
		JPanel panelRight = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelRight.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelButtons.add(panelRight, BorderLayout.EAST);
		
		JButton buttonSave = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C");
		buttonSave.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonSave.setFocusable(false);
		buttonSave.addActionListener((e) -> {
			
			if (!isPathReady) {
				
				try (
						Scanner sc = new Scanner(textPane.getText());
						FileWriter writer = new FileWriter(System.getProperty("user.dir") + "\\Text.txt");
					) 
				{
					while (sc.hasNext()) {
						String temp = sc.nextLine();
						writer.write(temp + "\n");
					}
					name = "Text.txt";
					labelOpenedFile.setText("Открыт файл: " + name);
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(
							  					  frame, 
							  					  "Упс, что-то пошло не так!", 
							  					  "Ошибка!", 
							  					  JOptionPane.ERROR_MESSAGE
												 );
					e1.printStackTrace();
				}
				
			} else {
				
				try (
						Scanner sc = new Scanner(textPane.getText());
						FileWriter writer = new FileWriter(path);
					) 
				{
					while (sc.hasNext()) {
						String temp = sc.nextLine();
						writer.write(temp + "\n");
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(
							  					  frame, 
							  					  "Упс, что-то пошло не так!", 
							  					  "Ошибка!", 
							  					  JOptionPane.ERROR_MESSAGE
												 );
					e1.printStackTrace();
				}
				
			}
			
		});
		panelRight.add(buttonSave);
		
		JButton buttonSaveAs = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C \u043A\u0430\u043A");
		buttonSaveAs.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonSaveAs.setFocusable(false);
		buttonSaveAs.addActionListener((e) -> {
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showSaveDialog(buttonSaveAs);
			path = fileChooser.getSelectedFile();
			
			try (
					Scanner sc = new Scanner(textPane.getText());
					FileWriter writer = new FileWriter(path);
				) 
			{
				while (sc.hasNext()) {
					String temp = sc.nextLine();
					writer.write(temp + "\n");
				}
				isPathReady = true;
				
				String[] temp = path.getAbsolutePath().split("\\\\");
				name = temp[temp.length - 1];
				labelOpenedFile.setText("Открыт файл: " + name);
				
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(
											  frame, 
											  "Упс, что-то пошло не так!", 
											  "Ошибка!", 
											  JOptionPane.ERROR_MESSAGE
											 );
				e1.printStackTrace();
			} catch (NullPointerException e2) {
				JOptionPane.showMessageDialog(
											  frame, 
											  "Вы не выбрали путь для сохранения!", 
											  "Ошибка!", 
											  JOptionPane.ERROR_MESSAGE
											 );
			}
			
		});
		panelRight.add(buttonSaveAs);
		panelRight.add(Box.createRigidArea(new Dimension(20, 10)));
		
		JPanel panelEmpty_1 = new JPanel();
		panelUp.add(panelEmpty_1, BorderLayout.SOUTH);
		
		Component rigidArea = Box.createRigidArea(new Dimension(10, 10));
		panelEmpty_1.add(rigidArea);
		
		JPanel panelForText = new JPanel();
		frame.getContentPane().add(panelForText, BorderLayout.CENTER);
		panelForText.add(Box.createRigidArea(new Dimension(20, 10)));
		panelForText.setLayout(new BoxLayout(panelForText, BoxLayout.X_AXIS));
		
		JPanel panelDown = new JPanel();
		frame.getContentPane().add(panelDown, BorderLayout.SOUTH);
		panelDown.setLayout(new BorderLayout(0, 0));
		
		JPanel panelRigid = new JPanel();
		panelDown.add(panelRigid, BorderLayout.SOUTH);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(10, 10));
		panelRigid.add(rigidArea_1);
		
		JPanel panelButtonsDown = new JPanel();
		panelDown.add(panelButtonsDown, BorderLayout.CENTER);
		
		JComboBox<String> comboFontSize = new JComboBox<String>();
		comboFontSize.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboFontSize.setModel(new DefaultComboBoxModel<String>(new String[] {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"}));
		comboFontSize.setSelectedIndex(6);
		comboFontSize.addActionListener((e) -> {
			
			fontSize = Integer.parseInt((String) comboFontSize.getSelectedItem());
			Font font = new Font(fontName, fontStyle, fontSize);
			textPane.setFont(font);
			
		});
		
		JComboBox<String> comboFontStyle = new JComboBox<String>();
		comboFontStyle.setModel(new DefaultComboBoxModel<String>(new String[] {"Times New Roman", "Tahoma", "Calibri", "Serif"}));
		comboFontStyle.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboFontStyle.addActionListener((e) -> {
			
			switch ((String) comboFontStyle.getSelectedItem()) {
				case "Times New Roman":
					fontName = "Times New Roman";
					break;
				case "Tahoma":
					fontName = "Tahoma";
					break;	
				case "Calibri":
					fontName = "Calibri";
					break;	
				case "Serif":
					fontName = "Serif";
					break;
			}
			
			Font font = new Font(fontName, fontStyle, fontSize);
			textPane.setFont(font);
			
		});
		panelButtonsDown.add(comboFontStyle);
		panelButtonsDown.add(comboFontSize);
		
		JCheckBox buttonBold = new JCheckBox("Bold");
		JCheckBox buttonItalic = new JCheckBox("Italic");
		buttonBold.setFont(new Font("Times New Roman", Font.BOLD, 16));
		buttonBold.setFocusable(false);
		buttonBold.addActionListener((e) -> {
			
			if (buttonBold.isSelected() && buttonItalic.isSelected()) {
				fontStyle = Font.BOLD | Font.ITALIC;
			} else if (buttonBold.isSelected()) {
				fontStyle = Font.BOLD;
			} else if (!buttonBold.isSelected() && buttonItalic.isSelected()) {
				fontStyle = Font.ITALIC;
			} else {
				fontStyle = Font.PLAIN;
			}
			Font font = new Font(fontName, fontStyle, fontSize);
			textPane.setFont(font);

		});
		panelButtonsDown.add(buttonBold);
		
		buttonItalic.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		buttonItalic.setFocusable(false);
		buttonItalic.addActionListener((e) -> {
			
			if (buttonBold.isSelected() && buttonItalic.isSelected()) {
				fontStyle = Font.BOLD | Font.ITALIC;
			} else if (buttonItalic.isSelected()) {
				fontStyle = Font.ITALIC;
			}  else if (buttonBold.isSelected() && !buttonItalic.isSelected()) {
				fontStyle = Font.BOLD;
			} else {
				fontStyle = Font.PLAIN;
			}
			Font font = new Font(fontName, fontStyle, fontSize);
			textPane.setFont(font);
			
		});
		panelButtonsDown.add(buttonItalic);
		
		JPanel panelRigid_1 = new JPanel();
		panelDown.add(panelRigid_1, BorderLayout.NORTH);
		
		Component rigidArea_1_1 = Box.createRigidArea(new Dimension(10, 10));
		panelRigid_1.add(rigidArea_1_1);
		
		JScrollPane scroll = new JScrollPane(
											textPane, 
											JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
											JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
											);
		panelForText.add(scroll);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 10));
		panelForText.add(rigidArea_2);
		
	}

}
