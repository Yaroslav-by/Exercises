package yandexMapAPI;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;



public class TheExactAddress{
	
	private final static String FORMAT = "format=json";
	private final static String APIKEY = Apikey.getAPIKEYGEOCODER();
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Какое здание Вы желаете найти?");
			String query = sc.nextLine();
			query = query.replace(" ", "%20");
			
			HttpRequest getRequest = HttpRequest.newBuilder()
					.uri(new URI("https://geocode-maps.yandex.ru/1.x/"
							+ "?geocode=" + query
							+ "&" + FORMAT
							+ "&apikey=" + APIKEY))
					.GET()
					.build();
			
			HttpClient client = HttpClient.newHttpClient();
			
			HttpResponse<String> getResponse = client.send(getRequest, BodyHandlers.ofString());

			String temp = getResponse.body().toString();
			
			String jsonString = temp.substring(temp.indexOf("["), temp.length());
			JSONArray array = new JSONArray(jsonString);
			
			if (array.length() == 0) {
				System.out.println("404 not found");
			} else {
				for (int i = 0; i < array.length(); i++) {
					JSONObject obj = array.getJSONObject(i);
					JSONObject obj1 = (JSONObject) obj.get("GeoObject");
					JSONObject obj2 = (JSONObject) obj1.get("metaDataProperty");
					JSONObject obj3 = (JSONObject) obj2.get("GeocoderMetaData");
					System.out.println(obj3.get("text"));
				}
			}

		} catch (URISyntaxException | IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
