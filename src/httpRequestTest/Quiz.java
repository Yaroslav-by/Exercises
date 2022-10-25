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

	private String question;
	private String answer;
	private Scanner sc;
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public void askAndAnswerQuestion() throws URISyntaxException, IOException, InterruptedException {
		
		sc = new Scanner(System.in);
		
		HttpRequest getRequest = HttpRequest.newBuilder()
				.uri(new URI("http://jservice.io/api/random"))
				.GET()
				.build();
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpResponse<String> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
		
		String jsonResponse = getResponse.body().toString();
        JSONArray array = new JSONArray(jsonResponse);
        JSONObject obj = array.getJSONObject(0);
        
        this.answer = (String) obj.get("answer");
        this.question = (String) obj.get("question") + " " + "(" + this.answer + ")";
        
        sc.close();
        
	}

}
