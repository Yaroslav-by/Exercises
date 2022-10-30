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

public class BermudaTriangle extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BermudaTriangle frame = new BermudaTriangle();
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
	public BermudaTriangle() {
		setTitle("\u0411\u0435\u0440\u043C\u0443\u0434\u0441\u043A\u0438\u0439 \u0442\u0440\u0435\u0443\u0433\u043E\u043B\u044C\u043D\u0438\u043A");
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
		
		JButton buttonShow = new JButton("\u041F\u043E\u043A\u0430\u0437\u0430\u0442\u044C \u0431\u0435\u0440\u043C\u0443\u0434\u0441\u043A\u0438\u0439 \u0442\u0440\u0435\u0443\u0433\u043E\u043B\u044C\u043D\u0438\u043A!");
		buttonShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonShow.setFocusable(false);
		buttonShow.addActionListener((e) -> {
			
			try {
				HttpRequest getRequest = HttpRequest.newBuilder()
						.uri(new URI("https://static-maps.yandex.ru/1.x/?l=map&ll=-62.369074%2C26.597836&z=4&"
								+ "pl=c:000000,f:7B68EE,w:3,"
								+ "-80.032826,25.864635,"
								+ "-65.066677,32.035298,"
								+ "-67.838186,18.330201,"
								+ "-80.032826,25.864635"))
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
