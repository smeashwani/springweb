package springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/")
	public String display() {
		
		System.out.println("Controller");
		return "index";
	}
	
	@RequestMapping("/admin")
	public String displayAdmin() {
		
		System.out.println("displayAdmin");
		return "admin";
	}
}
