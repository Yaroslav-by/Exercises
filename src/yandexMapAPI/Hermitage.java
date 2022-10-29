package yandexMapAPI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Hermitage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hermitage frame = new Hermitage();
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
	/**
	 * 
	 */
	public Hermitage() {
		setTitle("\u042D\u0440\u043C\u0438\u0442\u0430\u0436");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelForPicture = new JPanel();
		contentPane.add(panelForPicture, BorderLayout.CENTER);
		
		JPanel panelForButton = new JPanel();
		contentPane.add(panelForButton, BorderLayout.SOUTH);
		
		JButton buttonShow = new JButton("\u041F\u043E\u043A\u0430\u0437\u0430\u0442\u044C \u042D\u0440\u043C\u0438\u0442\u0430\u0436!");
		buttonShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonShow.setFocusable(false);
		buttonShow.addActionListener((e) -> {
			
			try {
				HttpRequest getRequest = HttpRequest.newBuilder()
						.uri(new URI("https://static-maps.yandex.ru/1.x/?l=map&ll=30.317294%2C59.939347&z=14"))
						.GET()
						.build();
				
				HttpClient client = HttpClient.newHttpClient();
				
				HttpResponse<InputStream> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofInputStream());
				Image image = ImageIO.read(getResponse.body());
				
				JLabel label = new JLabel();
				label.setIcon(new ImageIcon(image));
				panelForPicture.add(label);
				paintAll(getGraphics());
				
			} catch (URISyntaxException | IOException | InterruptedException e1) {
				e1.printStackTrace();
			}

					
			
		});
		panelForButton.add(buttonShow);
	}

}
