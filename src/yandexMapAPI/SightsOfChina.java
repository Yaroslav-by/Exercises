package yandexMapAPI;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class SightsOfChina extends JFrame {

	private JPanel contentPane;
	private JLabel label = new JLabel();
	private Image[] images = new Image[5];
	private int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SightsOfChina frame = new SightsOfChina();
					frame.setVisible(true);
					frame.changeImage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the frame.
	 */
	public SightsOfChina() {
		
		images[0] = getImage("https://static-maps.yandex.ru/1.x/?l=sat,skl&ll=117.234280%2C40.676926&z=16");
		images[1] = getImage("https://static-maps.yandex.ru/1.x/?l=sat,skl&ll=112.935583%2C34.507184&z=16");
		images[2] = getImage("https://static-maps.yandex.ru/1.x/?l=sat,skl&ll=116.390151%2C39.915687&z=15");
		images[3] = getImage("https://static-maps.yandex.ru/1.x/?l=sat,skl&ll=116.404085%2C39.879921&z=15");
		images[4] = getImage("https://static-maps.yandex.ru/1.x/?l=sat,skl&ll=109.255209%2C34.381013&z=16");
		
		setTitle("\u0414\u043E\u0441\u0442\u043E\u043F\u0440\u0438\u043C\u0435\u0447\u0430\u0442\u0435\u043B\u044C\u043D\u043E\u0441\u0442\u0438 \u041A\u0438\u0442\u0430\u044F");
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
		panelForButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton prevButton = new JButton("\u041D\u0430\u0437\u0430\u0434");
		prevButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prevButton.setFocusable(false);
		prevButton.addActionListener((e) -> {
			
			try {
				i--;
				label.setIcon(new ImageIcon(images[i]));
				repaint();	
			} catch (ArrayIndexOutOfBoundsException e1) {
				i = 4;
				label.setIcon(new ImageIcon(images[i]));
				repaint();
			}

		});
		panelForButton.add(prevButton);
		
		JButton nextButton = new JButton("\u0412\u043F\u0435\u0440\u0435\u0434");
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nextButton.setFocusable(false);
		nextButton.addActionListener((e) -> {
			
			try {
				i++;
				label.setIcon(new ImageIcon(images[i]));
				repaint();	
			} catch (ArrayIndexOutOfBoundsException e1) {
				i = 0;
				label.setIcon(new ImageIcon(images[i]));
				repaint();
			}
			
		});
		panelForButton.add(nextButton);
		
		panelForPicture.add(label);
		
	}
	
	private Image getImage(String uri) {
		
		try {
			HttpRequest getRequest = HttpRequest.newBuilder()
					.uri(new URI(uri))
					.GET()
					.build();
			
			HttpClient client = HttpClient.newHttpClient();
			
			HttpResponse<InputStream> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofInputStream());
			Image image = ImageIO.read(getResponse.body());
			return image;
		} catch (URISyntaxException | IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	private void changeImage() {
		
		Thread thread = new Thread() {
			
			public void run() {
				
				for (i = 0; i < images.length + 1; i++) {
					
					try {
						label.setIcon(new ImageIcon(images[i]));
						repaint();
						Thread.sleep(3000);
					} catch (ArrayIndexOutOfBoundsException e) {
						i = -1;
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
				}
			}
			
		};
		
		thread.start();
		
	}
}
