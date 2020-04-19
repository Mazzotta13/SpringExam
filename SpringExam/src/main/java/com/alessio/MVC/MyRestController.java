package com.alessio.MVC;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MyRestController {
	@GetMapping({"/", ""})
	public String getRest() {
		return "test rest...";
	}
}
