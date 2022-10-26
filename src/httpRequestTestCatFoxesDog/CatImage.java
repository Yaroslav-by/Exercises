package httpRequestTestCatFoxesDog;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CatImage extends JLabel {

	private Image image;
	
	CatImage() {
		
		try {
			HttpRequest getRequest = HttpRequest.newBuilder()
					.uri(new URI("https://cataas.com/cat"))
					.GET()
					.build();
			
			HttpClient client = HttpClient.newHttpClient();
			
			HttpResponse<InputStream> getResponse = client.send(getRequest, BodyHandlers.ofInputStream());
			
			image = ImageIO.read(getResponse.body());
			this.setIcon(new ImageIcon(image));
			
		} catch (URISyntaxException | IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void changeSize(JPanel panel) {
		
		image = image.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_AREA_AVERAGING);
		this.setIcon(new ImageIcon(image));
		repaint();
		
	}

	
	
}
