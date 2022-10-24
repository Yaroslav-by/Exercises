package httpRequestTest;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel{

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 450, 450);
        window.getContentPane().add(new Main());
        window.setVisible(true);

	}
	
	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try {
			HttpRequest getRequest = HttpRequest.newBuilder()
					.uri(new URI("https://static-maps.yandex.ru/1.x/?l=sat,skl&ll=28.807476,55.482549&z=13"))
					.GET()
					.build();
			
			HttpClient client = HttpClient.newHttpClient();
			HttpResponse<InputStream> getResponse = client.send(getRequest, BodyHandlers.ofInputStream());
			Image image = ImageIO.read(getResponse.body());
			g.drawImage(image, 0, 0, null);
		} catch (URISyntaxException | IOException | InterruptedException e) {
			e.printStackTrace();
		}

		
	}

}
