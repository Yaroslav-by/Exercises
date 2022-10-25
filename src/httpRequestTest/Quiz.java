package httpRequestTest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Quiz {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
		Quiz quiz = new Quiz();
		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		for (int i = 0; i < 8; i++) {
			n += quiz.askAndAnswerQuestion(sc);
		}
		
		System.out.println("You answered " + n + "/8 questions!");
		sc.close();

	}
	
	public int askAndAnswerQuestion(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
		
		HttpRequest getRequest = HttpRequest.newBuilder()
				.uri(new URI("http://jservice.io/api/random"))
				.GET()
				.build();
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpResponse<String> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
		
		String jsonResponse = getResponse.body().toString();
        JSONArray array = new JSONArray(jsonResponse);
        JSONObject obj = array.getJSONObject(0);
		
        System.out.println(obj.get("question") + " (" + obj.get("answer") + ")");
        System.out.print("Enter your answer: ");
        
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals(obj.get("answer").toString().toLowerCase())) {
        	System.out.println("Right you are!");
        	return 1;
        } else {
        	System.out.println("Nope!");
        	return 0;
        }
        
	}

}
