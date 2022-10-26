package httpRequestTestCatFoxesDog;

import java.awt.Image;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DogImage extends JLabel {

	private Image image;
	
	DogImage() {
		
		try {
			HttpRequest getRequest = HttpRequest.newBuilder()
					.uri(new URI("https://dog.ceo/api/breeds/image/random"))
					.GET()
					.build();
			
			HttpClient client = HttpClient.newHttpClient();
			
			HttpResponse<String> getResponse = client.send(getRequest, BodyHandlers.ofString());
			
            JSONParser jsonParser = new JSONParser();
            try {
				JSONObject jsonObject = (JSONObject) jsonParser.parse(getResponse.body().toString());
				String temp = (String) jsonObject.get("message");
				URL url = new URL(temp);
				image = ImageIO.read(url);
				this.setIcon(new ImageIcon(image));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
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
