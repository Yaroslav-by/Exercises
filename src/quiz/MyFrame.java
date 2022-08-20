package quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MyFrame extends JFrame {

	private Font font;
	
	private Map<String, Map<String, Boolean>> questions;
	
	private QuizButton[] quizButtons = new QuizButton[4];
	private JLabel counter;
	private JLabel question;
	
	private boolean isReady = false;
	private static int score = 0;
	private int questionNumber = 1;
	
	public MyFrame() {
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Quiz");
		this.setLayout(new FlowLayout());
		
		font = new Font("Times New Roman", Font.PLAIN, 25);
		
		//Счетчик вопросов
		JPanel counterPanel = new JPanel();
		counterPanel.setPreferredSize(new Dimension(750, 40));
		counterPanel.setLayout(new BorderLayout());
		
		counter = new JLabel("Вопрос " + questionNumber + "/10");
		counter.setFont(font);
		counterPanel.add(counter, BorderLayout.EAST);
		
		//Панель вопросов
		JPanel questionPanel = new JPanel();
		questionPanel.setPreferredSize(new Dimension(650, 120));
		questionPanel.setBorder(new LineBorder(Color.black, 5, true));
		questionPanel.setBackground(Color.white);
		
		question = new JLabel();
		question.setFont(font);
		
		questionPanel.add(question);
		
		//Панель ответов
		JPanel answerPanel = new JPanel();
		answerPanel.setLayout(new GridLayout(2, 2, 20, 20));
		answerPanel.setPreferredSize(new Dimension(650, 200));
		
		quizButtons[0] = new QuizButton();
		setSettingB(quizButtons[0]);
		quizButtons[1] = new QuizButton();
		setSettingB(quizButtons[1]);
		quizButtons[2] = new QuizButton();
		setSettingB(quizButtons[2]);
		quizButtons[3] = new QuizButton();
		setSettingB(quizButtons[3]);
		
		answerPanel.add(quizButtons[0]);
		answerPanel.add(quizButtons[1]);
		answerPanel.add(quizButtons[2]);
		answerPanel.add(quizButtons[3]);
		
		this.add(Box.createRigidArea(new Dimension(800, 30)));
		this.add(counterPanel);
		this.add(Box.createRigidArea(new Dimension(800, 30)));
		this.add(questionPanel);
		this.add(Box.createRigidArea(new Dimension(800, 30)));
		this.add(answerPanel);
		this.setVisible(true);
		
		startGame();
		
	}
	
	private void setSettingB(QuizButton b) {
		
		b.setFocusable(false);
		b.setFont(font);
		b.setBorder(new LineBorder(Color.black, 5, true));
		b.setBackground(Color.LIGHT_GRAY);
		b.addActionListener((e) -> {
			
			if (b.isRight()) {
				MyFrame.score += 1;
			}
			counter.setText("Вопрос " + ++questionNumber + "/10");
			System.out.println(MyFrame.score);
			startGame();
			
		});
		
	}
	
	private void startGame() {
		
		//Генерируем вопросы
		if (!isReady) {
			questions = getQuestions();	
		}
		
		//Берем из Map вопрос 
		String temp = null;
		for (Map.Entry<String, Map<String, Boolean>> entry : questions.entrySet()) {
			temp = (String) entry.getKey();
			question.setText(temp);
			
			//Берем по ключу вопросы, соответствующие ему ответы с их правильностью
			int x = 0;
			for (Map.Entry<String, Boolean> entry1 : questions.get(temp).entrySet()) {
				for (int i = x++; i < quizButtons.length; i++) {
					quizButtons[i].setText((String) entry1.getKey());
					quizButtons[i].setRight((Boolean) entry1.getValue());
				}
			}
			break;
		}

		isReady = true;				//Вопросы готовы
		questions.remove(temp);     //Удаляем из Map вопрос, который добавили для исключения повторения
	
	}
	
	public ConcurrentHashMap<String, Map<String, Boolean>> getQuestions() {
		
		ConcurrentHashMap<String, Map<String, Boolean>> q = new ConcurrentHashMap<>();
		q.put("Вопрос 1", new ConcurrentHashMap<String, Boolean>());
		q.get("Вопрос 1").put("Ответ 1", false);
		q.get("Вопрос 1").put("Ответ 2", true);
		q.get("Вопрос 1").put("Ответ 3", false);
		q.get("Вопрос 1").put("Ответ 4", false);
		
		q.put("Вопрос 2", new ConcurrentHashMap<String, Boolean>());
		q.get("Вопрос 2").put("Ответ 5", false);
		q.get("Вопрос 2").put("Ответ 6", true);
		q.get("Вопрос 2").put("Ответ 7", false);
		q.get("Вопрос 2").put("Ответ 8", false);
		
		return q;
	}
}
