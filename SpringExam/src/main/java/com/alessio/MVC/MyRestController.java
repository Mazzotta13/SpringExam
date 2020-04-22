package com.alessio.MVC;

import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MyRestController {
	
	@Autowired
	private RestTemplateService restTemplateService;
	
	@GetMapping({"/", ""})
	public String getRest() {
		return "test rest...";
	}
	
	@GetMapping({"/pathv/{id}"})
	public String getPathVariable(@PathVariable(name = "id", required = true) String id) {
		return "the ID is: "+id;
	}
	
	@PostMapping(consumes = "application/json", path = {"/requestb"})
	public String postRequestBody(@RequestBody Map<String, Integer> id) {
		System.out.println("id: "+id);
		return "the ID is: "+id;
	}
	
	@GetMapping("/resttemplate")
	public String testRestTemplate() throws URISyntaxException {
		return restTemplateService.callRest();
	}
}
