package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		int i=1;
		System.out.println("LLLLLLLLLLLLLLLLLLLLLLLL"+i++);
		return "login";
	}
	

	
	@GetMapping("/")
	public String home() {
		System.out.println("HOMEEEEEEEEEEEEEEEEEEEEEEE");
		return "index";
	}
	
}