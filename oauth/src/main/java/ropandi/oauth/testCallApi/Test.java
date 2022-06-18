package ropandi.oauth.testCallApi;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	     String s = restTemplate.exchange("http://localhost:5000/test", HttpMethod.GET, entity, String.class).getBody();
         System.out.println("data " + s);
         System.out.println("Ok ga"+ s); 
	     
	}

}
