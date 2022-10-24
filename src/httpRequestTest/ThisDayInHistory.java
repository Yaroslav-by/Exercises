package httpRequestTest;

import java.awt.Dimension;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Date;
import java.util.Properties;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class ThisDayInHistory {

	public static void main(String[] args)  {

		JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 450, 450);
        
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		JLabel label = new JLabel();
		
		JButton button = new JButton("Okay");
		button.setFocusable(false);
		button.addActionListener((e) -> {
			
			Date selectedDate = (Date) datePicker.getModel().getValue();
			
			ThisDayInHistory dayInHistory = new ThisDayInHistory();
			try {
				label.setText(dayInHistory.getFact(selectedDate.getMonth(), selectedDate.getDate()));
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (NullPointerException e1) {
				label.setText("¬ведите дату!");
			}
			
		});
		
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(datePicker);
		box.add(Box.createRigidArea(new Dimension(0, 100)));
		box.add(button);
		box.add(Box.createRigidArea(new Dimension(0, 100)));
		box.add(label);
		
        window.setVisible(true);
		window.getContentPane().add(box);
		
	}
	
	public String getFact(int month, int day) throws URISyntaxException, InterruptedException, IOException {
			
		HttpRequest getRequest = HttpRequest.newBuilder()
				.uri(new URI("http://numbersapi.com/" + month +"/" + day +"/date"))
				.GET()
				.build();
			
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> getResponse = client.send(getRequest, BodyHandlers.ofString());
		return getResponse.body();
			
	}

}
