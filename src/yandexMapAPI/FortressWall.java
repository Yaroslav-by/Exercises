package yandexMapAPI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FortressWall extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FortressWall frame = new FortressWall();
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
	public FortressWall() {
		setTitle("\u041A\u0440\u0435\u043F\u043E\u0441\u0442\u043D\u0430\u044F \u0441\u0442\u0435\u043D\u0430");
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
		
		JButton buttonShow = new JButton("\u041F\u043E\u043A\u0430\u0437\u0430\u0442\u044C \u043A\u0440\u0435\u043F\u043E\u0441\u0442\u043D\u0443\u044E \u0441\u0442\u0435\u043D\u0443!");
		buttonShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonShow.setFocusable(false);
		buttonShow.addActionListener((e) -> {
			
			try {
				HttpRequest getRequest = HttpRequest.newBuilder()
						.uri(new URI("https://static-maps.yandex.ru/1.x/?l=sat,skl&ll=32.042749%2C54.781499&z=16"
								+ "&pt=32.041874,54.780619,pmwtm50"
								+ "~32.043751,54.780017,pmb"
								+ "~32.040114,54.781264,pm2ntl77"
								+ "~32.038444,54.782198,pmrds2"
								+ "~32.038093,54.782759,vkbkm"))
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
