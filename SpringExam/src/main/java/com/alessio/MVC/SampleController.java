package com.alessio.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
	@GetMapping({"/", "", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/sample")
	public String sample() {
		return "sample";
	}
}
