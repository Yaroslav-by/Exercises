package yandexMapAPI;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WorkSchedule {

	private final static String APIKEY = Apikey.getAPIKEYORGANIZATION();
	private final static String TYPE = "type=biz";
	private final static String LANG = "ru_RU";
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Какую организацию вы хотите найти?");
			String query = sc.nextLine().replace(" ", "+");
			
			try {
				HttpRequest getRequest = HttpRequest.newBuilder()
						.uri(new URI("https://search-maps.yandex.ru/v1/"
								+ "?text=" + query
								+ "&" + TYPE 
								+ "&lang=" + LANG
								+ "&apikey=" + APIKEY))
						.GET()
						.build();
				
				HttpClient client = HttpClient.newHttpClient();
				
				HttpResponse<String> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString()); 
				
				JSONObject jObj = new JSONObject(getResponse.body());
				JSONArray array = (JSONArray) jObj.get("features");
				
				if (array.length() == 0) {
					System.out.println("404 not found");
				} else {
					for (Object i : array) {
						try {
							JSONObject time = ((JSONObject) i).getJSONObject("properties")
										                      .getJSONObject("CompanyMetaData");
							System.out.print(time.get("address") + ": ");
							time = time.getJSONObject("Hours");
							System.out.println(time.get("text"));
						} catch (JSONException e1) {
							System.out.println("not found!");
						}
					} 
				}
			} catch (URISyntaxException | IOException | InterruptedException e) {
				e.printStackTrace();
			} 
			
		}

	}
	
}
