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
	private boolean isStillPlaying = true;
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
		} else if (questionNumber == 11) {
			for (QuizButton i : quizButtons) {
				i.setEnabled(false);
				i.setVisible(false);
			}
			isStillPlaying = false;
			question.setText("Ваш результат: " + MyFrame.score + "/10");
			counter.setText("");
		}
		
		if (isStillPlaying) {
			//Берем из Map вопрос 
			String temp = null;
			for (Map.Entry<String, Map<String, Boolean>> entry : questions.entrySet()) {
				temp = (String) entry.getKey();
				question.setText(temp);
				
				//Берем по ключу вопросы и соответствующие им ответы с их правильностью
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
	
	}
	
	public ConcurrentHashMap<String, Map<String, Boolean>> getQuestions() {
		
		ConcurrentHashMap<String, Map<String, Boolean>> q = new ConcurrentHashMap<>();
		q.put("Что, согласно известной идиоме, точит болтун?", 
				new ConcurrentHashMap<String, Boolean>());
		q.get("Что, согласно известной идиоме, точит болтун?").put("Зубы", false);
		q.get("Что, согласно известной идиоме, точит болтун?").put("Вилы", false);
		q.get("Что, согласно известной идиоме, точит болтун?").put("Ножи", false);
		q.get("Что, согласно известной идиоме, точит болтун?").put("Лясы", true);
		
		q.put("Как иначе называют плод инжирового дерева?", 
				new ConcurrentHashMap<String, Boolean>());
		q.get("Как иначе называют плод инжирового дерева?").put("Фейхоа", false);
		q.get("Как иначе называют плод инжирового дерева?").put("Фига", true);
		q.get("Как иначе называют плод инжирового дерева?").put("Фалса", false);
		q.get("Как иначе называют плод инжирового дерева?").put("Финик", false);
		
		q.put("Как называется подъёмный механизм колодца?", 
				new ConcurrentHashMap<String, Boolean>());
		q.get("Как называется подъёмный механизм колодца?").put("Бретель", false);
		q.get("Как называется подъёмный механизм колодца?").put("Штанина", false);
		q.get("Как называется подъёмный механизм колодца?").put("Ворот", true);
		q.get("Как называется подъёмный механизм колодца?").put("Рукав", false);
		
		q.put("Кто внес решающий вклад в процесс вытаскивания репки?", 
				new ConcurrentHashMap<String, Boolean>());
		q.get("Кто внес решающий вклад в процесс вытаскивания репки?").put("Дед", false);
		q.get("Кто внес решающий вклад в процесс вытаскивания репки?").put("Мышка", true);
		q.get("Кто внес решающий вклад в процесс вытаскивания репки?").put("Внучка", false);
		q.get("Кто внес решающий вклад в процесс вытаскивания репки?").put("Жучка", false);
		
		q.put("Что обещал сделать Архимед, найдя точку опоры?", 
				new ConcurrentHashMap<String, Boolean>());
		q.get("Что обещал сделать Архимед, найдя точку опоры?").put("Сдвинуть Землю", true);
		q.get("Что обещал сделать Архимед, найдя точку опоры?").put("Выпить еще", false);
		q.get("Что обещал сделать Архимед, найдя точку опоры?").put("Перевернуть жизнь", false);
		q.get("Что обещал сделать Архимед, найдя точку опоры?").put("Перевернуть Вселенную", false);
		
		q.put("Что из этого не является музыкальным инструментом?", 
				new ConcurrentHashMap<String, Boolean>());
		q.get("Что из этого не является музыкальным инструментом?").put("Ксилофон", false);
		q.get("Что из этого не является музыкальным инструментом?").put("Металлофон", false);
		q.get("Что из этого не является музыкальным инструментом?").put("Саксофон", false);
		q.get("Что из этого не является музыкальным инструментом?").put("Граммофон", true);
		
		q.put("Женское имя, прославившее композитора Матвея Блантера?", 
				new ConcurrentHashMap<String, Boolean>());
		q.get("Женское имя, прославившее композитора Матвея Блантера?").put("Любовь", false);
		q.get("Женское имя, прославившее композитора Матвея Блантера?").put("Надежда", false);
		q.get("Женское имя, прославившее композитора Матвея Блантера?").put("Катюша", true);
		q.get("Женское имя, прославившее композитора Матвея Блантера?").put("Аленушка", false);
		
		q.put("Никогда не применялось для изготовления свечей?", 
				new ConcurrentHashMap<String, Boolean>());
		q.get("Никогда не применялось для изготовления свечей?").put("Стеарин", false);
		q.get("Никогда не применялось для изготовления свечей?").put("Керосин", true);
		q.get("Никогда не применялось для изготовления свечей?").put("Парафин", false);
		q.get("Никогда не применялось для изготовления свечей?").put("Воск", false);
		
		q.put("Какая из этих сказок не написана Г. Х. Андерсеном?", 
				new ConcurrentHashMap<String, Boolean>());
		q.get("Какая из этих сказок не написана Г. Х. Андерсеном?").put("Золушка", true);
		q.get("Какая из этих сказок не написана Г. Х. Андерсеном?").put("Дюймовочка", false);
		q.get("Какая из этих сказок не написана Г. Х. Андерсеном?").put("Русалочка", false);
		q.get("Какая из этих сказок не написана Г. Х. Андерсеном?").put("Огниво", false);
		
		q.put("Как называют сполохи огня в костре?", 
				new ConcurrentHashMap<String, Boolean>());
		q.get("Как называют сполохи огня в костре?").put("Пятки", false);
		q.get("Как называют сполохи огня в костре?").put("Ресницы", false);
		q.get("Как называют сполохи огня в костре?").put("Веки", false);
		q.get("Как называют сполохи огня в костре?").put("Языки", true);
		
		return q;
	}
}
