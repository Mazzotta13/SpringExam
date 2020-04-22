package com.alessio.MVC;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {
	private RestTemplate restTemplate;
	
	public RestTemplateService() {
		restTemplate = new RestTemplate();
	}
	
	
	public String callRest() throws URISyntaxException {
		String id = Math.random()*30000 + "";
		URI url = new URI("http://localhost:8080/rest/pathv/"+id);
		return restTemplate.getForObject(url, String.class);
	}
}
