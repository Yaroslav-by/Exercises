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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;

public class ScaleKazan extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScaleKazan frame = new ScaleKazan();
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
	public ScaleKazan() {
		setTitle("\u041C\u0430\u0441\u0448\u0442\u0430\u0431\u0438\u0440\u0443\u0435\u043C \u041A\u0430\u0437\u0430\u043D\u044C");
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
		
		JSlider scaleSlider = new JSlider();
		scaleSlider.setMinorTickSpacing(2);
		scaleSlider.setMajorTickSpacing(4);
		scaleSlider.setValue(15);
		scaleSlider.setPaintTicks(true);
		scaleSlider.setPaintLabels(true);
		scaleSlider.setMaximum(17);
		scaleSlider.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scaleSlider.addChangeListener((e) -> {
			
			panelForPicture.removeAll();
			try {
				HttpRequest getRequest = HttpRequest.newBuilder()
						.uri(new URI("https://static-maps.yandex.ru/1.x/?l=map&ll=49.109876%2C55.796020&z="
								+ scaleSlider.getValue()))
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
		panelForButton.add(scaleSlider);
	}

}
