package httpRequestTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUIForQuiz extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Quiz quiz = new Quiz();
	private int n = 1;
	private int score = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIForQuiz frame = new GUIForQuiz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIForQuiz() {
		setTitle("Quiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		try {
			quiz.askAndAnswerQuestion();
		} catch (URISyntaxException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		JLabel questionLabel = new JLabel(n++ + ". " + quiz.getQuestion());
		questionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(questionLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JLabel answerLabel = new JLabel();
		answerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_2.add(answerLabel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnSubmit.setFocusable(false);
		btnSubmit.addActionListener((e) -> {
			
			try {
				if (textField.getText().equals(quiz.getAnswer())) {
					score++;
					answerLabel.setText("Right you are!");
					textField.setText("");
				} else {
					answerLabel.setText("Nope!");
					textField.setText("");
				}
				
				if (n == 9) {
					answerLabel.setText("You answered " + score + "/8 questions!");
					questionLabel.setText("");
					btnSubmit.setEnabled(false);
					textField.setEnabled(false);
					textField.setEditable(false);
				} else {
					quiz.askAndAnswerQuestion();
					questionLabel.setText(n++ + ". " + quiz.getQuestion());
				}

			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnReset.setFocusable(false);
		btnReset.addActionListener((e) -> {
			
			score = 0;
			n = 1;
			btnSubmit.setEnabled(true);
			textField.setEnabled(true);
			textField.setEditable(true);
			
			try {
				quiz.askAndAnswerQuestion();
			} catch (URISyntaxException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			
			questionLabel.setText(n++ + ". " + quiz.getQuestion());
			answerLabel.setText("");
			
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 666, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(77)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(btnSubmit)
						.addComponent(btnReset))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
	}
}
