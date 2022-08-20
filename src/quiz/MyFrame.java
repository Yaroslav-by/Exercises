package quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MyFrame extends JFrame {

	private Font font;
	private HashMap<String, HashMap<String, Boolean>> questions;
	
	public MyFrame() {
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Quiz");
		this.setLayout(new FlowLayout());
		
		questions = new HashMap<>();
		questions.put("Вопрос 1", new HashMap<String, Boolean>());
		questions.get("Вопрос 1").put("Ответ 1", false);
		questions.get("Вопрос 1").put("Ответ 2", true);
		questions.get("Вопрос 1").put("Ответ 3", false);
		questions.get("Вопрос 1").put("Ответ 4", false);
		System.out.println(questions.get("Вопрос 1"));
		
		font = new Font("Times New Roman", Font.PLAIN, 25);
		
		//Счетчик вопросов
		JPanel counterPanel = new JPanel();
		counterPanel.setPreferredSize(new Dimension(750, 40));
		counterPanel.setLayout(new BorderLayout());
		
		JLabel counter = new JLabel("Вопрос 1/10");
		counter.setFont(font);
		counterPanel.add(counter, BorderLayout.EAST);
		
		//Панель вопросов
		JPanel questionPanel = new JPanel();
		questionPanel.setPreferredSize(new Dimension(650, 120));
		questionPanel.setBorder(new LineBorder(Color.black, 5, true));
		questionPanel.setBackground(Color.white);
		
		JLabel question = new JLabel();
		question.setFont(font);
		
		questionPanel.add(question);
		
		//Панель ответов
		JPanel answerPanel = new JPanel();
		answerPanel.setLayout(new GridLayout(2, 2, 20, 20));
		answerPanel.setPreferredSize(new Dimension(650, 200));
		
		QuizButton b1 = new QuizButton("ДА!!!!!!!!", true);
		b1.addActionListener((e) -> System.out.println(b1.isRight()));
		setSettingB(b1);
		QuizButton b2 = new QuizButton("ДАААА", false);
		setSettingB(b2);
		QuizButton b3 = new QuizButton("да", false);
		setSettingB(b3);
		QuizButton b4 = new QuizButton("ДАААААААААААААААА", false);
		setSettingB(b4);
		
		answerPanel.add(b1);
		answerPanel.add(b2);
		answerPanel.add(b3);
		answerPanel.add(b4);
		
		
		this.add(Box.createRigidArea(new Dimension(800, 30)));
		this.add(counterPanel);
		this.add(Box.createRigidArea(new Dimension(800, 30)));
		this.add(questionPanel);
		this.add(Box.createRigidArea(new Dimension(800, 30)));
		this.add(answerPanel);
		this.setVisible(true);
		
	}
	
	private void setSettingB(JButton b) {
		
		b.setFocusable(false);
		b.setFont(font);
		b.setBorder(new LineBorder(Color.black, 5, true));
		b.setBackground(Color.LIGHT_GRAY);
		
	}
}
