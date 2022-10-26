package httpRequestTestCatFoxesDog;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Component;

public class CatsFoxesDogs extends JFrame {

	private JPanel contentPane;
	private JPanel panelForImage;
	private CatImage catImage;
	private DogImage dogImage;
	private FoxImage foxImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatsFoxesDogs frame = new CatsFoxesDogs();
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
	public CatsFoxesDogs() {
		setTitle("Cats, Foxes and Dogs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelForImage = new JPanel();
		contentPane.add(panelForImage, BorderLayout.CENTER);
		
		JPanel panelForButtons = new JPanel();
		contentPane.add(panelForButtons, BorderLayout.WEST);
		panelForButtons.setLayout(new BoxLayout(panelForButtons, BoxLayout.Y_AXIS));
		
		panelForButtons.add(Box.createRigidArea(new Dimension(300, 100)));
		
		JButton catButton = new JButton("\u041A\u043E\u0442\u0438\u043A\u0430!");
		catButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		catButton.setAlignmentY(Component.TOP_ALIGNMENT);
		catButton.setFocusable(false);
		catButton.setPreferredSize(new Dimension(150, 50));
		catButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		catButton.addActionListener((e) -> {
			
			panelForImage.removeAll();
			catImage = new CatImage();
			panelForImage.add(catImage);
			catImage.changeSize(panelForImage);
			
		});
		panelForButtons.add(catButton);
		
		panelForButtons.add(Box.createRigidArea(new Dimension(150, 50)));
		
		JButton dogButton = new JButton("\u0421\u043E\u0431\u0430\u0447\u043A\u0443!");
		dogButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		dogButton.setFocusable(false);
		dogButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dogButton.addActionListener((e) -> {
			
			panelForImage.removeAll();
			dogImage = new DogImage();
			panelForImage.add(dogImage);
			dogImage.changeSize(panelForImage);
			
		});
		panelForButtons.add(dogButton);
		
		panelForButtons.add(Box.createRigidArea(new Dimension(150, 50)));
		
		JButton foxButton = new JButton("\u041B\u0438\u0441\u0438\u0447\u043A\u0443!");
		foxButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		foxButton.setFocusable(false);
		foxButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		foxButton.addActionListener((e) -> {
			
			panelForImage.removeAll();
			foxImage = new FoxImage();
			panelForImage.add(foxImage);
			foxImage.changeSize(panelForImage);
			
		});
		panelForButtons.add(foxButton);
		
		JPanel panelUpRigidArea = new JPanel();
		contentPane.add(panelUpRigidArea, BorderLayout.NORTH);
		
		Component rigidArea = Box.createRigidArea(new Dimension(150, 50));
		panelUpRigidArea.add(rigidArea);
		
		JPanel panelDownRigidArea = new JPanel();
		contentPane.add(panelDownRigidArea, BorderLayout.SOUTH);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(150, 50));
		panelDownRigidArea.add(rigidArea_1);
		
		JPanel panelRightRigidArea = new JPanel();
		contentPane.add(panelRightRigidArea, BorderLayout.EAST);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(200, 50));
		panelRightRigidArea.add(rigidArea_2);
	}

	public void paint(Graphics g) {
		
		super.paint(g);
		try {
			catImage.changeSize(panelForImage);
			dogImage.changeSize(panelForImage);
			foxImage.changeSize(panelForImage);
		} catch (NullPointerException e) {
			System.out.println("No worries, all is under control!");
		}
		
	}
	
}
